package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Objects;


/**
 * Used when the delete of an entity used by other entities is requested
 **/

/**
 * Auto-generated using Swagger codegen.
 * Used when the delete of an entity used by other entities is requested
 *
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */


@io.swagger.annotations.ApiModel(description = "Used when the delete of an entity used by other entities is requested")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"_allowed"}, allowGetters = true, ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("inuse-error")
public class InuseErrorModel extends InputValidationErrorModel {

	/**
	 * The list of the entities using the one requested to be deleted
	 */
	protected java.util.List<Object> usedByEntities = null;

	/** Create an empty InuseErrorModel with all attributes null */
	public InuseErrorModel() {
	}

	/**
	 * Allow all declared HTTP methods.
	 */
	@Override
	public InuseErrorModel allowAllDeclaredMethods() {
		super.allowAllDeclaredMethods();
		return this;
	}


	/**
	 * The list of the entities using the one requested to be deleted
	 **/
	public InuseErrorModel usedByEntities(java.util.List<Object> usedByEntities) {
		this.usedByEntities = usedByEntities;
		return this;
	}

	/**
	 * @return The list of the entities using the one requested to be deleted
	 */
	@io.swagger.annotations.ApiModelProperty(example = "null", value = "The list of the entities using the one requested to be deleted")
	@com.fasterxml.jackson.annotation.JsonProperty("used_by_entities")
	public java.util.List<Object> getUsedByEntities() {

		return usedByEntities;
	}

	/**
	 * Set usedByEntities
	 */
	public void setUsedByEntities(java.util.List<Object> usedByEntities) {
		this.usedByEntities = usedByEntities;
	}


	/**
	 *
	 **/
	@Override
	public InuseErrorModel errorType(ErrorTypeModel errorType) {
		this.errorType = errorType;
		return this;
	}

	/**
	 *
	 **/
	@Override
	public InuseErrorModel message(String message) {
		this.message = message;
		return this;
	}

	/**
	 *
	 **/
	@Override
	public InuseErrorModel perPropertyErrorMessages(java.util.List<FieldInputValidationErrorModel> perPropertyErrorMessages) {
		this.perPropertyErrorMessages = perPropertyErrorMessages;
		return this;
	}

	/**
	 * Sets HTTP Method GET as allowed
	 */
	public InuseErrorModel allowGET() {
		super.allowGET();
		return this;
	}

	/**
	 * Sets HTTP Method GET as denied
	 */
	public InuseErrorModel denyGET() {
		super.denyGET();
		return this;
	}

	/**
	 * Sets HTTP Method POST as allowed
	 */
	public InuseErrorModel allowPOST() {
		super.allowPOST();
		return this;
	}

	/**
	 * Sets HTTP Method POST as denied
	 */
	public InuseErrorModel denyPOST() {
		super.denyPOST();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as allowed
	 */
	public InuseErrorModel allowPATCH() {
		super.allowPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PATCH as denied
	 */
	public InuseErrorModel denyPATCH() {
		super.denyPATCH();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as allowed
	 */
	public InuseErrorModel allowPUT() {
		super.allowPUT();
		return this;
	}

	/**
	 * Sets HTTP Method PUT as denied
	 */
	public InuseErrorModel denyPUT() {
		super.denyPUT();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as allowed
	 */
	public InuseErrorModel allowDELETE() {
		super.allowDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method DELETE as denied
	 */
	public InuseErrorModel denyDELETE() {
		super.denyDELETE();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as allowed
	 */
	public InuseErrorModel allowOPTIONS() {
		super.allowOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method OPTIONS as denied
	 */
	public InuseErrorModel denyOPTIONS() {
		super.denyOPTIONS();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as allowed
	 */
	public InuseErrorModel allowHEAD() {
		super.allowHEAD();
		return this;
	}

	/**
	 * Sets HTTP Method HEAD as denied
	 */
	public InuseErrorModel denyHEAD() {
		super.denyHEAD();
		return this;
	}

	/**
	 * Sets all HTTP Methods as denied
	 */
	public InuseErrorModel denyAll() {
		super.denyAll();
		return this;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InuseErrorModel {\n");
		sb.append("		").append(ModelUtils.toIndentedString(super.toString())).append("\n");
		sb.append("		usedByEntities: ").append(ModelUtils.toIndentedString(usedByEntities)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		InuseErrorModel other = (InuseErrorModel) o;
		if (!Objects.equals(usedByEntities, other.usedByEntities)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(new int[]{
				super.hashCode(),
				Objects.hashCode(usedByEntities),

		});
	}
}
