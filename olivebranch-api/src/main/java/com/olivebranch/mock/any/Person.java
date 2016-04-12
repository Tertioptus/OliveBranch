package com.olivebranch.mock.any;

import com.olivebranch.mock.Profile;

public interface Person extends Profile<Person.Key> {

	public enum Key {
		FIRST_NAME, LAST_NAME, STREET_ADDRESS_1, TOWN, STATE, ZIP_CODE, LATITUDE, LONGITUDE, PHONE_NUMBER, EMAIL_ADDRESS
	}

	public String field(Person.Key name) throws Exception;

}