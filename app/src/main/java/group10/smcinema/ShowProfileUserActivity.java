package group10.smcinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import group10.smcinema.Objects.User;

public class ShowProfileUserActivity extends AppCompatActivity {

    TextView TVFullname,TVAddress,TVPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile_user);
        FindTextViewshit();
        setTexttoAll();

    }
    public void gotoAllUserAcivity(View v)
    {
        Intent intent = new Intent(this, AllUserActivity.class);
        startActivity(intent);
    }
    public void gotoEditProfileUser(View v)
    {
        Intent intent = new Intent (this, EditProfileUserActivity.class);
        startActivity(intent);
    }
    public void FindTextViewshit()
    {
        TVFullname = (TextView) findViewById(R.id.textViewFullName);
        TVAddress = (TextView) findViewById(R.id.textViewAddress);
        TVPhone = (TextView) findViewById(R.id.textViewPhone);
    }
    public void setTexttoAll()
    {
        User user = new User();
        TVFullname.setText(user.getFullname());
        TVAddress.setText(user.getAddress());
        TVPhone.setText(user.getPhoneNumber());
    }
}
