package com.olivebranch.xpath;

import com.olivebranch.Content;

public final class Text {
	
	private String text;
	
	private  Text(String text) {
		this.text = text;
	}
	
	public static Text where(String text) {
		return new Text(text);
	}
	
	public Content<String> isPresent() {
		return new Query(String.format("//body[contains(.,'%s')]", text));
	}
	
	public Content<String> isNotPresent(){
		return new Query(String.format("//body[not(contains(.,'%s'))]", text));
	}
	
	@Override
	public String toString() {
		return text;
	}
}

