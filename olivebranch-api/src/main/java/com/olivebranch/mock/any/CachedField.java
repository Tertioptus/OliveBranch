package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;

public class CachedField implements Field {

	private final Field field;
	
	private String value;
	
	public CachedField(Field field) {
		this.field = field;
	}

	public String value() throws Exception {
		if(value == null)
			value = field.value();
		
		return value;
	}

}
