package com.foo.rest.examples.spring.market.model;

import com.google.common.net.UrlEscapers;

public class PathSegmentEncoder {

	private static final String SEMICOLON = ";";
	private static final String ENCODED_SEMICOLON = "%3B";

	static public String encode(String pathSegment) {
		return UrlEscapers.urlPathSegmentEscaper().escape(pathSegment)
				.replaceAll(SEMICOLON, ENCODED_SEMICOLON);
	}

}
