package com.android.tripolis.boodilo.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tripolis.boodilo.R;

/**
 * Created by v.karyagin on 23.08.2017.
 */

public class AlarmsListFragment extends Fragment {
    private ListView alarmsList;

    private TextView testTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarms_list_fragment, container, false);

        testTextView = (TextView) rootView.findViewById(R.id.alarmListTest);
        testTextView.setText("Is Work!");
        return rootView;
    }
}
