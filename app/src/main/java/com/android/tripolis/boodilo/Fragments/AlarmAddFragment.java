package com.android.tripolis.boodilo.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tripolis.boodilo.Database.Response.InsertResponse;
import com.android.tripolis.boodilo.Database.Task.DatabaseInsertTask;
import com.android.tripolis.boodilo.Database.Task.TaskListener;
import com.android.tripolis.boodilo.R;

/**
 * Created by v.karyagin on 8/20/17.
 */

public class AlarmAddFragment extends Fragment {

    private EditText timeEditText;
    private Button acceptTimeButton;
    private Button cancelTimeButton;

    private DatabaseInsertTask insertTask;

    private class OnAcceptBtnClickListener implements View.OnClickListener {

        private final Context context;

        public OnAcceptBtnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            insertTask = createInsertTask(context);
        }
    }

    private class OnCancelBtnClickListener implements View.OnClickListener {
        private final Context context;

        public OnCancelBtnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

        }
    }

    public static AlarmAddFragment newInstance() {
        Bundle args = new Bundle();

        AlarmAddFragment fragment = new AlarmAddFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarm_add_fragment, container, false);

        timeEditText = (EditText) rootView.findViewById(R.id.editTime);
        acceptTimeButton = (Button) rootView.findViewById(R.id.acceptTimeButton);
        cancelTimeButton = (Button) rootView.findViewById(R.id.cancelTimeButton);

        Context context = this.getContext();
        acceptTimeButton.setOnClickListener(new OnAcceptBtnClickListener(context));
        cancelTimeButton.setOnClickListener(new OnCancelBtnClickListener(context));

        return rootView;
    }

    @Override
    public void onDestroyView() {
        if (insertTask != null)
            insertTask.cancel(true);

        super.onDestroyView();
    }

    private DatabaseInsertTask createInsertTask(Context context) {
        return new DatabaseInsertTask(context, new TaskListener<InsertResponse>() {
            @Override
            public void onSuccess(InsertResponse result) {

            }

            @Override
            public void onError() {

            }
        });
    }
}
