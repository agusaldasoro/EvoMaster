package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Objects;


/**
 * Used when a business logic rule has been violated
 **/

/**
 * Auto-generated using Swagger codegen.
 * Used when a business logic rule has been violated
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Used when a business logic rule has been violated")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("business-logic-error")
public class BusinessLogicErrorModel extends InputValidationErrorModel {

	/**
	 * Can contain any object the client may need to know about the context of the error. A Map<String, Object> can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON.
	 */
	protected Object errorContext = null;

	/** Create an empty BusinessLogicErrorModel with all attributes null */
	public BusinessLogicErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	@Override
	public BusinessLogicErrorModel allowAllDeclaredMethods() {
		super.allowAllDeclaredMethods();
		return this;
	}


	/**
	 * Can contain any object the client may need to know about the context of the error. A Map&lt;String, Object&gt; can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON.
	 **/
	public BusinessLogicErrorModel errorContext(Object errorContext) {
		this.errorContext = errorContext;
		return this;
	}

	/**
	 * @return Can contain any object the client may need to know about the context of the error. A Map&lt;String, Object&gt; can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON.
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "Can contain any object the client may need to know about the context of the error. A Map<String, Object> can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON. ")
	@com.fasterxml.jackson.annotation.JsonProperty("error_context")
	public Object getErrorContext() {

		return errorContext;
	}

	/**
	 *	Set errorContext
	 */
	public void setErrorContext(Object errorContext) {
		this.errorContext = errorContext;
	}


	/**
	 **/
	@Override
	public BusinessLogicErrorModel errorType(ErrorTypeModel errorType) {
		this.errorType = errorType;
		return this;
	}

	/**
	 **/
	@Override
	public BusinessLogicErrorModel message(String message) {
		this.message = message;
		return this;
	}

	/**
	 **/
	@Override
	public BusinessLogicErrorModel perPropertyErrorMessages(java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages) {
		this.perPropertyErrorMessages = perPropertyErrorMessages;
		return this;
	}

	/**
	 * Sets HTTP Method GET as allowed
	 */
	public BusinessLogicErrorModel allowGET() {
		super.allowGET();
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public BusinessLogicErrorModel denyGET() {
		super.denyGET();
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public BusinessLogicErrorModel allowPOST() {
		super.allowPOST();
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public BusinessLogicErrorModel denyPOST() {
		super.denyPOST();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public BusinessLogicErrorModel allowPATCH() {
		super.allowPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public BusinessLogicErrorModel denyPATCH() {
		super.denyPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public BusinessLogicErrorModel allowPUT() {
		super.allowPUT();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public BusinessLogicErrorModel denyPUT() {
		super.denyPUT();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public BusinessLogicErrorModel allowDELETE() {
		super.allowDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public BusinessLogicErrorModel denyDELETE() {
		super.denyDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public BusinessLogicErrorModel allowOPTIONS() {
		super.allowOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public BusinessLogicErrorModel denyOPTIONS() {
		super.denyOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public BusinessLogicErrorModel allowHEAD() {
		super.allowHEAD();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public BusinessLogicErrorModel denyHEAD() {
		super.denyHEAD();
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public BusinessLogicErrorModel denyAll() {
		super.denyAll();
		return this;
	}


	@Override
	public String toString() {
		return "class BusinessLogicErrorModel {\n" +
				"		" + ModelUtils.toIndentedString(super.toString()) + "\n" +
				"		errorContext: " + ModelUtils.toIndentedString(errorContext) + "\n" +
				"}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		BusinessLogicErrorModel other = (BusinessLogicErrorModel) o;
		return Objects.equals(errorContext, other.errorContext);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(super.hashCode(),
				Objects.hashCode(errorContext));
	}
}

