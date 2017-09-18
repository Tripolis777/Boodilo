package com.android.tripolis.boodilo.Database.Response;

import android.database.Cursor;

import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;

/**
 * Created by v.karyagin on 9/18/17.
 */

public class AlarmSelectResponseFactory extends SelectResponseFactory<AlarmEntry> {

    @Override
    public SelectResponse<AlarmEntry> getSelectResponse(Cursor cursor) {
        return new AlarmSelectResponse(cursor);
    }

}
