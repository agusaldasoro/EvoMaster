package com.foo.rest.examples.spring.market.link;

public class LinkModelFactory {

	private LinkModelFactory() {
	}

	/**
	 * @param hrefLink
	 * @return a {LinkModel} with the given href
	 */
	public static LinkModel createLinkModelWithHref(String hrefLink) {
		LinkModel linkModel = new LinkModel();
		linkModel.setHref(hrefLink);
		return linkModel;
	}
}
