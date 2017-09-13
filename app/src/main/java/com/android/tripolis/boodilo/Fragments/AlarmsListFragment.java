package com.android.tripolis.boodilo.Fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tripolis.boodilo.Adapters.AlarmListAdapter;
import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;
import com.android.tripolis.boodilo.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by v.karyagin on 23.08.2017.
 */

public class AlarmsListFragment extends Fragment {

    private ListView alarmsList;

    public static AlarmsListFragment newInstance() {
        return new AlarmsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarms_list_fragment, container, false);

        final Context context = getContext();

        alarmsList = (ListView) rootView.findViewById(R.id.alarmsListView);

        alarmsList.setAdapter(new AlarmListAdapter(context, new ArrayList<AlarmEntry>()));

        return rootView;
    }
}
