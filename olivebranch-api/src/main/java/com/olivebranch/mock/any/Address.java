package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.NonNullField;
import com.olivebranch.mock.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bfpaige on 160218.
 */
public final class Address implements Profile {
    private final Map<String,Field> map;
    public Address(String streetAddress1, String town, String state, String zipCode, String longitude, String latitude) {
        map=new HashMap<String,Field>();
        add("streetAddress1",streetAddress1);
        add("town",town);
        add("zipCode",zipCode);
        add("longitude",longitude);
        add("latitude",latitude);
    }

    public String field(String name) throws Exception {
        return map.get(name).value();
    }

    private void add(String key, String value) {
       map.put(key, new NonNullField(value));
    }
}
