package in.mahe.lab5q2_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private  TextView time,date,src,destination,tatkal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i=getIntent();
        initViews();
        src.setText("Source: "+i.getStringExtra("source"));
        destination.setText("Destination: "+i.getStringExtra("destination"));
        time.setText("Time: "+i.getStringExtra("time"));
        date.setText("Date: "+i.getStringExtra("date"));
        if(i.getBooleanExtra("tatkal",false)){
            tatkal.setText("Tatkal: Yes");
        }else{
            tatkal.setText("Tatkal: No");
        }
    }
    private void initViews(){
        time=findViewById(R.id.time_txt);
        date=findViewById(R.id.date_txt);
        src=findViewById(R.id.src_txt);
        destination=findViewById(R.id.dst_txt);
        tatkal=findViewById(R.id.ttk);
    }
}
