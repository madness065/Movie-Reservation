package group10.smcinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import group10.smcinema.Objects.User;

public class AllUserActivity extends AppCompatActivity {
    TextView TVWelcome;
    static User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);
        TVWelcome = (TextView) findViewById(R.id.txtViewWelcome);
        TVWelcome.setText("Welcome "+user.getFullname());
    }
    public void gotoShowProfileuserActivity(View v)
    {
        Intent intent = new Intent(this, ShowProfileUserActivity.class);
        startActivity(intent);
    }
}
