package com.foo.rest.examples.spring.market.model;

import com.foo.rest.examples.spring.market.exception.EnumerationNotFoundException;
import com.foo.rest.examples.spring.market.link.BrandLinksModel;

import java.util.Collections;
import java.util.Objects;


/**
 * A &#x60;Brand&#x60; is the object used to represent the store.
 **/

/**
 * Auto-generated using Swagger codegen.
 * A &#x60;Brand&#x60; is the object used to represent the store.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "A `Brand` is the object used to represent the store.")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("brand")
public class BrandModel {

	protected String id = null;

	/**
	 * Name of the `Brand`
	 */
	protected String name = null;

	/**
	 * Description of the `Brand`
	 */
	protected String description = null;

	public enum TypeEnum {
		ONLINE("online"),
		STORE("store");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@com.fasterxml.jackson.annotation.JsonValue
		public String toString() {
			return value.toString();
		}

		public static TypeEnum fromString(String value) {
			for (TypeEnum e : values()) {
				if (e.toString().equals(value)) {
					return e;
				}
			}
			try {
				return valueOf(value);
			} catch (IllegalArgumentException e) {
				throw new EnumerationNotFoundException(value, e);
			}
		}

	}

	/**
	 * Type of `Brand`
	 */
	protected TypeEnum type = null;

	/**
	 * the name of the owner of the Brand
	 */
	protected String owner = null;

	protected BrandLinksModel links = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty BrandModel with all attributes null */
	public BrandModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public BrandModel allowAllDeclaredMethods() {

		this.allowDELETE();
		this.allowGET();
		this.allowPATCH();
		return this;
	}


	/**
	 *
	 **/
	public BrandModel id(String id) {
		this.id = id;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", required = true, value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	public String getId() {

		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Name of the &#x60;Brand&#x60;
	 **/
	public BrandModel name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return Name of the &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", required = true, value = "Name of the `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	public String getName() {

		return name;
	}

	/**
	 * Set name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Description of the &#x60;Brand&#x60;
	 **/
	public BrandModel description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @return Description of the &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Description of the `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	public String getDescription() {

		return description;
	}

	/**
	 * Set description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Type of &#x60;Brand&#x60;
	 **/
	public BrandModel type(TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * @return Type of &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Type of `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	public TypeEnum getType() {

		return type;
	}

	/**
	 * Set type
	 */
	public void setType(TypeEnum type) {
		this.type = type;
	}


	/**
	 * the name of the owner of the Brand
	 **/
	public BrandModel owner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * @return the name of the owner of the Brand
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "the name of the owner of the Brand")
	@com.fasterxml.jackson.annotation.JsonProperty("owner")
	public String getOwner() {

		return owner;
	}

	/**
	 * Set owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}


	/**
	 *
	 **/
	public BrandModel links(BrandLinksModel links) {
		this.links = links;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("_links")
	public BrandLinksModel getLinks() {

		return links;
	}

	public void setLinks(BrandLinksModel links) {
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
	public BrandModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public BrandModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public BrandModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public BrandModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public BrandModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public BrandModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public BrandModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public BrandModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public BrandModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public BrandModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public BrandModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public BrandModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public BrandModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public BrandModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public BrandModel denyAll() {
		this.allowed.clear();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BrandModel {\n");

		sb.append("		id: ").append(ModelUtils.toIndentedString(id)).append("\n");
		sb.append("		name: ").append(ModelUtils.toIndentedString(name)).append("\n");
		sb.append("		description: ").append(ModelUtils.toIndentedString(description)).append("\n");
		sb.append("		type: ").append(ModelUtils.toIndentedString(type)).append("\n");
		sb.append("		owner: ").append(ModelUtils.toIndentedString(owner)).append("\n");
		sb.append("		links: ").append(ModelUtils.toIndentedString(links)).append("\n");
		sb.append("		allowed: ").append(ModelUtils.toIndentedString(allowed)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BrandModel other = (BrandModel) o;
		if (!Objects.equals(id, other.id)) return false;
		if (!Objects.equals(name, other.name)) return false;
		if (!Objects.equals(description, other.description)) return false;
		if (!Objects.equals(type, other.type)) return false;
		if (!Objects.equals(owner, other.owner)) return false;
		if (!Objects.equals(links, other.links)) return false;
		if (!Objects.equals(allowed, other.allowed)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				Objects.hashCode(id),
				Objects.hashCode(name),
				Objects.hashCode(description),
				Objects.hashCode(type),
				Objects.hashCode(owner),
				Objects.hashCode(links),
				Objects.hashCode(allowed),

		});
	}
}
