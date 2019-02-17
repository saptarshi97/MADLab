package in.mahe.lab6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.faculty:
                startActivity(new Intent(this, FacultyActivity.class));
                break;
            case R.id.courses:
                startActivity(new Intent(this, CoursesActivity.class));
                break;
            case R.id.admissions:
                setContentView(R.layout.admissions_layout);
                break;
            case R.id.about_us:
                setContentView(R.layout.about_us_layout);
                break;
            case R.id.contact_us:
                setContentView(R.layout.contact_us_layout);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
