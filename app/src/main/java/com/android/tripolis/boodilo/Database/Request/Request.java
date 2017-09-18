package com.android.tripolis.boodilo.Database.Request;

/**
 * Created by v.karyagin on 9/14/17.
 */

public abstract class Request {

    protected final String tableName;

    public Request (String tableName) {
        this.tableName = tableName;
    }


    public String getTableName() {
        return tableName;
    }
}
