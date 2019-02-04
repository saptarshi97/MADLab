package in.mahe.lab3q3;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
        setupTabLayout();
    }
    private void setupTabLayout() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabTapped(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabTapped(tab.getPosition());
            }
        });
    }

    private void onTabTapped(int position) {
        switch (position) {
            case 0:
                textView.setText("This is Artists Tab");
                break;
            case 1:
                textView.setText("This is Albums Tab");
                break;
            case 2:
                textView.setText("This is Songs Tab");
                break;
            default:
                Toast.makeText(this, "Tapped " + position, Toast.LENGTH_SHORT);
        }
    }
}
