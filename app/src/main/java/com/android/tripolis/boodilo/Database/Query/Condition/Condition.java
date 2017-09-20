package com.android.tripolis.boodilo.Database.Query.Condition;

/**
 * Created by v.karyagin on 9/13/17.
 */

public class Condition<T> {

    protected static final String CONDITION_TEMPLATE_DEFAULT = "%s %s %s";

    private final String field;
    private final String operator;
    private final String object;

    public Condition(String field, Operator operator, T object) {
        this(field, operator.toString(), object);
    }

    public Condition(String field, String operator, T object) {
        this.field = field;
        this.operator = operator;
        this.object = object.toString();
    }

    public String toString() {
        return String.format(CONDITION_TEMPLATE_DEFAULT, field, operator, object);
    }

    public enum Operator {
        EQUALS ("="),
        NOT_EQUAL ("!="),
        GREATER (">"),
        LESS ("<"),
        GREATER_OR_EQUALS (">="),
        LESS_OR_EQUALS ("<=");

        private final String name;

        Operator(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }
}
