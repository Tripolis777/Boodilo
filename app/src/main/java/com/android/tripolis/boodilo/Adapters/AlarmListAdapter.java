package com.android.tripolis.boodilo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.android.tripolis.boodilo.Core.Alarm;
import com.android.tripolis.boodilo.R;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 8/20/17.
 */

public class AlarmListAdapter extends ArrayAdapter<Alarm> {

    public AlarmListAdapter(@NonNull Context context, ArrayList<Alarm> values) {
        super(context, R.layout.item_alarm, values);
    }
}
