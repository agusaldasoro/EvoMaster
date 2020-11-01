package com.foo.rest.examples.spring.market.model;

import com.foo.rest.examples.spring.market.link.ProductLinksModel;

import java.util.Collections;
import java.util.Objects;


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
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("product")
public class ProductModel {

	protected String id = null;

	/**
	 * Name of the `Product`
	 */
	protected String name = null;

	protected ProductLinksModel links = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty ProductModel with all attributes null */
	public ProductModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public ProductModel allowAllDeclaredMethods() {

		this.allowDELETE();
		this.allowGET();
		this.allowPATCH();
		return this;
	}


	/**
	 **/
	public ProductModel id(String id) {
		this.id = id;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	public String getId() {

		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Name of the &#x60;Product&#x60;
	 **/
	public ProductModel name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return Name of the &#x60;Product&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Name of the `Product`")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	public String getName() {

		return name;
	}

	/**
	 *	Set name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 **/
	public ProductModel links(ProductLinksModel links) {
		this.links = links;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("_links")
	public ProductLinksModel getLinks() {

		return links;
	}

	public void setLinks(ProductLinksModel links) {
		this.links = links;
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
	public ProductModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public ProductModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public ProductModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public ProductModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public ProductModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public ProductModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public ProductModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public ProductModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public ProductModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public ProductModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public ProductModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public ProductModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public ProductModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public ProductModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public ProductModel denyAll() {
		this.allowed.clear();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductModel {\n");

		sb.append("		id: ").append(ModelUtils.toIndentedString(id)).append("\n");
		sb.append("		name: ").append(ModelUtils.toIndentedString(name)).append("\n");
		sb.append("		links: ").append(ModelUtils.toIndentedString(links)).append("\n");
		sb.append("		allowed: ").append(ModelUtils.toIndentedString(allowed)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProductModel other = (ProductModel) o;
		if (!Objects.equals(id, other.id)) return false;
		if (!Objects.equals(name, other.name)) return false;
		if (!Objects.equals(links, other.links)) return false;
		if (!Objects.equals(allowed, other.allowed)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				Objects.hashCode(id),
				Objects.hashCode(name),
				Objects.hashCode(links),
				Objects.hashCode(allowed),

		});
	}
}
