package com.cce.lab2q3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        editText=(EditText)findViewById(R.id.url_text);
        webView=(WebView)findViewById(R.id.webview);
    }
    public void cancelURL(View view){
        editText.setText("");
    }
    public void launchURL(View view){
        if(editText.getText().toString().isEmpty()){
            AlertDialog alertDialog = new AlertDialog.Builder(WebActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("URL missing");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }else {
            webView.setVisibility(View.VISIBLE);
            webView.loadUrl(editText.getText().toString());
        }
    }
}
