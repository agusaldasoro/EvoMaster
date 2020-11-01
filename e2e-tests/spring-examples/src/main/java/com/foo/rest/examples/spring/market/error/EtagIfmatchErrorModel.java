package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Collections;
import java.util.Objects;


/**
 * Used when the ETag check fails (If-Match).
 **/

/**
 * Auto-generated using Swagger codegen.
 * Used when the ETag check fails (If-Match).
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Used when the ETag check fails (If-Match).")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("etag-ifmatch-error")
public class EtagIfmatchErrorModel {

	protected ErrorTypeModel errorType = null;

	protected String message = null;

	/**
	 * The content of entity as it is stored
	 */
	protected Object storedEntity = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty EtagIfmatchErrorModel with all attributes null */
	public EtagIfmatchErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public EtagIfmatchErrorModel allowAllDeclaredMethods() {

		return this;
	}


	/**
	 *
	 **/
	public EtagIfmatchErrorModel errorType(ErrorTypeModel errorType) {
		this.errorType = errorType;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("error_type")
	public ErrorTypeModel getErrorType() {

		return errorType;
	}

	public void setErrorType(ErrorTypeModel errorType) {
		this.errorType = errorType;
	}


	/**
	 *
	 **/
	public EtagIfmatchErrorModel message(String message) {
		this.message = message;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("message")
	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * The content of entity as it is stored
	 **/
	public EtagIfmatchErrorModel storedEntity(Object storedEntity) {
		this.storedEntity = storedEntity;
		return this;
	}

	/**
	 * @return The content of entity as it is stored
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "The content of entity as it is stored")
	@com.fasterxml.jackson.annotation.JsonProperty("stored_entity")
	public Object getStoredEntity() {

		return storedEntity;
	}

	/**
	 * Set storedEntity
	 */
	public void setStoredEntity(Object storedEntity) {
		this.storedEntity = storedEntity;
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
	public EtagIfmatchErrorModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public EtagIfmatchErrorModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public EtagIfmatchErrorModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public EtagIfmatchErrorModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public EtagIfmatchErrorModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public EtagIfmatchErrorModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public EtagIfmatchErrorModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public EtagIfmatchErrorModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public EtagIfmatchErrorModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public EtagIfmatchErrorModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public EtagIfmatchErrorModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public EtagIfmatchErrorModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public EtagIfmatchErrorModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public EtagIfmatchErrorModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public EtagIfmatchErrorModel denyAll() {
		this.allowed.clear();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EtagIfmatchErrorModel {\n");

		sb.append("		errorType: ").append(ModelUtils.toIndentedString(errorType)).append("\n");
		sb.append("		message: ").append(ModelUtils.toIndentedString(message)).append("\n");
		sb.append("		storedEntity: ").append(ModelUtils.toIndentedString(storedEntity)).append("\n");
		sb.append("		allowed: ").append(ModelUtils.toIndentedString(allowed)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EtagIfmatchErrorModel other = (EtagIfmatchErrorModel) o;
		if (!Objects.equals(errorType, other.errorType)) return false;
		if (!Objects.equals(message, other.message)) return false;
		if (!Objects.equals(storedEntity, other.storedEntity)) return false;
		if (!Objects.equals(allowed, other.allowed)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				Objects.hashCode(errorType),
				Objects.hashCode(message),
				Objects.hashCode(storedEntity),
				Objects.hashCode(allowed),

		});
	}
}
