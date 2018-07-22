package group10.smcinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import group10.smcinema.Database.TableControllerUsers;
import group10.smcinema.Objects.User;

public class MainActivity extends AppCompatActivity {

    EditText UsernameField, PasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Register Button Click
    public void CreateNewAccountClick(View v){

        startActivity(new Intent(this, RegisterActivity.class));

    }

    public void LoginClick(View v){
        try
        {
            UsernameField = findViewById(R.id.UsernameField);
            PasswordField = findViewById(R.id.PasswordField);

            User user = new TableControllerUsers(this).read(UsernameField.getText().toString());

            if(user.Password.equals(PasswordField.getText().toString())){
                AllUserActivity.user = user;
                Toast.makeText(this,"User " + user.Fullname + " has logged in successfully",Toast.LENGTH_LONG).show();
                gotoAllUser();
                user.setFullname(user.Fullname); //nothing actually; testing and stuff :D
            }
            else
                Toast.makeText(this,"Wrong Password",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Please input your Username and Password",Toast.LENGTH_SHORT).show();
        }

    }
    public void gotoAllUser()
    {
        Intent intent = new Intent(this, AllUserActivity.class);
        startActivity(intent);
    }
}
