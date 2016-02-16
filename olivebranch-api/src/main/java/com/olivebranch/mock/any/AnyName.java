package com.olivebranch.mock.any;

import java.util.Map;


import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;

public class AnyName implements Record {
	
	Map<String, Field> map;
	
	public AnyName(Records<String> firstNames, Records<String> LastNames) {
		
		map.put("firstName", new CachedField(new AnyRecord(firstNames)));
		map.put("middleName", new CachedField(new AnyRecord(firstNames)));
		map.put("lastName", new CachedField(AnyRecord(lastNames)));
	}

	public String retrieve(String fieldName) {
		return map.get(fieldName).value();
	}
}
