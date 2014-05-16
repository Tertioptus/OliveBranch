package com.xmenus.commons.test.olivebranch.queries;


public interface HtmlFormXPathQuery extends XPathQuery {

	HtmlFormXPathQuery labeled(String text);
	
	HtmlFormXPathQuery parentForm();
	
	HtmlFormXPathQuery hasValue(String value);
}
