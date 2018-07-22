package group10.smcinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfileUserActivity extends AppCompatActivity {

    EditText editFullname,editAddress,editPhone,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_user);
        assigning();
    }

    public void editButton(View v)
    {
        gobacktoShowProfileUser();
        // code or method for updating data
    }
    public void gobacktoShowProfileUser()
    {
        Intent intent = new Intent(this, ShowProfileUserActivity.class);
        startActivity(intent);
    }
    public void assigning()
    {
        editFullname = (EditText) findViewById(R.id.editTextFullname);
        editAddress =(EditText) findViewById(R.id.editTextAddress);
        editPhone = (EditText) findViewById(R.id.editTextPhone);
        editPassword = (EditText) findViewById(R.id.editTextPassword);
    }

}
