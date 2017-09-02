package com.android.tripolis.boodilo.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.tripolis.boodilo.R;

/**
 * Created by v.karyagin on 8/20/17.
 */

public class AlarmAddFragment extends Fragment {

    private TextView alarmText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarm_add_fragment, container, false);
        alarmText = (TextView) rootView.findViewById(R.id.alarmAddTextView);
        alarmText.setText("Test is WORK!!!");
        return rootView;
    }

}
