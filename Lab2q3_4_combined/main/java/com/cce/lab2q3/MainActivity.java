package com.cce.lab2q3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate","onCreate invoked");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","onResume invoked");
    }
    public void next(View view){
        Intent intent=new Intent(MainActivity.this,WebActivity.class);
        startActivity(intent);
    }
}
