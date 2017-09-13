package com.android.tripolis.boodilo.Database.Request.Condition;

/**
 * Created by v.karyagin on 9/13/17.
 */

public class Condition<T> {

    protected static final String CONDITION_TEMPLATE_DEFAULT = "%s %s %s";

    private final String field;
    private final Operation operation;
    private final T object;

    public Condition(String field, Operation operation, T object) {
        this.field = field;
        this.operation = operation;
        this.object = object;
    }

    public String toString() {
        return String.format(CONDITION_TEMPLATE_DEFAULT, field, operation.toString(), object.toString());
    }

    public enum Operation {
        EQUALS ("=");

        private final String name;

        Operation(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }
}
