package com.cce.lab5q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class VerificationActivity extends AppCompatActivity {
    private String vType,vehicleNumber, rcNum;
    TextView t1,t2,t3;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        i=getIntent();
        initAll();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void initAll(){
        vType=i.getStringExtra("vehicle_type");
        vehicleNumber=i.getStringExtra("vehicle_number");
        rcNum=i.getStringExtra("rc_number");
        t1=(TextView)findViewById(R.id.type);
        t2=(TextView)findViewById(R.id.vnum);
        t3=(TextView)findViewById(R.id.rcnum);
        t1.setText("Vehicle type: "+vType);
        t2.setText("Vehicle number: "+vehicleNumber);
        t3.setText("Vehicle RC number: "+rcNum);
    }

    public void goBack(View v){
        onBackPressed();
    }
    public void displaytoast(View v){
        Toast.makeText(this,"Vehicle type: "+vType+"\nVehicle number: "+vehicleNumber+"\nVehicle RC number: "+rcNum, Toast.LENGTH_LONG).show();
        Intent j=new Intent(this, MainActivity.class);
        j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(j);
    }
}
