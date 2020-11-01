package com.foo.rest.examples.spring.market.link;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Objects;


/**
 * Generated links for [brand] (x-links)
 **/

/**
 * Auto-generated using Swagger codegen.
 * Generated links for [brand] (x-links)
 *
 * <p>
 * <b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Generated links for [brand] (x-links)")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("brand__links")
public class BrandLinksModel {

	protected LinkModel self = null;

	protected LinkModel canonical = null;

	protected LinkModel products = null;

	/** Create an empty BrandLinksModel with all attributes null */
	public BrandLinksModel() {
	}


	/**
	 *
	 **/
	public BrandLinksModel self(LinkModel self) {
		this.self = self;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("self")
	public LinkModel getSelf() {

		return self;
	}

	public void setSelf(LinkModel self) {
		this.self = self;
	}


	public BrandLinksModel canonical(LinkModel canonical) {
		this.canonical = canonical;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("canonical")
	public LinkModel getCanonical() {

		return canonical;
	}

	public void setCanonical(LinkModel canonical) {
		this.canonical = canonical;
	}


	public BrandLinksModel products(LinkModel products) {
		this.products = products;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("products")
	public LinkModel getProducts() {

		return products;
	}

	public void setProducts(LinkModel products) {
		this.products = products;
	}


	@Override
	public String toString() {

		return "class BrandLinksModel {\n" +
				"		self: " +
				ModelUtils.toIndentedString(self) +
				"\n" +
				"		canonical: " +
				ModelUtils.toIndentedString(canonical) +
				"\n" +
				"		products: " +
				ModelUtils.toIndentedString(products) +
				"\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BrandLinksModel other = (BrandLinksModel) o;
		if (!Objects.equals(self, other.self)) return false;
		if (!Objects.equals(canonical, other.canonical)) return false;
		return Objects.equals(products, other.products);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(self),
				Objects.hashCode(canonical),
				Objects.hashCode(products));
	}
}
