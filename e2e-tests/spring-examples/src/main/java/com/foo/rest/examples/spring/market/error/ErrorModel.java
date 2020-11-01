package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Collections;
import java.util.Objects;


/**
 * Auto-generated using Swagger codegen.
 *
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("error")
public class ErrorModel {

	protected ErrorTypeModel errorType = null;

	protected String message = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty ErrorModel with all attributes null */
	public ErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	public ErrorModel allowAllDeclaredMethods() {

		return this;
	}


	/**
	 *
	 **/
	public ErrorModel errorType(ErrorTypeModel errorType) {
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
	public ErrorModel message(String message) {
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
	public ErrorModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public ErrorModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public ErrorModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public ErrorModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public ErrorModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public ErrorModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public ErrorModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public ErrorModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public ErrorModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public ErrorModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public ErrorModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public ErrorModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public ErrorModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public ErrorModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public ErrorModel denyAll() {
		this.allowed.clear();
		return this;
	}


	public String toString() {

		return "class ErrorModel {\n" +
				"		errorType: " + ModelUtils.toIndentedString(errorType) + "\n" +
				"		message: " + ModelUtils.toIndentedString(message) + "\n" +
				"		allowed: " + ModelUtils.toIndentedString(allowed) + "\n" +
				"}";
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ErrorModel other = (ErrorModel) o;
		if (!Objects.equals(errorType, other.errorType)) return false;
		if (!Objects.equals(message, other.message)) return false;
		return Objects.equals(allowed, other.allowed);
	}


	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(errorType),
				Objects.hashCode(message),
				Objects.hashCode(allowed));
	}
}
