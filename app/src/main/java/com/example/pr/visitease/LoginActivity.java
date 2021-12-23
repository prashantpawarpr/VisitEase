package com.example.pr.visitease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {



    public void signIn(View view){
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);


        if(username.getText().toString().matches("")&& password.getText().toString().matches("")){
            Toast.makeText(this,"A username and password are required", Toast.LENGTH_SHORT).show();
        }
        else{

            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {

                    if(user !=null){
                        Toast.makeText(LoginActivity.this,"Login Sucessfull ",Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(LoginActivity.this, ScrollingActivity.class);
                        startActivity(intent);
                        finish();

                        username.setText("");
                        password.setText("");

                    }
                    else{
                        Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            // If User is logged in it will open the scrolling activity  following                                 not accurate may be a logical error
    // this code is not working









        TextView skip = (TextView) findViewById(R.id.skip_textview);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(LoginActivity.this, ScrollingActivity.class);
                startActivity(intent);
                finish();

            }
        });


        TextView signup_activity= (TextView)findViewById(R.id.signup_textview);
        signup_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(LoginActivity.this, Signup_Activity.class);
                startActivity(intent);
                finish();

            }

        });

    }
}
