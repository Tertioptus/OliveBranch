package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.hasValues;
import static com.olivebranch.xpath.QueryUtility.inParent;
import static com.olivebranch.xpath.QueryUtility.indexOfQuery;
import static com.olivebranch.xpath.QueryUtility.queryParent;
import static com.olivebranch.xpath.QueryUtility.querySibling;

import com.olivebranch.Content;

public enum Button implements Content {
	
	TITLE("a[starts-with(@title,'%s')]");

	private final String query;

	Button(final String query) {
		this.query = "//" + query;
	};
	
	public Content in(Content parent) {
		return inParent(parent,query);
	}

	public Content has(String... values) {
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

	public String query() {
		return query;
	}
}
