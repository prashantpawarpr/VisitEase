package com.example.pr.visitease;


import android.app.Application;
import android.util.Log;


import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myappID")
                .clientKey("3GRvFIbiuRtB")
                .server("http://18.118.167.241/parse/")
                .build()
        );















//
//        ParseObject object = new ParseObject("ExampleObject");
//        object.put("myNumber", "0000000");
//        object.put("myString", "alshifa asdf kousar");
//
//        object.saveInBackground(new SaveCallback () {
//            @Override
//            public void done(ParseException ex) {
//                if (ex == null) {
//                    Log.i("Parse Result", "Successful!");
//                } else {
//                    Log.i("Parse Result", "Failed" + ex.toString());
//                }
//            }
//        });


        ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}
