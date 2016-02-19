package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.Profile;
import com.olivebranch.mock.Records;

import java.util.HashMap;
import java.util.Map;

public class Name implements Profile {
	
	Map<String, Field> map;
	
	public Name(Records<String> firstNames, Records<String> lastNames) {
		map=new HashMap<String, Field>();
		map.put("firstName", new CachedField(new RecordField(new AnyRecord<String>(firstNames))));
		map.put("middleName", new CachedField(new RecordField(new AnyRecord<String>(firstNames))));
		map.put("lastName", new CachedField(new RecordField(new AnyRecord<String>(lastNames))));
	}

	public String field(String name) throws Exception {
		return map.get(name).value();
	}
}
