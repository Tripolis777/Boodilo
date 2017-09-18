package com.android.tripolis.boodilo.Database.Request;

import android.text.TextUtils;

import com.android.tripolis.boodilo.Database.Request.Condition.WhereCondition;
import com.android.tripolis.boodilo.Database.Request.SelectRequest;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 9/12/17.
 */

public class SimpleSelectRequest extends SelectRequest<String> {
    private static final String SIMPLE_SELECT_TEMPLATE = "SELECT %s FROM %s";
    private static final String SIMPLE_WHERE_TEMPLATE = "WHERE %s";

    private static final String DELIMITER = ", ";

    private WhereCondition<String> whereCondition;

    public SimpleSelectRequest(String tableName) {
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
