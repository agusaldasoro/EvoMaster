package com.foo.rest.examples.spring.market.model;

import java.util.Objects;
import java.util.Optional;


/**
 * A &#x60;Product&#x60; is the object used to represent the each item that the store sells.
 **/

/**
 * Auto-generated using Swagger codegen.
 * A &#x60;Product&#x60; is the object used to represent the each item that the store sells.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */

@io.swagger.annotations.ApiModel(description = "A `Product` is the object used to represent the each item that the store sells.")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("product-patch")
public class ProductPatchModel {

	protected Optional<String> id = null;

	/**
	 * Name of the `Product`
	 */
	protected Optional<String> name = null;

	/** Create an empty ProductPatchModel with all attributes null */
	public ProductPatchModel() {
	}

	/**
	 *
	 **/
	public ProductPatchModel id(Optional<String> id) {
		this.id = id;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	public Optional<String> getId() {
		return id;
	}

	public void setId(Optional<String> id) {
		this.id = id;
	}

	/**
	 * Name of the &#x60;Product&#x60;
	 **/
	public ProductPatchModel name(Optional<String> name) {
		this.name = name;
		return this;
	}

	/**
	 * @return Name of the &#x60;Product&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Name of the `Product`")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	public Optional<String> getName() {
		return name;
	}

	/**
	 * Set name
	 */
	public void setName(Optional<String> name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "class ProductPatchModel {\n" +
				"		id: " + ModelUtils.toIndentedString(id) + "\n" +
				"		name: " + ModelUtils.toIndentedString(name) + "\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductPatchModel other = (ProductPatchModel) o;
		if (!Objects.equals(id, other.id)) return false;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(id),
				Objects.hashCode(name));
	}
}

