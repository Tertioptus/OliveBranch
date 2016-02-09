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

public enum Form implements FormContent {

	INPUT("input"),
	LABEL("label"),
	BUTTON("button"),
	RADIO("input[@type='radio']"),
	SUBMIT("input[@type='submit']"),
	SELECT("select"),
	MULTI_SELECT("select[@multiple='multiple']"),
	FIELDSET("fieldset"),
	LEGEND("legend"),
	TEXT("input[@type='text']");

	private final String query;
	
	Form(String query) {
		this.query = "//" + query;
	}

	public FormContent labeled(String text) {
		return labelOfInput(query, text);
	}

	public FormContent parentForm() {
		return formAncestor(query);
	}

	public Content in(Content parent) {
		return inParent(parent, query);
	}

	public FormContent has(String... values) {
		return hasValues(query, values);
	}

	public Content number(int number) {
		return indexOfQuery( query, number);
	}

	public Content parent() {
		return queryParent(query);
	}

	public Content sibling(Content content) {
		return querySibling(query, content);
	}
	
	public FormContent hasValue(String value) {
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
