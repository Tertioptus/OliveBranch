package com.olivebranch;

import java.util.Map;

public final class Note {
	
	private final Map<String,String> map;
	
	private final String note;
	
	Note(Map<String,String> map, String note) {
		this.map=map;
		this.note=note;
	}
	
	public void as(String key) {
		this.map.put(key, note);
	}
}
