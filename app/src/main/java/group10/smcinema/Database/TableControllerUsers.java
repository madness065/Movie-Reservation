package group10.smcinema.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import group10.smcinema.Objects.User;

public class TableControllerUsers extends DatabaseHandler {

    public TableControllerUsers(Context context) {
        super(context);
    }

    public boolean create(User user) {

        ContentValues values = new ContentValues();

        values.put("Username", user.Username);
        values.put("Password", user.Password);
        values.put("Fullname", user.Fullname);
        values.put("Address", user.Address);
        values.put("PhoneNumber", user.PhoneNumber);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("users", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public User read(String username) {

        User user = new User();

        List<User> recordsList = new ArrayList<User>();

        String sql = "SELECT * FROM users WHERE Username = '" + username + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                user.Username = cursor.getString(cursor.getColumnIndex("Username"));
                user.Password = cursor.getString(cursor.getColumnIndex("Password"));
                user.Fullname = cursor.getString(cursor.getColumnIndex("Fullname"));
                user.Address = cursor.getString(cursor.getColumnIndex("Address"));
                user.Password = cursor.getString(cursor.getColumnIndex("Password"));
                user.PhoneNumber = cursor.getString(cursor.getColumnIndex("PhoneNumber"));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return user;
    }

    public int updateUser(User user)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", user.getUsername());
        cv.put("password", user.getPassword());

        return db.update("users", cv, "id" + "= ?", new String[]{String.valueOf(user.getUserID())});
    }
}