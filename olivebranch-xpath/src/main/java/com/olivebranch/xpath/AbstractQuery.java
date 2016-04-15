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

	public Content<String> in(Content<String> parent) {
		return inParent(parent,query);
	}

	public Content<String> thatHas(String... values) {
		return hasValues(query + "[contains(.,'%s')]", values);
	}

	public Content<String> number(final int number) {
		return indexOfQuery( query, number);
	}

	public Content<String> parent() {
		return queryParent(query);
	}

	public Content<String> sibling(Content<String> content) {
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