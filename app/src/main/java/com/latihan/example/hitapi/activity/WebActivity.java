package com.latihan.example.hitapi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.latihan.example.hitapi.R;

/**
 * Created by Alvin on 28/06/2015.
 */
public class WebActivity extends Activity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv = new WebView(this);
        setContentView(wv);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            url = extras.getString("targetUrl");
        }

        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
    }
}
