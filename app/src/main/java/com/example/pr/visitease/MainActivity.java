package com.example.pr.visitease;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




















        CardView rg_card_cardview = (CardView)findViewById(R.id.home_cardview);
        rg_card_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview_rgpv.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });

        CardView notice_cardview = (CardView)findViewById(R.id.notice_cardview);
        notice_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview_rgpv.class);
                intent.putExtra("id",2);
                startActivity(intent);
            }
        });

        CardView registration_cardview = (CardView) findViewById(R.id.registration_cardview);
        registration_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview_rgpv.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });




        CardView result_cardview =(CardView) findViewById(R.id.result_cardview);
        result_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview_rgpv.class);
                intent.putExtra("id",4);
                startActivity(intent);
            }
        });



        CardView paper_cardview = (CardView)findViewById(R.id.paper_cardview);
        paper_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Paper.class);
                intent.putExtra("id",5);
                startActivity(intent);


            }
        });




        CardView support_cardview =(CardView)findViewById(R.id.support_cardview);
        support_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview_rgpv.class);
                intent.putExtra("id",6);
                startActivity(intent);

            }
        });






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent= new Intent(MainActivity.this,ScrollingActivity.class );
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_myaccount) {

            Intent intent = new Intent(this , myAccount.class);
            startActivity(intent);

        } else if (id == R.id.nav_password) {
            Intent intent = new Intent(this, changePassword.class);
            startActivity(intent);

        }






//        else if (id == R.id.nav_manage) {
//
//        }













        else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "PRASHANT PAWAR.");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

        } else if (id == R.id.nav_logout){

            // DOWN This code has logical error

            if(ParseUser.getCurrentUser()!=null){

                ParseUser.logOut();
                Toast.makeText(this,"User Logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);

            }


            else if(ParseUser.getCurrentUser()==null){

                Toast.makeText(this,"User Logged out", Toast.LENGTH_SHORT).show();
            }

            // UP this code has logical error

        }else if(id==R.id.nav_contactus){

            Intent intent = new Intent(this , contactUs.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
