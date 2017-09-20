package com.android.tripolis.boodilo.Database.Query;

/**
 * Created by v.karyagin on 9/14/17.
 */

public abstract class Query {

    protected final String tableName;

    public Query(String tableName) {
        this.tableName = tableName;
    }


    public String getTableName() {
        return tableName;
    }
}
