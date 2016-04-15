package com.olivebranch.xpath;

import com.olivebranch.Content;
import com.olivebranch.FormContent;

public enum Form implements FormContent<String> {

	INPUT("input"),
	LABEL("label"),
	BUTTON("button"),
	RADIO("input[@type='radio']"),
	SUBMIT("*[@type='submit']"),
	SELECT("select"),
	MULTI_SELECT("select[@multiple='multiple']"),
	FIELDSET("fieldset"),
	LEGEND("legend"),
	TEXT("input[@type='text']");

	private final FormQuery query;
	
	Form(String query) {
		this.query = new FormQuery("//" + query);
	}

	public FormContent<String> labeled(String text) {
		return query.labeled(text);
	}

	public FormContent<String> parentForm() {
		return query.parentForm();
	}

	public Content<String> in(Content<String> parent) {
		return query.in(parent);
	}

	public Content<String> thatHas(String... values) {
		return query.thatHas(values);
	}

	public Content<String> number(int number) {
		return query.number(number);
	}

	public Content<String> parent() {
		return query.parent();
	}

	public Content<String> sibling(Content<String> content) {
		return query.sibling(content);
	}
	
	public FormContent<String> hasValue(String value) {
		return query.hasValue(value);
	}

	public String query() {
		return query.query();
	}
	
	@Override
	public String toString() {
		return query.toString();
	}
}
