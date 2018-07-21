package group10.smcinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import group10.smcinema.Database.TableControllerUsers;
import group10.smcinema.Objects.User;


public class RegisterActivity extends AppCompatActivity {

    EditText    UsernameField,
            PasswordField,
            FullnameField,
            AddressField,
            PhoneNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // Reference views
        UsernameField = findViewById(R.id.UsernameField);
        PasswordField = findViewById(R.id.PasswordField);
        FullnameField = findViewById(R.id.Fullnamefield);
        AddressField = findViewById(R.id.AddressField);
        PhoneNumberField = findViewById(R.id.PhoneNumberField);


    }


    //Register Click
    public void RegisterClick(View v){

        // Create a new user
        User user = new User();
        user.Username = UsernameField.getText().toString();
        user.Password = PasswordField.getText().toString();
        user.Fullname = FullnameField.getText().toString();
        user.Address = AddressField.getText().toString();
        user.PhoneNumber = PhoneNumberField.getText().toString();

        boolean createSuccessful = new TableControllerUsers(this).create(user);

        if(createSuccessful){
            Toast.makeText(this, "Student information was saved.", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else{
            Toast.makeText(this, "Unable to save student information.", Toast.LENGTH_SHORT).show();
        }



    }

}