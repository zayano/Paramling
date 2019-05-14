package com.example.zayano.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ModelGayaRambut extends AppCompatActivity {
    private static final String URL = "http://penatarambut.com/model-gaya-rambut-pria/";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_gaya_rambut);
        webView = (WebView) findViewById(R.id.activity_model_gaya_rambut);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("http://penatarambut.com/model-gaya-rambut-pria/");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;

        } return super.onKeyDown(keyCode, event);
    }
    private void finishApp() {
        finish();
        moveTaskToBack(true);
    }
}


