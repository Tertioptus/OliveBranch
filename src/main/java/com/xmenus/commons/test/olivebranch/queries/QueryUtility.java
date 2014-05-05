package com.xmenus.commons.test.olivebranch.queries;

public class QueryUtility {
	
	
	public static Query inParent(XPathQuery parent, String query) {
		return new Query(String.format("%s//%s", parent, strip(query)));		
	}

	public static Query hasValues(String query, String... values) {
		return new Query(String.format(query, values));
	}

	public static Query indexOfQuery(String query, int naturalNumberIndex) {
		return new Query(String.format("(%s)[%s]", query, naturalNumberIndex));
	}

	public static Query queryParent(String query) {
		return new Query(String.format("%s/parent::*", query));
	}

	public static Query querySibling(String query, XPathQuery sibling) {
		return new Query(String.format("%s//%s", sibling.parent(), strip(query)));
	}
	
	public static Query labelOfInput(String query, String labelText) {
		return new Query(String.format("//label[contains(.,'%s')]/following-sibling::%s", labelText, strip(query)));
	}
	
	public static Query formAncestor(String query) {
		return new Query(String.format("%s/ancestor::form", query));
	}
	
	private static String strip(String query) {
		return query.replaceFirst("//", "");
	}
}
