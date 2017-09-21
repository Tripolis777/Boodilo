package com.android.tripolis.boodilo.Database.Query;

import android.content.ContentValues;

import com.android.tripolis.boodilo.Database.Query.Condition.WhereCondition;

/**
 * Created by v.karyagin on 21.09.2017.
 */

public abstract class UpdateQuery<T> extends Query implements WithWhereCondition<T> {

    protected final ContentValues values;

    public UpdateQuery(String tableName, ContentValues values) {
        super(tableName);
        this.values = values;
    }

    public ContentValues getValues() {
        return  this.values;
    }

}
