package com.android.tripolis.boodilo.Database.Task;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Request.SelectRequest;
import com.android.tripolis.boodilo.Database.Response.SelectResponse;
import com.android.tripolis.boodilo.Database.Response.SelectResponseFactory;

/**
 * Created by v.karyagin on 9/12/17.
 */

public class DatabaseSelectTask extends AsyncTask<SelectRequest, Integer, SelectResponse> {

    private final Context context;
    private final BooDBOpenHelper dbOpenHelper;
    private final TaskListener<SelectResponse> taskListener;
    private final SelectResponseFactory factory;

    public DatabaseSelectTask (Context context, TaskListener<SelectResponse> taskListener, SelectResponseFactory factory) {
        super();
        this.context = context;
        this.taskListener = taskListener;
        this.factory = factory;

        dbOpenHelper = BooDBOpenHelper.newInstance(context, null);
    }

    @Override
    protected SelectResponse doInBackground(SelectRequest... selectRequests) {
        SelectResponse result = null;

        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        SelectRequest simpleSelectRequest = selectRequests[0];
        if (simpleSelectRequest != null) {
            Cursor cursor = db.query(
                    simpleSelectRequest.getDistinct(),
                    simpleSelectRequest.getTableName(),
                    simpleSelectRequest.getColumns(),
                    simpleSelectRequest.getWhereSQL(),
                    null,
                    simpleSelectRequest.getGroupBy(),
                    simpleSelectRequest.getHaving(),
                    simpleSelectRequest.getOrderBy(),
                    simpleSelectRequest.getLimit()
            );
            result = factory.getSelectResponse(cursor);
            cursor.close();
        }

        return result;
    }

    @Override
    protected void onPostExecute(SelectResponse result) {
        if (result == null) {
            taskListener.onError();
        } else {
            taskListener.onSuccess(result);
        }
    }
}
