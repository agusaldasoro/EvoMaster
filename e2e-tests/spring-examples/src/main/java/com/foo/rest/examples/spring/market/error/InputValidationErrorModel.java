package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Collections;
import java.util.Objects;


/**
 * Generic validation error
 **/

/**
 * Auto-generated using Swagger codegen.
 * Generic validation error
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@com.fasterxml.jackson.annotation.JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@com.fasterxml.jackson.annotation.JsonSubTypes({
		@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = BusinessLogicErrorModel.class, name = "business-logic-error"),
		@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = InuseErrorModel.class, name = "inuse-error"),
		@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = LastResortErrorModel.class, name = "last-resort-error"),
})
@io.swagger.annotations.ApiModel(description = "Generic validation error")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("input-validation-error")
// @com.fasterxml.jackson.annotation.JsonPropertyOrder(alphabetic = true)
public abstract class InputValidationErrorModel {

	protected ErrorTypeModel errorType = null;

	protected String message = null;

	protected java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty InputValidationErrorModel with all attributes null */
	public InputValidationErrorModel() {
	}


	/**
	 * Allow all declared HTTP methods.
	 */

	public InputValidationErrorModel allowAllDeclaredMethods() {

		return this;
	}


	/**
	 *
	 **/
	public InputValidationErrorModel errorType(ErrorTypeModel errorType) {
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
	public InputValidationErrorModel message(String message) {
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
	 *
	 **/
	public InputValidationErrorModel perPropertyErrorMessages(java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages) {
		this.perPropertyErrorMessages = perPropertyErrorMessages;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("per_property_error_messages")
	public java.util.List<FieldInputValidationErrorModel> getPerPropertyErrorMessages() {

		return perPropertyErrorMessages;
	}

	public void setPerPropertyErrorMessages(java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages) {
		this.perPropertyErrorMessages = perPropertyErrorMessages;
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
	public InputValidationErrorModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public InputValidationErrorModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public InputValidationErrorModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public InputValidationErrorModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public InputValidationErrorModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public InputValidationErrorModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public InputValidationErrorModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public InputValidationErrorModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public InputValidationErrorModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public InputValidationErrorModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public InputValidationErrorModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public InputValidationErrorModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public InputValidationErrorModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public InputValidationErrorModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public InputValidationErrorModel denyAll() {
		this.allowed.clear();
		return this;
	}


	public String toString() {

		return "class InputValidationErrorModel {\n" +
				"		errorType: " + ModelUtils.toIndentedString(errorType) + "\n" +
				"		message: " + ModelUtils.toIndentedString(message) + "\n" +
				"		perPropertyErrorMessages: " + ModelUtils.toIndentedString(perPropertyErrorMessages) + "\n" +
				"		allowed: " + ModelUtils.toIndentedString(allowed) + "\n" +
				"}";
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		InputValidationErrorModel other = (InputValidationErrorModel) o;
		if (!Objects.equals(errorType, other.errorType)) return false;
		if (!Objects.equals(message, other.message)) return false;
		if (!Objects.equals(perPropertyErrorMessages, other.perPropertyErrorMessages)) return false;
		return Objects.equals(allowed, other.allowed);
	}


	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(errorType),
				Objects.hashCode(message),
				Objects.hashCode(perPropertyErrorMessages),
				Objects.hashCode(allowed));
	}
}

