package com.olivebranch.xpath;

import static com.olivebranch.xpath.QueryUtility.formAncestor;
import static com.olivebranch.xpath.QueryUtility.labelOfInput;
import static com.olivebranch.xpath.QueryUtility.valueOfInput;

import com.olivebranch.FormContent;

public final class FormQuery extends AbstractQuery implements FormContent {

	public FormQuery(final String query) {
		super(query);
	}

	public FormContent labeled(String text) {
		return labelOfInput(text, query);
	}

	public FormContent parentForm() {
		return formAncestor(query);
	}
	
	public FormContent hasValue(String value) {
		return valueOfInput(query, value);
	}
}
