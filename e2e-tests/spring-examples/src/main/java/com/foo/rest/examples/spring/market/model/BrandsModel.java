package com.foo.rest.examples.spring.market.model;

import java.util.Collections;
import java.util.Objects;


/**
 * A &#x60;Brand&#x60; collection.
 **/

/**
 * Auto-generated using Swagger codegen.
 * A &#x60;Brand&#x60; collection.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "A `Brand` collection.")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("brands")
public class BrandsModel extends CollectionModel<BrandModel> {

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty BrandsModel with all attributes null */
	public BrandsModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public BrandsModel allowAllDeclaredMethods() {

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
	public BrandsModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public BrandsModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public BrandsModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public BrandsModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public BrandsModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public BrandsModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public BrandsModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public BrandsModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public BrandsModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public BrandsModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public BrandsModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public BrandsModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public BrandsModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public BrandsModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public BrandsModel denyAll() {
		this.allowed.clear();
		return this;
	}


	@Override
	public String toString() {
		return "class BrandsModel {\n" +
				"		" + ModelUtils.toIndentedString(super.toString()) + "\n" +
				"		allowed: " + ModelUtils.toIndentedString(allowed) + "\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		BrandsModel other = (BrandsModel) o;
		return Objects.equals(allowed, other.allowed);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(super.hashCode(),
				Objects.hashCode(allowed));
	}
}
