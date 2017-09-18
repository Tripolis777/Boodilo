package com.android.tripolis.boodilo.Database.Request.Condition;

/**
 * Created by v.karyagin on 9/13/17.
 */

public enum LogicOperator {
    AND ("AND"),
    OR ("OR");

    private final String name;

    LogicOperator(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
