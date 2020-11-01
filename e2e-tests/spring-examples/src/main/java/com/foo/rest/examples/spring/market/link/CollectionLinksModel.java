package com.foo.rest.examples.spring.market.link;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("collection_links")
public class CollectionLinksModel {

	private static final String SELF = "self";
	/**
	 * @deprecated API-Spec 2.0 canonical cannot be used for collections
	 */
	@Deprecated
	private static final String CANONICAL = "canonical";
	private static final String PREV = "prev";
	private static final String NEXT = "next";

	protected Map<String, LinkModel> linkProperties;

	public CollectionLinksModel() {
		linkProperties = new LinkedHashMap<>();
		linkProperties.put(SELF, null);
		linkProperties.put(CANONICAL, null);
		linkProperties.put(PREV, null);
		linkProperties.put(NEXT, null);
	}

	@JsonAnyGetter
	public Map<String, LinkModel> linkProperties() {
		Map<String, LinkModel> linkPropertiesCopy = new LinkedHashMap<>(linkProperties);
		// since canonical property is deprecated we only show it when it has been set with a non-null value
		if (linkProperties.get(CANONICAL) == null) {
			linkPropertiesCopy.remove(CANONICAL);
		}
		return linkPropertiesCopy;
	}

	public CollectionLinksModel self(LinkModel self) {
		linkProperties.put(SELF, self);
		return this;
	}

	@JsonIgnore
	public LinkModel getSelf() {
		return linkProperties.get(SELF);
	}

	public void setSelf(LinkModel self) {
		linkProperties.put(SELF, self);
	}

	/**
	 * @deprecated API-Spec 2.0 canonical cannot be used for collections
	 */
	@Deprecated
	public CollectionLinksModel canonical(LinkModel canonical) {
		linkProperties.put(CANONICAL, canonical);
		return this;
	}

	/**
	 * @deprecated API-Spec 2.0 canonical cannot be used for collections
	 */
	@JsonIgnore
	@Deprecated
	public LinkModel getCanonical() {
		return linkProperties.get(CANONICAL);
	}

	/**
	 * @deprecated API-Spec 2.0 canonical cannot be used for collections
	 */
	@Deprecated
	public void setCanonical(LinkModel canonical) {
		linkProperties.put(CANONICAL, canonical);
	}

	public CollectionLinksModel prev(LinkModel prev) {
		linkProperties.put(PREV, prev);
		return this;
	}

	@JsonIgnore
	public LinkModel getPrev() {
		return linkProperties.get(PREV);
	}

	public void setPrev(LinkModel prev) {
		linkProperties.put(PREV, prev);
	}

	public CollectionLinksModel next(LinkModel next) {
		linkProperties.put(NEXT, next);
		return this;
	}

	@JsonIgnore
	public LinkModel getNext() {
		return linkProperties.get(NEXT);
	}

	public void setNext(LinkModel next) {
		linkProperties.put(NEXT, next);
	}

	@JsonAnySetter
	public CollectionLinksModel addLinkProperty(String linkName, LinkModel linkModel) {
		linkProperties.put(linkName, linkModel);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("class CollectionLinksModel {\n");
		linkProperties.forEach((linkProperty, linkModel) -> appendLinkModel(stringBuilder, linkProperty, linkModel));
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	private StringBuilder appendLinkModel(StringBuilder sb, String linkProperty, LinkModel linkModel) {
		return sb.append("		")
				.append(linkProperty)
				.append(": ")
				.append(ModelUtils.toIndentedString(linkModel))
				.append("\n");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CollectionLinksModel that = (CollectionLinksModel) o;
		return Objects.equals(linkProperties, that.linkProperties);
	}

	@Override
	public int hashCode() {
		return Objects.hash(linkProperties);
	}


}
