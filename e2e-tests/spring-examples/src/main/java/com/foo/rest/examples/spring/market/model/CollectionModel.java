package com.foo.rest.examples.spring.market.model;

import com.foo.rest.examples.spring.market.link.CollectionLinksModel;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("collection")
public class CollectionModel<T> {

	protected CollectionLinksModel links = null;

	protected java.util.List<T> items = new java.util.ArrayList<>();

	protected Integer total = null;

	public CollectionModel<T> links(CollectionLinksModel links) {
		this.links = links;
		return this;
	}

	@com.fasterxml.jackson.annotation.JsonProperty("_links")
	public CollectionLinksModel getLinks() {
		return links;
	}

	public void setLinks(CollectionLinksModel links) {
		this.links = links;
	}

	public CollectionModel<T> items(java.util.List<T> items) {
		this.items = items;
		return this;
	}

	@com.fasterxml.jackson.annotation.JsonProperty("items")
	public java.util.List<T> getItems() {
		return items;
	}

	public void setItems(java.util.List<T> items) {
		this.items = items;
	}

	public CollectionModel<T> total(Integer total) {
		this.total = total;
		return this;
	}

	@com.fasterxml.jackson.annotation.JsonProperty("_total")
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {

		return "class T {\n" +
				"		links: " + ModelUtils.toIndentedString(links) + "\n" +
				"		items: " + ModelUtils.toIndentedString(items) + "\n" +
				"		total: " + ModelUtils.toIndentedString(total) + "\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		@SuppressWarnings("unchecked")
		CollectionModel<T> other = (CollectionModel<T>) o;
		if (!java.util.Objects.equals(links, other.links))
			return false;
		if (!java.util.Objects.equals(items, other.items))
			return false;
		return java.util.Objects.equals(total, other.total);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(java.util.Objects.hashCode(links),
				java.util.Objects.hashCode(items),
				java.util.Objects.hashCode(total));
	}
}
