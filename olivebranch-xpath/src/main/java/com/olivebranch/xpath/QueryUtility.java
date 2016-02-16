package com.olivebranch.xpath;

import com.olivebranch.Content;

class QueryUtility {
	
	
	public static Query inParent(Content<String> parent, String query) {
		return new Query(String.format("%s//%s", parent, strip(query)));		
	}

	public static FormQuery hasValues(String query, String... values) {
		return new FormQuery(String.format(query, (Object[]) values));
	}

	public static Query indexOfQuery(String query, int naturalNumberIndex) {
		return new Query(String.format("(%s)[%s]", query, naturalNumberIndex));
	}

	public static Query queryParent(String query) {
		return new Query(String.format("%s/parent::*", query));
	}

	public static Query querySibling(String query, Content<String> sibling) {
		return new Query(String.format("%s//%s", sibling.parent(), strip(query)));
	}
	
	public static FormQuery labelOfInput(String query, String labelText) {
		return new FormQuery(String.format("//label[contains(.,'%s')]/following::%s[1]", labelText, strip(query)));
	}
	
	public static FormQuery valueOfInput(String query, String value) {
		return new FormQuery(String.format("%s[@value='%s']", strip(query), value));
	}
	
	public static FormQuery formAncestor(String query) {
		return new FormQuery(String.format("%s/ancestor::form", query));
	}
	
	private static String strip(String query) {
		return query.replaceFirst("//", "");
	}
}
