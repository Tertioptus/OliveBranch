package com.xmenus.commons.test.olivebranch.queries;

public class Text {
	
	private String text;
	
	private  Text(String text) {
		this.text = text;
	}
	
	public static Text that(String text) {
		return new Text(text);
	}
	
	public XPathQuery isPresent() {
		return new Query(String.format("//text() = '%s'", text));
	}
	
	public XPathQuery isNotPresent(){
		return new Query(String.format("//body[not(contains(.,'%s'))]", text));
	}
}
