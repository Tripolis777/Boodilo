package com.android.tripolis.boodilo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.android.tripolis.boodilo.Fragments.AlarmAddFragment;
import com.android.tripolis.boodilo.Fragments.AlarmsListFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView alarmsList;

    private FrameLayout fragmentPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_placeholder, AlarmsListFragment.newInstance(), "alarmList")
                    .commit();
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        FragmentManager fm = getSupportFragmentManager();


        switch (item.getItemId()) {
            case R.id.action_add_alarm:
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                AlarmAddFragment fragment = new AlarmAddFragment();
                fragmentTransaction.replace(R.id.fragment_placeholder, fragment, "alarmAdd");
                fragmentTransaction.commit();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
