package com.android.tripolis.boodilo.Database.Task;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Query.SelectQuery;
import com.android.tripolis.boodilo.Database.Response.SelectResponse;
import com.android.tripolis.boodilo.Database.Response.SelectResponseFactory;

/**
 * Created by v.karyagin on 9/12/17.
 */

public class DatabaseSelectTask extends DatabaseTask<SelectQuery, Integer, SelectResponse> {

    private final Context context;
    private final BooDBOpenHelper dbOpenHelper;
    private final SelectResponseFactory factory;

    public DatabaseSelectTask (Context context, TaskListener<SelectResponse> taskListener, SelectResponseFactory factory) {
        super(taskListener);
        this.context = context;
        this.factory = factory;

        dbOpenHelper = BooDBOpenHelper.getInstance(context, null);
    }

    @Override
    protected SelectResponse doInBackground(SelectQuery... selectRequests) {
        SelectResponse result = null;

        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        SelectQuery simpleSelectRequest = selectRequests[0];
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
}
