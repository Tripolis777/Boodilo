package com.android.tripolis.boodilo.Database.Query;

import com.android.tripolis.boodilo.Database.Query.Condition.WhereCondition;

/**
 * Created by v.karyagin on 9/12/17.
 */

public class SimpleSelectQuery extends SelectQuery<String> {
    private static final String SIMPLE_SELECT_TEMPLATE = "SELECT %s FROM %s";
    private static final String SIMPLE_WHERE_TEMPLATE = "WHERE %s";

    private static final String DELIMITER = ", ";

    private WhereCondition<String> whereCondition;

    public SimpleSelectQuery(String tableName) {
        super(tableName);
    }

    @Override
    public void setWhereCondition(WhereCondition<String> whereCondition) {
        this.whereCondition = whereCondition;
    }

    @Override
    public String getWhereSQL() {
        return whereCondition.getWhereSQL();
    }

}
