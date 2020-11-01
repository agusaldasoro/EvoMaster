package com.foo.rest.examples.spring.market.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
public class Brand {

	private final String id;
	private final String name;
	private String description;
	private String type;
	private String owner;
	private List<Product> products = new LinkedList<>();

	public Brand(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public String getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Brand{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", type='" + type + '\'' +
				", owner='" + owner + '\'' +
				'}';
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
