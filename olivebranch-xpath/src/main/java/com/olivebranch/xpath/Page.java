package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.hasValues;
import static com.olivebranch.xpath.QueryUtility.inParent;
import static com.olivebranch.xpath.QueryUtility.indexOfQuery;
import static com.olivebranch.xpath.QueryUtility.queryParent;
import static com.olivebranch.xpath.QueryUtility.querySibling;

import com.olivebranch.Content;

public enum Page implements Content<String> {

	BUTTON("button"),

	IMAGE("img"),

	LINK("a"),

	TAB("a"),
	
	MODAL("div[(contains(@style,'absolute'))][not(contains(@style,'display: none'))][not(contains(@style,'display:none'))][not(contains(@style,'left:-'))][not(contains(@style,'left: -'))][not(contains(@style,'left:0'))][not(contains(@style,'left: 0'))]"),

	LIST_ITEM("li"),

	ROW("tr"),

	CELL("td");

	private final String query;

	Page(String query) {
		this.query = "//" + query;
	};

	public Content<String> in(Content<String> parent) {
		return inParent(parent, query);
	}

	public Content<String> thatHas(String... values) {
		return hasValues(query + "[contains(.,'%s')]", values);
	}

	public Content<String> parent() {
		return queryParent(query);
	}

	public Content<String> sibling(Content<String> content) {
		return querySibling(query, content);
	}

	public String toString() {
		return query;
	}

	public Content<String> number(int number) {
		return indexOfQuery(query, number);
	}

	public String query() {
		return query;
	}
}
