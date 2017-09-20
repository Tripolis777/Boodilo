package com.android.tripolis.boodilo.Database.Task;

import android.content.Context;

import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Query.InsertQuery;
import com.android.tripolis.boodilo.Database.Response.InsertResponse;

/**
 * Created by v.karyagin on 9/19/17.
 */

public class DatabaseUpdateTask extends DatabaseTask<InsertQuery, Integer, InsertResponse> {

    private final Context context;
    private final BooDBOpenHelper dbOpenHelper;

    public DatabaseUpdateTask(Context context, TaskListener<InsertResponse> taskListener) {
        super(taskListener);
        this.context = context;

        this.dbOpenHelper = BooDBOpenHelper.getInstance(context, null);
    }

    @Override
    protected InsertResponse doInBackground(InsertQuery... insertQueries) {
        return null;
    }
}
