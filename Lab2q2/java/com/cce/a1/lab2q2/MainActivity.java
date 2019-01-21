package com.cce.a1.lab2q2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Double num1=0.0,num2=0.0, result=0.0;
    String sendText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(MainActivity.this, SecondActivity.class);
        editText1=(EditText)findViewById(R.id.edit_text1);
        editText2=(EditText)findViewById(R.id.edit_text2);
    }
    public boolean validateForm(){
        if(editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()){
            if(editText1.getText().toString().isEmpty())
                editText1.requestFocus();
            else
                editText2.requestFocus();
        }else {
            num1 = Double.parseDouble(editText1.getText().toString());
            num2 = Double.parseDouble(editText2.getText().toString());
            return true;
        }
        return false;
    }
    public void plus(View view){
        if(validateForm()) {
            result=num1+num2;
            sendText = num1 + "+" + num2;
            intent.putExtra("key", sendText);
            startActivity(intent);
        }
    }
    public void minus(View view){
        if(validateForm()) {
            result=num1-num2;
            sendText = num1 + "-" + num2;
            intent.putExtra("key", sendText);
            startActivity(intent);
        }
    }
    public void product(View view){
        if(validateForm()) {
            result=num1*num2;
            sendText = num1 + "*" + num2;
            intent.putExtra("key", sendText);
            startActivity(intent);
        }
    }
    public void divide(View view){
        if(validateForm()) {
            result=num1/num2;
            sendText = num1 + "/" + num2;
            intent.putExtra("key", sendText);
            startActivity(intent);
        }
    }
}
