package com.xmenus.commons.test.olivebranch.queries;

public interface XPathQuery {
	
	XPathQuery in(XPathQuery parent);

	XPathQuery has(String... values);
	
	XPathQuery nth(int naturalNumberIndex);
	
	XPathQuery parent();
	
	XPathQuery sibling(XPathQuery sibling);
}
