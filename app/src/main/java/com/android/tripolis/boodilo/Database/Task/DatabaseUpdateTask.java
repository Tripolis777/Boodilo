package com.android.tripolis.boodilo.Database.Task;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Query.InsertQuery;
import com.android.tripolis.boodilo.Database.Query.UpdateQuery;
import com.android.tripolis.boodilo.Database.Response.InsertResponse;
import com.android.tripolis.boodilo.Database.Response.UpdateResponse;

/**
 * Created by v.karyagin on 9/19/17.
 */

public class DatabaseUpdateTask extends DatabaseTask<UpdateQuery, Integer, UpdateResponse> {

    private final Context context;
    private final BooDBOpenHelper dbOpenHelper;

    public DatabaseUpdateTask(Context context, TaskListener<UpdateResponse> taskListener) {
        super(taskListener);
        this.context = context;

        this.dbOpenHelper = BooDBOpenHelper.getInstance(context, null);
    }

    @Override
    protected UpdateResponse doInBackground(UpdateQuery... updateQueries) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        if (db.inTransaction()) {
            Log.e("UpdateDatabaseTask", "An open transaction was detected.");
            return null;
        }

        UpdateResponse result = null;
        db.beginTransaction();
        try {

            if (updateQueries.length > 0) {

                UpdateQuery query = updateQueries[0];
                int affectedCount = db.update(query.getTableName(), query.getValues(), query.getWhereSQL(), null);
                result = new UpdateResponse(affectedCount);

                db.setTransactionSuccessful();
            }

        } catch (SQLException e) {
            Log.e("UpdateDatabaseTask", "Transaction failed: " + e.getMessage());
        } finally {
            db.endTransaction();
        }

        return result;
    }
}
