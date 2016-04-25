package com.olivebranch.xpath;

import com.olivebranch.Content;

public enum Page implements Content<String> {

	BUTTON("button"),
	
	FORM("form"),

	IMAGE("img"),

	LINK("a"),

	TAB("a"),
	
	MODAL("div[(contains(@style,'absolute'))][not(contains(@style,'display: none'))][not(contains(@style,'display:none'))][not(contains(@style,'left:-'))][not(contains(@style,'left: -'))][not(contains(@style,'left:0'))][not(contains(@style,'left: 0'))]"),
	
	HEADER("(//h1|//h2|//h3|//h4|//h5)"),

	LIST_ITEM("li"),

	ROW("tr"),

	CELL("td");

	private final Query query;

	Page(String query) {
		this.query=new Query(query.startsWith("(")?query:"//" + query);
	};

	public Content<String> in(Content<String> parent) {
		return query.in(parent);
	}

	public Content<String> thatHas(String... values) {
		return query.thatHas(values);
	}

	public Content<String> number(int number) {
		return query.number(number);
	}

	public Content<String> parent() {
		return query.parent();
	}

	public Content<String> sibling(Content<String> content) {
		return query.sibling(content);
	}

	public String query() {
		return query.query();
	}
	
	public String toString() {
		return query.toString();
	}
}
