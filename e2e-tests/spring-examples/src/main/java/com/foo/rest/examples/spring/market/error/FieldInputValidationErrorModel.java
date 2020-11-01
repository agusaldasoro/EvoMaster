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
@com.fasterxml.jackson.annotation.JsonTypeName("field-input-validation-error")
public class FieldInputValidationErrorModel {

	protected ErrorTypeModel errorType = null;

	protected String field = null;

	protected String value = null;

	protected String message = null;

	/**
	 * Array of allowed HTTP methods
	 */
	protected java.util.Set<String> allowed = new java.util.HashSet<String>();

	/** Create an empty FieldInputValidationErrorModel with all attributes null */
	public FieldInputValidationErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */

	public FieldInputValidationErrorModel allowAllDeclaredMethods() {

		return this;
	}


	/**
	 *
	 **/
	public FieldInputValidationErrorModel errorType(ErrorTypeModel errorType) {
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
	public FieldInputValidationErrorModel field(String field) {
		this.field = field;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("field")
	public String getField() {

		return field;
	}

	public void setField(String field) {
		this.field = field;
	}


	/**
	 *
	 **/
	public FieldInputValidationErrorModel value(String value) {
		this.value = value;
		return this;
	}

	@io.swagger.annotations.ApiModelProperty(example = "null", value = "")
	@com.fasterxml.jackson.annotation.JsonProperty("value")
	public String getValue() {

		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	/**
	 *
	 **/
	public FieldInputValidationErrorModel message(String message) {
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
	public FieldInputValidationErrorModel allowGET() {
		this.allowed.add("GET");
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public FieldInputValidationErrorModel denyGET() {
		this.allowed.remove("GET");
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public FieldInputValidationErrorModel allowPOST() {
		this.allowed.add("POST");
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public FieldInputValidationErrorModel denyPOST() {
		this.allowed.remove("POST");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public FieldInputValidationErrorModel allowPATCH() {
		this.allowed.add("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public FieldInputValidationErrorModel denyPATCH() {
		this.allowed.remove("PATCH");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public FieldInputValidationErrorModel allowPUT() {
		this.allowed.add("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public FieldInputValidationErrorModel denyPUT() {
		this.allowed.remove("PUT");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public FieldInputValidationErrorModel allowDELETE() {
		this.allowed.add("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public FieldInputValidationErrorModel denyDELETE() {
		this.allowed.remove("DELETE");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public FieldInputValidationErrorModel allowOPTIONS() {
		this.allowed.add("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public FieldInputValidationErrorModel denyOPTIONS() {
		this.allowed.remove("OPTIONS");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public FieldInputValidationErrorModel allowHEAD() {
		this.allowed.add("HEAD");
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public FieldInputValidationErrorModel denyHEAD() {
		this.allowed.remove("HEAD");
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public FieldInputValidationErrorModel denyAll() {
		this.allowed.clear();
		return this;
	}


	public String toString() {

		return "class FieldInputValidationErrorModel {\n" +
				"		errorType: " + ModelUtils.toIndentedString(errorType) + "\n" +
				"		field: " + ModelUtils.toIndentedString(field) + "\n" +
				"		value: " + ModelUtils.toIndentedString(value) + "\n" +
				"		message: " + ModelUtils.toIndentedString(message) + "\n" +
				"		allowed: " + ModelUtils.toIndentedString(allowed) + "\n" +
				"}";
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FieldInputValidationErrorModel other = (FieldInputValidationErrorModel) o;
		if (!Objects.equals(errorType, other.errorType)) return false;
		if (!Objects.equals(field, other.field)) return false;
		if (!Objects.equals(value, other.value)) return false;
		if (!Objects.equals(message, other.message)) return false;
		return Objects.equals(allowed, other.allowed);
	}


	public int hashCode() {
		return ModelUtils.combineIntHashes(Objects.hashCode(errorType),
				Objects.hashCode(field),
				Objects.hashCode(value),
				Objects.hashCode(message),
				Objects.hashCode(allowed));
	}
}
