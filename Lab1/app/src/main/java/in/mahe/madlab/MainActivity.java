package in.mahe.madlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    String s1="",s2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.first_name);
        et2=(EditText)findViewById(R.id.last_name);
    }
    public void nextActivity(View v){
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        if(s1.isEmpty())
            s1="";
        if(s2.isEmpty())
            s2="";
        Intent i=new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("first",s1);
        i.putExtra("last",s2);
        startActivity(i);
    }
}
