package com.olivebranch.mock;

/**
 * Created by bfpaige on 160218.
 */
public final class NonNullField implements Field {
    private final String nonNullValue;

    public NonNullField(String value) {
        this.nonNullValue=value!=null?value:"";
    }

    public String value() {
        return nonNullValue;
    }
}
