package com.android.tripolis.boodilo.Database.Query;

import android.content.ContentValues;
import android.support.annotation.Nullable;

/**
 * Created by v.karyagin on 9/19/17.
 */

public abstract class InsertQuery extends Query {

    public InsertQuery(String tableName) {
        super(tableName);
    }

    public abstract ContentValues getContentValues();
    public abstract @Nullable String getNullColumns();
}
