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

    private ArrayList<String> whereConditions;
    private ArrayList<String> fields;

    public SimpleSelectRequest(String tableName) {
        super(tableName);
        whereConditions = new ArrayList<>();
        fields = new ArrayList<>();
    }

    @Override
    public String getSQLRequest() {

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ")
               .append( fields.isEmpty() ? SELECT_ALL : getSelectFieldsSQL() )
               .append(" FROM ")
               .append(tableName);

        if (!whereConditions.isEmpty())
            builder.append(getWhereSQL());

        return builder.toString();
    }

    @Override
    public void setWhereCondition(WhereCondition<String> whereCondition) {
        whereConditions.add(whereCondition.getWhereSQL());
    }

    @Override
    public void setSelectFields(String[] fields) {

    }

    @Override
    public String getWhereSQL() {
        return TextUtils.join(DELIMITER, whereConditions);
    }

    @Override
    public String getSelectFieldsSQL() {
        return TextUtils.join(DELIMITER, fields);
    }
}
