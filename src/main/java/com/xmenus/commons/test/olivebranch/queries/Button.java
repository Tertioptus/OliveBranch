package com.xmenus.commons.test.olivebranch.queries;

import static com.xmenus.commons.test.olivebranch.queries.QueryUtility.*;

public enum Button implements XPathQuery {
	
	TITLE("a[starts-with(@title,'%s')]");

	private final String query;

	Button(String query) {
		this.query = "//" + query;
	};
	
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

	@Override
	public String toString() {
		return query;
	}
}
