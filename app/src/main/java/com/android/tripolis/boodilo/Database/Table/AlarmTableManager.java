package com.android.tripolis.boodilo.Database.Table;

import android.provider.BaseColumns;

import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;

import java.util.Collections;
import java.util.List;

/**
 * Created by v.karyagin on 9/11/17.
 */

public class AlarmTableManager implements SQLiteTableManager {

    private static final String SQL_CREATE_ENTRY =
            "CREATE TABLE " + AlarmEntry.AlarmSchema.TABLE_NAME + " ( " +
                    AlarmEntry.AlarmSchema._ID + " INTEGER PRIMARY KEY, " +
                    AlarmEntry.AlarmSchema.COLUMN_NAME_TIME + " TEXT, " +   // HH:MM
                    AlarmEntry.AlarmSchema.COLUMN_NAME_TYPE + " INTEGER, " +
                    AlarmEntry.AlarmSchema.COLUMN_NAME_STATUS + " INTEGER, " +
                    AlarmEntry.AlarmSchema.COLUMN_NAME_SOUND + " INTEGER" +
                    ")";

    private static final String SQL_DELETE_ENTRY =
            "DROP TABLE IF EXISTS " + AlarmEntry.AlarmSchema.TABLE_NAME;

    public AlarmTableManager() {}

    @Override
    public String getSQLCreateQuery() {
        return SQL_CREATE_ENTRY;
    }

    @Override
    public String getSQLDeleteQuery() {
        return SQL_DELETE_ENTRY;
    }

    @Override
    public List<String> getSQLUpdateQueries() {
        return Collections.EMPTY_LIST;
    }


}
