package com.xmenus.commons.test.olivebranch.queries;

import static com.xmenus.commons.test.olivebranch.queries.QueryUtility.*;

public class Query implements HtmlFormXPathQuery {

	final String query;
	
	public Query(String query) {
		this.query = query;
	}

	public XPathQuery in(XPathQuery parent) {
		return inParent(parent,query);
	}

	public XPathQuery has(String... values) {
		return hasValues(query, values);
	}

	public XPathQuery nth(int naturalNumberIndex) {
		return indexOfQuery( query, naturalNumberIndex);
	}

	public XPathQuery parent() {
		return queryParent(query);
	}

	public XPathQuery sibling(XPathQuery xPathQuery) {
		return querySibling(query, xPathQuery);
	}

	public HtmlFormXPathQuery labeled(String text) {
		return labelOfInput(text, query);
	}

	public HtmlFormXPathQuery parentForm() {
		return formAncestor(query);
	}
	
	public HtmlFormXPathQuery hasValue(String value) {
		return valueOfInput(query, value);
	}

	@Override
	public String toString() {
		return query;
	}
}
