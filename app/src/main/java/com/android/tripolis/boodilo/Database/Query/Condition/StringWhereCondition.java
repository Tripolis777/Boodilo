package com.android.tripolis.boodilo.Database.Query.Condition;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 9/13/17.
 */

public class StringWhereCondition implements WhereCondition<String> {

    private final StringBuilder stringBuilder;
    private ArrayList<String> whereArgs;

    public StringWhereCondition () {
        stringBuilder = new StringBuilder();
    }

    public void addCondition(Condition condition) {
        this.addCondition(condition, null);
    }

    public void addCondition(Condition condition, @Nullable LogicOperator logicOperator) {
        if (logicOperator == null && stringBuilder.length() > 0)
            logicOperator = LogicOperator.AND;

        if (logicOperator != null)
            stringBuilder.append(logicOperator.toString());

        stringBuilder.append(condition.toString());
    }

    @Override
    public String getWhereSQL() {
        return stringBuilder.toString();
    }

}
