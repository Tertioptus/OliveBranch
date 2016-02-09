package com.olivebranch.xpath;

import com.olivebranch.Content;

public final class Text {
	
	private String text;
	
	private  Text(String text) {
		this.text = text;
	}
	
	public static Text that(String text) {
		return new Text(text);
	}
	
	public Content isPresent() {
		return new Query(String.format("//text() = '%s'", text));
	}
	
	public Content isNotPresent(){
		return new Query(String.format("//body[not(contains(.,'%s'))]", text));
	}
}