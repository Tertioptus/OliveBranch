package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.Record;

public class RecordField implements Field {
	
	private final Record<String> record;
	
	public RecordField(Record<String> record) {
		this.record=record;
	}

	public String value() throws Exception {
		return record.load();
	}
}
