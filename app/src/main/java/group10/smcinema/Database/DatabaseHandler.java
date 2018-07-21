package group10.smcinema.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "CinemaDatabase";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE users " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Username TEXT, " +
                "Password TEXT, " +
                "Fullname TEXT, " +
                "Address TEXT, " +
                "PhoneNumber TEXT) ";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS users";
        db.execSQL(sql);

        onCreate(db);
    }



}