package com.foo.rest.examples.spring.market.model;

import com.foo.rest.examples.spring.market.exception.EnumerationNotFoundException;

import java.util.Objects;
import java.util.Optional;


/**
 * A &#x60;Brand&#x60; is the object used to represent the store.
 **/

/**
 * Auto-generated using Swagger codegen.
 * A &#x60;Brand&#x60; is the object used to represent the store.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 *
 */

@io.swagger.annotations.ApiModel(description = "A `Brand` is the object used to represent the store.")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("brand-patch")
public class BrandPatchModel {

	protected Optional<String> id = null;

	/**
	 * Name of the `Brand`
	 */
	protected Optional<String> name = null;

	/**
	 * Description of the `Brand`
	 */
	protected Optional<String> description = null;

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
	protected Optional<TypeEnum> type = null;

	/**
	 * the name of the owner of the Brand
	 */
	protected Optional<String> owner = null;

	/** Create an empty BrandPatchModel with all attributes null */
	public BrandPatchModel() {
	}

	/**
	 **/
	public BrandPatchModel id(Optional<String> id) {
		this.id = id;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", required = true, value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	public Optional<String> getId() {
		return id;
	}

	public void setId(Optional<String> id) {
		this.id = id;
	}

	/**
	 * Name of the &#x60;Brand&#x60;
	 **/
	public BrandPatchModel name(Optional<String> name) {
		this.name = name;
		return this;
	}

	/**
	 * @return Name of the &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", required = true, value = "Name of the `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	public Optional<String> getName() {
		return name;
	}

	/**
	 *	Set name
	 */
	public void setName(Optional<String> name) {
		this.name = name;
	}

	/**
	 * Description of the &#x60;Brand&#x60;
	 **/
	public BrandPatchModel description(Optional<String> description) {
		this.description = description;
		return this;
	}

	/**
	 * @return Description of the &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Description of the `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	public Optional<String> getDescription() {
		return description;
	}

	/**
	 *	Set description
	 */
	public void setDescription(Optional<String> description) {
		this.description = description;
	}

	/**
	 * Type of &#x60;Brand&#x60;
	 **/
	public BrandPatchModel type(Optional<TypeEnum> type) {
		this.type = type;
		return this;
	}

	/**
	 * @return Type of &#x60;Brand&#x60;
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Type of `Brand`")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	public Optional<TypeEnum> getType() {
		return type;
	}

	/**
	 *	Set type
	 */
	public void setType(Optional<TypeEnum> type) {
		this.type = type;
	}

	/**
	 * the name of the owner of the Brand
	 **/
	public BrandPatchModel owner(Optional<String> owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * @return the name of the owner of the Brand
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "the name of the owner of the Brand")
	@com.fasterxml.jackson.annotation.JsonProperty("owner")
	public Optional<String> getOwner() {
		return owner;
	}

	/**
	 *	Set owner
	 */
	public void setOwner(Optional<String> owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BrandPatchModel {\n");
		sb.append("		id: ").append(ModelUtils.toIndentedString(id)).append("\n");
		sb.append("		name: ").append(ModelUtils.toIndentedString(name)).append("\n");
		sb.append("		description: ").append(ModelUtils.toIndentedString(description)).append("\n");
		sb.append("		type: ").append(ModelUtils.toIndentedString(type)).append("\n");
		sb.append("		owner: ").append(ModelUtils.toIndentedString(owner)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BrandPatchModel other = (BrandPatchModel) o;
		if (!Objects.equals(id, other.id)) return false;
		if (!Objects.equals(name, other.name)) return false;
		if (!Objects.equals(description, other.description)) return false;
		if (!Objects.equals(type, other.type)) return false;
		if (!Objects.equals(owner, other.owner)) return false;
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
		});
	}
}

