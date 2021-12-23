package com.example.pr.visitease;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.parse.ParseUser;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        if(ParseUser.getCurrentUser()==null){


            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();




//        }
//        else {
//
//
//
//            Intent intent = new Intent(this,ScrollingActivity.class);
//            startActivity(intent);
//            finish();
//
//            String user= ParseUser.getCurrentUser().getUsername();
//
//            // test toast
//
//            Toast.makeText(this,"User Logged in \n " + user, Toast.LENGTH_SHORT).show();
//
//        }
//



    }
}
