package com.android.tripolis.boodilo.Database.Response;

import android.database.Cursor;

/**
 * Created by v.karyagin on 9/16/17.
 */

public abstract class SelectResponseFactory<T> {
    public abstract SelectResponse<T> getSelectResponse(Cursor cursor);
}
