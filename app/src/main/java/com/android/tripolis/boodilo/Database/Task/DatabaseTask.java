package com.android.tripolis.boodilo.Database.Task;

import android.os.AsyncTask;

/**
 * Created by v.karyagin on 9/19/17.
 */

public abstract class DatabaseTask<T, G, P> extends AsyncTask<T, G, P> {

    protected final TaskListener taskListener;

    public DatabaseTask(TaskListener taskListener) {
        super();

        this.taskListener = taskListener;
    }

    @Override
    protected void onPostExecute(P result) {
        if (result == null) {
            taskListener.onError();
        } else {
            taskListener.onSuccess(result);
        }
    }
}
