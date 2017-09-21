package com.android.tripolis.boodilo.Database.Query;

import com.android.tripolis.boodilo.Database.Query.Condition.WhereCondition;

/**
 * Created by v.karyagin on 21.09.2017.
 */

interface WithWhereCondition<T> {

    void setWhereCondition (WhereCondition<T> whereCondition);
    String getWhereSQL ();

}
