package com.android.tripolis.boodilo.Database.Request.Condition;

/**
 * Created by v.karyagin on 9/12/17.
 */

public interface WhereCondition<T> {
    T getWhereSQL();
}
