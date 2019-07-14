package com.example.alcchallenge;

import android.drm.DrmStore;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    WebView webView;
    String URL;
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        bar = getSupportActionBar();
        bar.setTitle("About ALC");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        bar.setDisplayShowTitleEnabled(true);

        webView = findViewById(R.id.alc_about_site_web);
        URL = getIntent().getStringExtra("url");

        webView.setWebChromeClient(new MyBrowers());
        webView.setWebViewClient(new MyClient());
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(URL);
            }
        }, 500);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    private class MyBrowers extends WebChromeClient {

    }


    private class MyClient extends WebViewClient {
        public MyClient() {
            super();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(URL);
                }
            }, 500);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}