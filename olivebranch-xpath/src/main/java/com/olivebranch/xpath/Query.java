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

public class Query implements Content {

	final String query;
	
	public Query(final String query) {
		this.query = query;
	}

	public Content in(Content parent) {
		return inParent(parent,query);
	}

	public Content has(String... values) {
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

	public Content labeled(String text) {
		return labelOfInput(text, query);
	}

	public Content parentForm() {
		return formAncestor(query);
	}
	
	public Content hasValue(String value) {
		return valueOfInput(query, value);
	}

	public String query() {
		return query;
	}
}
