package com.foo.rest.examples.spring.market.model;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
public class Product {

	private String name;

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
