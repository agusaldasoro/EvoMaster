package com.foo.rest.examples.spring.market.error;

import com.foo.rest.examples.spring.market.exception.EnumerationNotFoundException;

/**
 * The different types of error
 **/
public enum ErrorTypeModel {
	UNAUTHORIZED("unauthorized"),
	FORBIDDEN("forbidden"),
	NOT_FOUND("not_found"),
	NOT_ALLOWED("not_allowed"),
	GONE("gone"),
	PRECONDITION_FAILED("precondition_failed"),
	MISSING_PARAMETER("missing_parameter"),
	MISSING_FIELD("missing_field"),
	INVALID_VALUE("invalid_value"),
	IMMUTABLE_OBJECT("immutable_object"),
	SEGMENT_RANKER("segment_ranker"),
	NOT_IMPLEMENTED("not_implemented"),
	INTERNAL_SERVER_ERROR("internal_server_error"),
	INVALID_INPUT("invalid_input"),
	OPERATION_NOT_PERMITTED("operation_not_permitted"),
	ENTITY_IN_USE("entity_in_use"),
	CONFLICT("conflict");

	private String value;

	ErrorTypeModel(String value) {
		this.value = value;
	}

	@Override
	@com.fasterxml.jackson.annotation.JsonValue
	public String toString() {
		return value.toString();
	}

	public static ErrorTypeModel fromString(String value) {
		for (ErrorTypeModel e : values()) {
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

