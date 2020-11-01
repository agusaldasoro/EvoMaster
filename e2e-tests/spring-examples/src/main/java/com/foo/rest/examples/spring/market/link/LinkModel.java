package com.foo.rest.examples.spring.market.link;


import com.foo.rest.examples.spring.market.exception.EnumerationNotFoundException;
import com.foo.rest.examples.spring.market.model.ModelUtils;

import java.util.Locale;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonTypeName("link")
public class LinkModel {

	public enum Relation {
		SELF,
		CANONICAL,
		COLLECTION,
		CHILDREN,
		PARENT,
		DEPENDENCY,
		DEPENDENCIES,
		DEPENDENT,
		PREV,
		NEXT;

		@Override
		@com.fasterxml.jackson.annotation.JsonValue
		public String toString() {
			return name().toLowerCase(Locale.ENGLISH);
		}

		public static Relation fromString(final String relation) {
			try {
				return relation == null ? null : valueOf(relation.toUpperCase(Locale.ENGLISH));
			} catch (IllegalArgumentException e) {
				throw new EnumerationNotFoundException(relation, e);
			}
		}
	}

	protected String href = null;
	protected Relation rel = null;

	public LinkModel href(String href) {
		this.href = href;
		return this;
	}

	public LinkModel rel(Relation rel) {
		this.rel = rel;
		return this;
	}

	@com.fasterxml.jackson.annotation.JsonProperty("href")
	public String getHref() {
		return href;
	}

	@com.fasterxml.jackson.annotation.JsonProperty("rel")
	public Relation getRel() {
		return rel;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setRel(Relation rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LinkModel {\n");
		sb.append("		href: ").append(ModelUtils.toIndentedString(href)).append("\n");
		sb.append("		rel: ").append(ModelUtils.toIndentedString(rel)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LinkModel other = (LinkModel) o;
		return java.util.Objects.equals(href, other.href) && java.util.Objects.equals(rel, other.rel);
	}

	@Override
	public int hashCode() {
		return ModelUtils.combineIntHashes(java.util.Objects.hashCode(href), java.util.Objects.hashCode(rel));
	}
}
