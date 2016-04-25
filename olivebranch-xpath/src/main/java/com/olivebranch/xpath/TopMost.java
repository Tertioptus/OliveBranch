package com.olivebranch.xpath;

import com.olivebranch.Content;

public final class TopMost {

	public static Content<String> of(Content<String> content) {
		return Last.of(content);
	}
}
