package com.olivebranch.mock.any;

import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;

public class AnyRecord<T> implements Record<T> {

	private final Records<T> records;
	
	public AnyRecord(Records<T> records) {
		this.records=records;
	}

	public T load() throws Exception {
			return records.retrieve(randomIndex()).load();
	}

	private long randomIndex() throws Exception {
		return (long)(Math.random() * records.size());
	}
}
