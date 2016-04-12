package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.Profile;
import com.olivebranch.mock.Records;

public class Name extends Memory<Name.Key, Field> implements Profile<Name.Key> {
	
	public enum Key {
		FIRST_NAME,
		MIDDLE_NAME,
		LAST_NAME
	}
	
	public Name(Records<String> firstNames, Records<String> lastNames) {
		super(3);
		put(Key.FIRST_NAME, new CachedField(new RecordField(new AnyRecord<String>(firstNames))));
		put(Key.MIDDLE_NAME, new CachedField(new RecordField(new AnyRecord<String>(firstNames))));
		put(Key.LAST_NAME, new CachedField(new RecordField(new AnyRecord<String>(lastNames))));
	}

	public String field(Key nameKey) throws Exception {
		return get(nameKey).value();
	}
}
