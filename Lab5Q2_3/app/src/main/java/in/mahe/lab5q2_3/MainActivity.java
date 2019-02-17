package in.mahe.lab5q2_3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner source,destination;
    String dest,src;
    TextView date,time;
    ToggleButton tatkalTB;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.destinations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        source.setAdapter(adapter);
        destination.setAdapter(adapter);

        source.setOnItemSelectedListener(this);
        destination.setOnItemSelectedListener(this);
    }
    private void initViews(){
        source=findViewById(R.id.spin_source);
        source.setSelected(false);
        destination=findViewById(R.id.spin_dest);
        destination.setSelected(false);
        date=findViewById(R.id.date_textview);
        time=findViewById(R.id.time_textview);
        tatkalTB=findViewById(R.id.tatkal_toggle);
        time.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        date.setText(new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date()));
        tatkalTB.setChecked(false);
    }
    public void setJourneyTime(View v){
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        time.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void setJourneyDate(View v){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void reset(View v){
        source.setSelected(false);
        destination.setSelected(false);
        time.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        date.setText(new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date()));
        tatkalTB.setChecked(false);
    }
    public void submit(View v){
        Intent i=new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("destination", dest);
        i.putExtra("source", src);
        i.putExtra("time", time.getText().toString());
        i.putExtra("date", date.getText().toString());
        if(tatkalTB.isChecked()){
            if(Integer.parseInt(time.getText().toString().substring(0,2))>=11 && !(src.equals(dest))){
                i.putExtra("tatkal", true);
                startActivity(i);
            }else if(src.equals(dest)){
                Toast.makeText(this,"Source and destination cannot be same", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"For Tatkal, you can submit only after 1100 hours", Toast.LENGTH_LONG).show();
            }
        }else if(src.equals(dest)){
            Toast.makeText(this,"Source and destination cannot be same", Toast.LENGTH_LONG).show();
        }else{
            i.putExtra("tatkal", false);
            startActivity(i);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
        String item= parent.getItemAtPosition(pos).toString();
        switch (parent.getId())
        {
            case R.id.spin_dest:
                dest=item;
                break;

            case R.id.spin_source:
                src=item;
                break;
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
