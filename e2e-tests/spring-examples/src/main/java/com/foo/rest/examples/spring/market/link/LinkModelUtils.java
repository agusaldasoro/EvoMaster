package com.foo.rest.examples.spring.market.link;

public class LinkModelUtils {

	private LinkModelUtils() {
		//        Hide the public constructor
	}

	public static LinkModel getLinkModelWithHref(LinkFactory linkFactory, String path) {
		return LinkModelFactory.createLinkModelWithHref(linkFactory.makeLinkBuilder()
				.path(path)
				.build());
	}
}
