package in.mahe.madlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i=getIntent();
        t1=(TextView)findViewById(R.id.first_text);
        t2=(TextView)findViewById(R.id.last_text);
        t1.setText(i.getStringExtra("first"));
        t2.setText(i.getStringExtra("last"));
    }
}
