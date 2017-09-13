package com.android.tripolis.boodilo.Database.Request.Condition;

/**
 * Created by v.karyagin on 9/13/17.
 */

public enum LogicOperation {
    AND ("AND"),
    OR ("OR");

    private final String name;

    LogicOperation(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
