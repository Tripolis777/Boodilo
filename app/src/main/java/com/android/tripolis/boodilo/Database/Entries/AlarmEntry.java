package com.android.tripolis.boodilo.Database.Entries;

import android.provider.BaseColumns;

import java.util.Collections;
import java.util.List;

/**
 * Created by tripo on 9/9/2017.
 */

public class AlarmEntry implements DatabaseEntry {

    public static abstract class AlarmSchema implements BaseColumns {
        public static final String TABLE_NAME = "alarm";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_SOUND = "sound";
    }

    private static final String SQL_CREATE_ENTRY =
            "CREATE TABLE " + AlarmSchema.TABLE_NAME + " ( " +
            AlarmSchema._ID + " INTEGER PRIMARY KEY, " +
            AlarmSchema.COLUMN_NAME_TIME + " TEXT, " +   // HH:MM
            AlarmSchema.COLUMN_NAME_TYPE + " INTEGER, " +
            AlarmSchema.COLUMN_NAME_STATUS + " INTEGER, " +
            AlarmSchema.COLUMN_NAME_SOUND + " INTEGER" +
            ")";

    private static final String SQL_DELETE_ENTRY =
            "DROP TABLE IF EXISTS " + AlarmSchema.TABLE_NAME;

    public AlarmEntry() {}

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
