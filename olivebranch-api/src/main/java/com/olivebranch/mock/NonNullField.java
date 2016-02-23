package com.olivebranch.mock;

/**
 * Created by bfpaige on 160218.
 */
public final class NonNullField implements Field {
    private final Field nonNullField;

    public NonNullField(final String value) {
        this(new Field() {
            public String value() throws Exception {
                return value;
            }
        });
    }

    public NonNullField(final Field field) {
        this.nonNullField=field==null?new EmptyStringField():field;
    }

    public String value() throws Exception {
        return nonNullField.value()==null?"":nonNullField.value();
    }

    class EmptyStringField implements Field {

        public String value() throws Exception {
            return "";
        }
    }
}
