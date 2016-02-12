package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.hasValues;
import static com.olivebranch.xpath.QueryUtility.inParent;
import static com.olivebranch.xpath.QueryUtility.indexOfQuery;
import static com.olivebranch.xpath.QueryUtility.queryParent;
import static com.olivebranch.xpath.QueryUtility.querySibling;

import com.olivebranch.Content;

abstract class AbstractQuery {

	final String query;

	AbstractQuery(final String query) {
		this.query = query;
	}

	public Content in(Content parent) {
		return inParent(parent,query);
	}

	public Content thatHas(String... values) {
		return hasValues(query, values);
	}

	public Content number(final int number) {
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
	
	@Override
	public String toString() {
		return query;
	}
}