package group10.smcinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import group10.smcinema.Database.TableControllerUsers;
import group10.smcinema.Objects.User;

public class EditProfileUserActivity extends AppCompatActivity {

    EditText editFullname,editAddress,editPhone,editPassword;
    String fullname,address,phonenumber,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_user);
        assigning();
    }

    public void editButton(View v)
    {
        getEditText();
        User user = new User();
        user.setFullname(fullname);
        user.setAddress(address);
        user.setPassword(password);
        user.setPhoneNumber(phonenumber);

        AllUserActivity.user = user;
        new TableControllerUsers(this).updateUser(user);
        gobacktoShowProfileUser();

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
    public void getEditText()
    {
        fullname = editFullname.getText().toString();
        address = editAddress.getText().toString();
        phonenumber = editPhone.getText().toString();
        password = editPassword.getText().toString();
    }
}
