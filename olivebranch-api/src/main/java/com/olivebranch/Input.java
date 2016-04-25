package com.olivebranch;

import java.util.Map;

public final class Input {

	private String value;
	
	Input(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
	public Note note(Map<String, String> map) {
		return new Note(map, value);
	}

	@Override
	public String toString() {
		return this.value();
	}
}
