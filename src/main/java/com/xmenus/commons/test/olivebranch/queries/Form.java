package com.xmenus.commons.test.olivebranch.queries;

import static com.xmenus.commons.test.olivebranch.queries.QueryUtility.*;

public enum Form implements HtmlFormXPathQuery {

	INPUT("input"),
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

	public HtmlFormXPathQuery labeled(String text) {
		return labelOfInput(query, text);
	}

	public HtmlFormXPathQuery parentForm() {
		return formAncestor(query);
	}

	public HtmlFormXPathQuery in(XPathQuery parent) {
		return inParent(parent,query);
	}

	public HtmlFormXPathQuery has(String... values) {
		return hasValues(query, values);
	}

	public HtmlFormXPathQuery nth(int naturalNumberIndex) {
		return indexOfQuery( query, naturalNumberIndex);
	}

	public HtmlFormXPathQuery parent() {
		return queryParent(query);
	}

	public HtmlFormXPathQuery sibling(XPathQuery xPathQuery) {
		return querySibling(query, xPathQuery);
	}
	
	@Override
	public String toString() {
		return query;
	}

	public HtmlFormXPathQuery hasValue(String value) {
		return valueOfInput(query, value);
	}

}
