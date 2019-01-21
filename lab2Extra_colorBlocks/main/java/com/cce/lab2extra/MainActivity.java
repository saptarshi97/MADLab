package com.cce.lab2extra;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout redFrame, greenFrame;
    LinearLayout blueLayout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void redButton(View view) {
        redFrame.setBackgroundColor(Color.RED);
    }

    public void greenButton(View view) {
        greenFrame.setBackgroundColor(Color.GREEN);
    }

    public void blueButton(View view) {
        blueLayout.setBackgroundColor(Color.BLUE);
    }

    public void clearButton(View view) {
        blueLayout.setBackgroundColor(Color.WHITE);
        redFrame.setBackgroundColor(Color.WHITE);
        blueLayout.setBackgroundColor(Color.WHITE);
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("All colors cleared");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    public void nextButton(View view) {
        intent=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    private void initViews() {
        redFrame = (FrameLayout) findViewById(R.id.frame_red);
        greenFrame = (FrameLayout) findViewById(R.id.frame_green);
        blueLayout = (LinearLayout) findViewById(R.id.llayout_blue);
    }

}
