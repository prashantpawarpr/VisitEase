package com.example.pr.visitease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class myAccount extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        EditText firstEditText = (EditText) findViewById(R.id.firstEditText);
        EditText lastEditText = (EditText) findViewById(R.id.lastEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);


        firstEditText.setEnabled(false);
        lastEditText.setEnabled(false);
        emailEditText.setEnabled(false);
        phoneEditText.setEnabled(false);





        ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
        query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null&&objects != null){

                    emailEditText.setText(ParseUser.getCurrentUser().getUsername());

                }
            }
        });


    }
}