package com.example.pr.visitease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview_rgpv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_rgpv);
        WebView webview= (WebView)findViewById(R.id.web);

        Integer link = (Integer) getIntent().getExtras().get("id");

        webview.setWebViewClient(new WebViewClient());



        webview.getSettings().setJavaScriptEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        if(link==1){
            webview.loadUrl("https://www.rgpv.ac.in/");}
        if(link==2){
            webview.loadUrl("https://www.rgpvdiploma.in/AboutUs/More.aspx");
        }
        if(link==3){
            webview.loadUrl("https://www.rgpv.ac.in/Stu/StudentRegSubscription.aspx");
        }
        if(link==4){
            webview.loadUrl("http://result.rgpv.ac.in/result/programselect.aspx?id=$%");
        }


        // if(link==3){
        //   webview.loadUrl("https://www.rgpvdiploma.in/AboutUs/More.aspx");
        //}



        if(link==6){
            webview.loadUrl("https://www.rgpv.ac.in/meetvc/index.html");
        }



    }
}
