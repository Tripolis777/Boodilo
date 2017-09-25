package com.android.tripolis.boodilo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.tripolis.boodilo.Core.Alarm;
import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;
import com.android.tripolis.boodilo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by v.karyagin on 8/20/17.
 */

public class AlarmListAdapter extends ArrayAdapter<AlarmEntry> {

    private final Context context;
    private ArrayList<AlarmEntry> values;

    static class ViewHolder {
        TextView alarmTime;
        ToggleButton alarmStatusButton;
    }

    public AlarmListAdapter(@NonNull Context context, ArrayList<AlarmEntry> values) {
        super(context, R.layout.item_alarm, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_alarm, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.alarmTime = (TextView) convertView.findViewById(R.id.alarmTime);
            viewHolder.alarmStatusButton = (ToggleButton) convertView.findViewById(R.id.alarmStatusButton);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        AlarmEntry value = values.get(pos);
        viewHolder.alarmTime.setText(value.getTime());
        viewHolder.alarmStatusButton.setChecked(value.getStatus() == Alarm.AlarmStatus.STATUS_ON);

        return convertView;
    }
}
