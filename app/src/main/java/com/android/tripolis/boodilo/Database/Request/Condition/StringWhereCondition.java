package com.android.tripolis.boodilo.Database.Request.Condition;

import android.support.annotation.Nullable;

/**
 * Created by v.karyagin on 9/13/17.
 */

public class StringWhereCondition implements WhereCondition<String> {

    private final StringBuilder stringBuilder;

    public StringWhereCondition () {
        stringBuilder = new StringBuilder();
    }

    public void addCondition(Condition condition) {
        this.addCondition(condition, null);
    }

    public void addCondition(Condition condition, @Nullable LogicOperation logicOperation) {
        if (logicOperation == null && stringBuilder.length() > 0)
            logicOperation = LogicOperation.AND;

        if (logicOperation != null)
            stringBuilder.append(logicOperation.toString());

        stringBuilder.append(condition.toString());
    }

    @Override
    public String getWhereSQL() {
        return stringBuilder.toString();
    }

}
