package com.android.tripolis.boodilo.Database.Request;

import com.android.tripolis.boodilo.Database.Request.Condition.WhereCondition;

/**
 * Created by v.karyagin on 9/12/17.
 */

public abstract class SelectRequest<T> {

//    private static final String SIMPLE_SELECT_TEMPLATE = "SELECT %s FROM %s";
//    private static final String SIMPLE_WHERE_TEMPLATE = "WHERE %s";
//
    protected static final String SELECT_ALL = "*";

    protected final String tableName;

    public SelectRequest(String tableName) {
        this.tableName = tableName;
    }

    public abstract String getSQLRequest();

    public abstract void setWhereCondition (WhereCondition<T> whereCondition);
    public abstract void setSelectFields (String[] fields);

    public abstract String getWhereSQL ();
    public abstract String getSelectFieldsSQL ();

}
