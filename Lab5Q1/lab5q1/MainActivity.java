package com.cce.lab5q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText vNumber,rcNumber;
    Spinner typeSpinner;
    private String vType,vehicleNumber, rcNum;
    boolean typeFlag=false;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        vType=(String)parent.getItemAtPosition(pos);
        typeFlag=true;
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg) {
        typeFlag=false;
    }

    public void initViews(){
        vNumber=(EditText)findViewById(R.id.vehicle_number);
        rcNumber=(EditText)findViewById(R.id.rc_number);
        typeSpinner=(Spinner)findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicle_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
    }
    public boolean validate(){
        if(vNumber.getText().toString().isEmpty() && rcNumber.getText().toString().isEmpty() && typeFlag)
            return true;
        return false;
    }

    public void submit(View view){
        i=new Intent(this,VerificationActivity.class);
        if (validate()) {
            i.putExtra("vehicle_number",vNumber.getText().toString());
            i.putExtra("rc_number",rcNumber.getText().toString());
            i.putExtra("vehicle_type",vType);
            startActivity(i);
        }
    }
}
