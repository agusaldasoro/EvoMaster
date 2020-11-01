package com.foo.rest.examples.spring.market.link;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Objects;


/**
 * Generated links for [product] (x-links)
 **/

/**
 * Auto-generated using Swagger codegen.
 * Generated links for [product] (x-links)
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Generated links for [product] (x-links)")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("product__links")
public class ProductLinksModel {

	protected LinkModel self = null;

	protected LinkModel canonical = null;

	/** Create an empty ProductLinksModel with all attributes null */
	public ProductLinksModel() {
	}


	/**
	 **/
	public ProductLinksModel self(LinkModel self) {
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


	/**
	 **/
	public ProductLinksModel canonical(LinkModel canonical) {
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


	@Override
	public String toString() {

		return "class ProductLinksModel {\n" +
				"		self: " + ModelUtils.toIndentedString(self) + "\n" +
				"		canonical: " + ModelUtils.toIndentedString(canonical) + "\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProductLinksModel other = (ProductLinksModel) o;
		if (!Objects.equals(self, other.self)) return false;
		return Objects.equals(canonical, other.canonical);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(self),
				Objects.hashCode(canonical));
	}
}
