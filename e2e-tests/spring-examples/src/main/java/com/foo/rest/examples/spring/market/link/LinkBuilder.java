package com.foo.rest.examples.spring.market.link;


import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

/**
 * Builder methods to create/handle links in API responses.
 */
public class LinkBuilder {

	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	private static final int HTTP_DEFAULT_PORT = 80;
	private static final int HTTPS_DEFAULT_PORT = 443;
	private static final int EMPTY_PORT = -1;
	private static final String DEFAULT_SCHEME = HTTP;
	private static final String DEFAULT_HOST = "localhost";
	private static final Map<String, Integer> DEFAULT_PORT_FOR_SCHEMA = ImmutableMap.of(HTTP, HTTP_DEFAULT_PORT, HTTPS, HTTPS_DEFAULT_PORT);
	private String scheme;
	private String host;
	private String basePath;
	private String path;
	private ListMultimap<String, String> queryParameters = ArrayListMultimap.create();
	private int port = EMPTY_PORT;

	public LinkBuilder() {
		this(null, null);
	}

	public LinkBuilder(String scheme, String host) {
		this.scheme = scheme;
		this.host = host;
	}

	public LinkBuilder port(int port) {
		this.port = port;
		return this;
	}

	public LinkBuilder basePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public LinkBuilder path(String path) {
		this.path = path;
		return this;
	}

	public LinkBuilder addQueryParams(Multimap<String, String> queryParams) {
		queryParameters.putAll(queryParams);
		return this;
	}

	public LinkBuilder addQueryParams(Map<String, List<String>> queryParams) {
		if (queryParams != null) {
			for (Entry<String, List<String>> entry : queryParams.entrySet()) {
				queryParameters.putAll(entry.getKey(), entry.getValue());
			}
		}
		return this;
	}

	public LinkBuilder addQueryParam(String name, String... values) {
		queryParameters.putAll(name, new ArrayList<>(asList(values)));
		return this;
	}

	public LinkBuilder replaceQueryParam(String name, String... values) {
		return replaceQueryParam(name, new ArrayList<>(asList(values)));
	}

	public LinkBuilder replaceQueryParam(String name, List<String> values) {
		queryParameters.replaceValues(name, values);
		return this;
	}

	public LinkBuilder removeQueryParam(String name) {
		queryParameters.removeAll(name);
		return this;
	}

	@Nonnull
	public String build() {
		return addQueryMultiParams(getFullPath(), getQueryParameters());
	}

	private String addQueryMultiParams(String fullPath, Map<String, String[]> queryParameters) {
		return fullPath + "?" +
				queryParameters.entrySet().stream()
						.map(queryParamKey ->
								Arrays.stream(queryParamKey.getValue())
										.map(queryParamValue -> queryParamKey.getKey() + "=" + queryParamValue)
										.collect(Collectors.joining("&")))
						.collect(Collectors.joining("&"));
	}


	@Nonnull
	private String getFullPath() {
		return new StringBuilder()
				.append(getSchema())
				.append("://")
				.append(Optional.ofNullable(host).orElse(DEFAULT_HOST))
				.append(getPortComponent())
				.append(getPathComponent(basePath))
				.append(Optional.ofNullable(path).orElse(""))
				.toString();
	}

	private String getSchema() {
		return Optional.ofNullable(scheme).orElse(DEFAULT_SCHEME);
	}

	private String getPortComponent() {
		return Optional.of(port)
				.filter(p -> p != EMPTY_PORT)
				.filter(p -> !this.isDefaultPortForSchema(port))
				.map(p -> ":" + p)
				.orElse("");
	}

	public boolean isDefaultPortForSchema(int port) {
		return Optional.ofNullable(DEFAULT_PORT_FOR_SCHEMA.get(getSchema()))
				.filter(portForSchema -> port == portForSchema)
				.isPresent();
	}

	@Nonnull
	private String getPathComponent(String pathComponent) {
		return Optional.ofNullable(pathComponent)
				.filter(a -> !a.equals(""))
				.orElse("");
	}

	@Nonnull
	private Map<String, String[]> getQueryParameters() {
		return queryParameters.asMap().entrySet().stream()
				.collect(toMap(Entry::getKey, entry -> entry.getValue().toArray(new String[0])));
	}

}
