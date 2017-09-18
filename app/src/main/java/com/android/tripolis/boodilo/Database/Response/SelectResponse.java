package com.android.tripolis.boodilo.Database.Response;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by v.karyagin on 9/16/17.
 */

public abstract class SelectResponse<T> {

    protected final ArrayList<T> rows;

    public SelectResponse(Cursor cursor) {
        rows = (ArrayList) Collections.EMPTY_LIST;
        init(cursor);
    }

    public ArrayList<T> getAll() {
        return rows;
    }

    protected abstract void init(Cursor cursor);
}
