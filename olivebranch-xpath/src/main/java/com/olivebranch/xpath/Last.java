package com.olivebranch.xpath;

import com.olivebranch.Content;

public final class Last {
	
	public static Content<String> of(Content<String> content) {
		return new Query(String.format("(%s)[last()]", content.query()));
	}
}
