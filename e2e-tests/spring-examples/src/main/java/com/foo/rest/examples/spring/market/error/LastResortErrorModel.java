package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Objects;


/**
 * Used in case none of the above can be used, and more context information than what the &#x60;error&#x60; can handle is required.
 **/

/**
 * Auto-generated using Swagger codegen.
 * Used in case none of the above can be used, and more context information than what the &#x60;error&#x60; can handle is required.
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Used in case none of the above can be used, and more context information than what the `error` can handle is required. ")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("last-resort-error")
public class LastResortErrorModel extends InputValidationErrorModel {

	/**
	 * A Generic context (timestamp, stackdump, uri, etc) handled by the framework.
	 */
	protected Object genericContext = null;

	/**
	 * Can contain any object the client may need to know about the context of the error. A Map<String, Object> can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON.
	 */
	protected Object errorContext = null;

	/** Create an empty LastResortErrorModel with all attributes null */
	public LastResortErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	@Override
	public LastResortErrorModel allowAllDeclaredMethods() {
		super.allowAllDeclaredMethods();
		return this;
	}


	/**
	 * A Generic context (timestamp, stackdump, uri, etc) handled by the framework.
	 **/
	public LastResortErrorModel genericContext(Object genericContext) {
		this.genericContext = genericContext;
		return this;
	}

	/**
	 * @return A Generic context (timestamp, stackdump, uri, etc) handled by the framework.
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "A Generic context (timestamp, stackdump, uri, etc) handled by the framework.")
	@com.fasterxml.jackson.annotation.JsonProperty("generic_context")
	public Object getGenericContext() {

		return genericContext;
	}

	/**
	 *	Set genericContext
	 */
	public void setGenericContext(Object genericContext) {
		this.genericContext = genericContext;
	}


	/**
	 * Can contain any object the client may need to know about the context of the error. A Map&lt;String, Object&gt; can be specially convenient, as the values (Object) in the map can be named by the key (String), and rendered in JSON.
	 **/
	public LastResortErrorModel errorContext(Object errorContext) {
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
	public LastResortErrorModel errorType(ErrorTypeModel errorType) {
		this.errorType = errorType;
		return this;
	}

	/**
	 **/
	@Override
	public LastResortErrorModel message(String message) {
		this.message = message;
		return this;
	}

	/**
	 **/
	@Override
	public LastResortErrorModel perPropertyErrorMessages(java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages) {
		this.perPropertyErrorMessages = perPropertyErrorMessages;
		return this;
	}

	/**
	 * Sets HTTP Method GET as allowed
	 */
	public LastResortErrorModel allowGET() {
		super.allowGET();
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public LastResortErrorModel denyGET() {
		super.denyGET();
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public LastResortErrorModel allowPOST() {
		super.allowPOST();
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public LastResortErrorModel denyPOST() {
		super.denyPOST();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public LastResortErrorModel allowPATCH() {
		super.allowPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public LastResortErrorModel denyPATCH() {
		super.denyPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public LastResortErrorModel allowPUT() {
		super.allowPUT();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public LastResortErrorModel denyPUT() {
		super.denyPUT();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public LastResortErrorModel allowDELETE() {
		super.allowDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public LastResortErrorModel denyDELETE() {
		super.denyDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public LastResortErrorModel allowOPTIONS() {
		super.allowOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public LastResortErrorModel denyOPTIONS() {
		super.denyOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public LastResortErrorModel allowHEAD() {
		super.allowHEAD();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public LastResortErrorModel denyHEAD() {
		super.denyHEAD();
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public LastResortErrorModel denyAll() {
		super.denyAll();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LastResortErrorModel {\n");
		sb.append("		").append(ModelUtils.toIndentedString(super.toString())).append("\n");
		sb.append("		genericContext: ").append(ModelUtils.toIndentedString(genericContext)).append("\n");
		sb.append("		errorContext: ").append(ModelUtils.toIndentedString(errorContext)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		LastResortErrorModel other = (LastResortErrorModel) o;
		if (!Objects.equals(genericContext, other.genericContext)) return false;
		if (!Objects.equals(errorContext, other.errorContext)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				super.hashCode(),
				Objects.hashCode(genericContext),
				Objects.hashCode(errorContext),

		});
	}
}

