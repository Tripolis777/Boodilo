package com.android.tripolis.boodilo.Database;

import android.database.sqlite.SQLiteDatabase;

import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;
import com.android.tripolis.boodilo.Database.Table.AlarmTableManager;

/**
 * Created by tripo on 9/9/2017.
 */

public class BooDBCreateHelper implements DBCreateHelper {

    private final AlarmTableManager alarmTableManager;

    public BooDBCreateHelper() {
        alarmTableManager = new AlarmTableManager();
    }

    @Override
    public void createDatabase(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(alarmTableManager.getSQLCreateQuery());
    }
}
