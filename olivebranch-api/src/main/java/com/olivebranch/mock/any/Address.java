package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.NonNullField;
import com.olivebranch.mock.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bfpaige on 160218.
 */
public final class Address extends Memory<Address.Key, Field> implements Profile<Address.Key> {
	
	public enum Key {
		STREET_ADDRESS,
		TOWN,
		STATE,
		ZIP_CODE,
		LONGITUDE,
		LATITUDE
	}

    public Address(String streetAddress1, String town, String state, String zipCode, String longitude, String latitude) {
        add(Key.STREET_ADDRESS, streetAddress1);
        add(Key.TOWN,town);
        add(Key.STATE,state);
        add(Key.ZIP_CODE,zipCode);
        add(Key.LONGITUDE,longitude);
        add(Key.LATITUDE,latitude);
    }

    public String field(Key key) throws Exception {
        return get(key).value();
    }

    private void add(Key key, String value) {
       put(key, new NonNullField(value));
    }
}
