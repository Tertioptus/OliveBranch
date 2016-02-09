package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.hasValues;
import static com.olivebranch.xpath.QueryUtility.inParent;
import static com.olivebranch.xpath.QueryUtility.indexOfQuery;
import static com.olivebranch.xpath.QueryUtility.queryParent;
import static com.olivebranch.xpath.QueryUtility.querySibling;

import com.olivebranch.Content;

public enum Page implements Content {

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

	public Content in(Content parent) {
		return inParent(parent, query);
	}

	public Content has(String... values) {
		return hasValues(query + "[contains(.,'%s')]", values);
	}

	public Content parent() {
		return queryParent(query);
	}

	public Content sibling(Content content) {
		return querySibling(query, content);
	}

	public String toString() {
		return query;
	}

	public Content number(int number) {
		return indexOfQuery(query, number);
	}

	public String query() {
		return query;
	}
}
