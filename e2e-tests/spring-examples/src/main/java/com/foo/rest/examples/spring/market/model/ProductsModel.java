package com.foo.rest.examples.spring.market.model;

import java.util.Collections;
import java.util.Objects;


/**
 * A &#x60;Product&#x60; collection.
 **/

/**
 * Auto-generated using Swagger codegen.
 * A &#x60;Product&#x60; collection.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "A `Product` collection.")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("products")
public class ProductsModel extends CollectionModel<ProductModel> {

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty ProductsModel with all attributes null */
	public ProductsModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public ProductsModel allowAllDeclaredMethods() {

		this.allowGET();
		this.allowPOST();
		return this;
	}


	/**
	 * @return Array of allowed HTTP methods
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Array of allowed HTTP methods")
	@com.fasterxml.jackson.annotation.JsonProperty("_allowed")
	public java.util.Set<String> getAllowed() {

		return Collections.unmodifiableSet(allowed);
	}


	/**
	 * Sets HTTP Method GET as allowed
	 */
	public ProductsModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public ProductsModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public ProductsModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public ProductsModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public ProductsModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public ProductsModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public ProductsModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public ProductsModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public ProductsModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public ProductsModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public ProductsModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public ProductsModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public ProductsModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public ProductsModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public ProductsModel denyAll() {
		this.allowed.clear();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductsModel {\n");
		sb.append("		").append(ModelUtils.toIndentedString(super.toString())).append("\n");
		sb.append("		allowed: ").append(ModelUtils.toIndentedString(allowed)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		ProductsModel other = (ProductsModel) o;
		if (!Objects.equals(allowed, other.allowed)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				super.hashCode(),
				Objects.hashCode(allowed),

		});
	}
}
