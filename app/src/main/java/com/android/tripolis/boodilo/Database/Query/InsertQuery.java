package com.android.tripolis.boodilo.Database.Query;

import android.content.ContentValues;
import android.support.annotation.Nullable;

/**
 * Created by v.karyagin on 9/19/17.
 */

public class InsertQuery extends Query {

    protected final ContentValues values;
    protected String nullColumns;

    public InsertQuery(String tableName, ContentValues values) {
        this(tableName, values, null);
    }

    public InsertQuery(String tableName, ContentValues values, @Nullable String nullColumns) {
        super(tableName);
        this.values = values;
        this.nullColumns = nullColumns;
    }

    public ContentValues getContentValues() {
        return this.values;
    }

    public @Nullable String getNullColumns() {
        return this.nullColumns;
    }
}
