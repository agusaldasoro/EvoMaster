package com.foo.rest.examples.spring.market.exception;

public class EnumerationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnumerationNotFoundException(String value, Throwable e) {
		super("Failed to parse " + value, e);
	}

}
