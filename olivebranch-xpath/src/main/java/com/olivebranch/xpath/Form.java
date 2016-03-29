package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.formAncestor;
import static com.olivebranch.xpath.QueryUtility.hasValues;
import static com.olivebranch.xpath.QueryUtility.inParent;
import static com.olivebranch.xpath.QueryUtility.indexOfQuery;
import static com.olivebranch.xpath.QueryUtility.labelOfInput;
import static com.olivebranch.xpath.QueryUtility.queryParent;
import static com.olivebranch.xpath.QueryUtility.querySibling;
import static com.olivebranch.xpath.QueryUtility.valueOfInput;

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

	private final String query;
	
	Form(String query) {
		this.query = "//" + query;
	}

	public FormContent<String> labeled(String text) {
		return labelOfInput(query, text);
	}

	public FormContent<String> parentForm() {
		return formAncestor(query);
	}

	public Content<String> in(Content<String> parent) {
		return inParent(parent, query);
	}

	public FormContent<String> thatHas(String... values) {
		return hasValues(query, values);
	}

	public Content<String> number(int number) {
		return indexOfQuery( query, number);
	}

	public Content<String> parent() {
		return queryParent(query);
	}

	public Content<String> sibling(Content<String> content) {
		return querySibling(query, content);
	}
	
	public FormContent<String> hasValue(String value) {
		return valueOfInput(query, value);
	}

	public String query() {
		return query;
	}
	
	@Override
	public String toString() {
		return query;
	}
}
