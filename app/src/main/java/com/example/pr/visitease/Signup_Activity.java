package com.example.pr.visitease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class Signup_Activity extends AppCompatActivity {

    public void signUp(View view){
        EditText firstEditText = (EditText) findViewById(R.id.firstEditText);
        EditText lastEditText = (EditText) findViewById(R.id.lastEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);


        if(firstEditText.getText().toString().matches("") && lastEditText.getText().toString().matches("") && emailEditText.getText().toString().matches("")
        && phoneEditText.getText().toString().matches("")&&passwordEditText.getText().toString().matches("")){

            Toast.makeText(this,"Some fields are missing",Toast.LENGTH_SHORT).show();

        }else{


            ParseUser user = new ParseUser();
            user.setUsername(emailEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());










            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){

                        Toast.makeText(Signup_Activity.this,"Registered",Toast.LENGTH_SHORT).show();


                        // Open Login windows and ask user to login

                        Intent intent = new Intent(Signup_Activity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();




                        //clear text
                        firstEditText.setText("");
                        lastEditText.setText("");
                        emailEditText.setText("");
                        phoneEditText.setText("");
                        passwordEditText.setText("");



                    }else{


                        Toast.makeText(Signup_Activity.this , e.getMessage(),Toast.LENGTH_SHORT).show();



                    }
                }
            });





        }









    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_signup_);

        TextView signin_activity = (TextView) findViewById(R.id.signin_textview);
        signin_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }
}
