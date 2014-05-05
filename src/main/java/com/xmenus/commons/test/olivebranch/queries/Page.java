package com.xmenus.commons.test.olivebranch.queries;

import static com.xmenus.commons.test.olivebranch.queries.QueryUtility.*;

public enum Page implements XPathQuery {
	
	BUTTON("button"),
	
	IMAGE("img"),
	
	LABEL("label"),
	
	LINK("a"),
	
	TAB("a"),
	
	LIST_ITEM("li"),
	
	ROW("tr"),
	
	CELL("td");

	private final String query;

	Page(String query) {
		this.query = "//" + query;
	};
	
	public XPathQuery in(XPathQuery parent) {
		return inParent(parent,query);
	}

	public XPathQuery has(String... values) {
		
		return hasValues(query + "[contains(.,'%s')]", values);
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

	public String toString() {
		return query;
	}
}
