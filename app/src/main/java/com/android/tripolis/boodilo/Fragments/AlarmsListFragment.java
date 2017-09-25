package com.android.tripolis.boodilo.Fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tripolis.boodilo.Adapters.AlarmListAdapter;
import com.android.tripolis.boodilo.Core.Alarm;
import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;
import com.android.tripolis.boodilo.Database.Query.SimpleSelectQuery;
import com.android.tripolis.boodilo.Database.Response.AlarmSelectResponseFactory;
import com.android.tripolis.boodilo.Database.Response.SelectResponse;
import com.android.tripolis.boodilo.Database.Task.DatabaseSelectTask;
import com.android.tripolis.boodilo.Database.Task.TaskListener;
import com.android.tripolis.boodilo.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by v.karyagin on 23.08.2017.
 */

public class AlarmsListFragment extends Fragment {

    private ListView alarmsList;
    private AlarmListAdapter alarmListAdapter;
    private DatabaseSelectTask selectTask;

    public static AlarmsListFragment newInstance() {
        return new AlarmsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarms_list_fragment, container, false);

        final Context context = getContext();

        alarmListAdapter = new AlarmListAdapter(context, new ArrayList<AlarmEntry>());

        alarmsList = (ListView) rootView.findViewById(R.id.alarmsListView);
        alarmsList.setAdapter(alarmListAdapter);

        selectTask = this.initSelectAlarmTask(context);
        selectTask.execute(new SimpleSelectQuery(AlarmEntry.AlarmSchema.TABLE_NAME));

        return rootView;
    }

   @Override
    public void onDestroyView() {
        if (selectTask != null)
            selectTask.cancel(true);

        super.onDestroyView();
   }

   @NonNull
   private DatabaseSelectTask initSelectAlarmTask(Context context) {
       return new DatabaseSelectTask(context, new TaskListener<SelectResponse>() {
           @Override
           public void onSuccess(SelectResponse result) {
                alarmListAdapter.addAll(result.getAll());
                alarmListAdapter.notifyDataSetChanged();
           }

           @Override
           public void onError() {

           }
       }, new AlarmSelectResponseFactory());
   }
}
