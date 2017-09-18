package com.android.tripolis.boodilo.Database.Response;

import android.database.Cursor;

import com.android.tripolis.boodilo.Database.Entries.AlarmEntry;

/**
 * Created by v.karyagin on 9/18/17.
 */

public class AlarmSelectResponse extends SelectResponse<AlarmEntry> {

    public AlarmSelectResponse(final Cursor cursor) {
        super(cursor);
    }

    @Override
    protected void init(final Cursor cursor) {
        while (cursor.moveToNext()) {
            AlarmEntry entry = new AlarmEntry();
            entry.setTime(cursor.getString(
                    cursor.getColumnIndex(AlarmEntry.AlarmSchema.COLUMN_NAME_TIME)));
            entry.setSound(cursor.getInt(
                    cursor.getColumnIndex(AlarmEntry.AlarmSchema.COLUMN_NAME_SOUND)));
            entry.setStatus(cursor.getInt(
                    cursor.getColumnIndex(AlarmEntry.AlarmSchema.COLUMN_NAME_STATUS)));
            entry.setType(cursor.getInt(
                    cursor.getColumnIndex(AlarmEntry.AlarmSchema.COLUMN_NAME_TYPE)));

            this.rows.add(entry);
        }
    }

}
