package com.android.tripolis.boodilo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.tripolis.boodilo.Adapters.AlarmListAdapter;
import com.android.tripolis.boodilo.Core.Alarm;
import com.android.tripolis.boodilo.Fragments.AlarmAddFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView alarmsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //alarmsList = (ListView) findViewById(R.id.alarmsList);
        //alarmsList.setAdapter(new AlarmListAdapter(getApplicationContext(), new ArrayList<Alarm>()));
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
        FragmentManager fm = getFragmentManager();


        switch (item.getItemId()) {
            case R.id.action_favorite:
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                AlarmAddFragment fragment = new AlarmAddFragment();
                fragmentTransaction.add(R.id.fragment2, fragment, "AlarmAddFragment");
                fragmentTransaction.commit();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
