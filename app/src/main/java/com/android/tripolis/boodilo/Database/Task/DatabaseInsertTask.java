package com.android.tripolis.boodilo.Database.Task;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.tripolis.boodilo.Database.BooDBOpenHelper;
import com.android.tripolis.boodilo.Database.Query.InsertQuery;
import com.android.tripolis.boodilo.Database.Response.InsertResponse;

/**
 * Created by v.karyagin on 9/19/17.
 */

public class DatabaseInsertTask extends DatabaseTask<InsertQuery, Integer, InsertResponse> {

    private final Context context;
    private final BooDBOpenHelper dbOpenHelper;

    public DatabaseInsertTask(Context context, TaskListener<InsertResponse> taskListener) {
        super(taskListener);
        this.context = context;

        dbOpenHelper = BooDBOpenHelper.getInstance(context, null);
    }

    @Override
    protected InsertResponse doInBackground(InsertQuery... insertQueries) {
        InsertResponse result = null;

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.inTransaction()) {
            Log.e("DatabaseInsertTask", "An open transaction was detected.");
            return null;
        }

        db.beginTransaction();
        try {

            for (InsertQuery insertQuery : insertQueries) {
                long id = db.insertOrThrow(insertQuery.getTableName(),
                        insertQuery.getNullColumns(),
                        insertQuery.getContentValues());

                result.addInsertingId(id);
            }

            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Log.e("DatabaseInsertTask", "Insert failed. " + e.getMessage());
            result = null;
        } finally {
            db.endTransaction();
        }

        return result;
    }
}
