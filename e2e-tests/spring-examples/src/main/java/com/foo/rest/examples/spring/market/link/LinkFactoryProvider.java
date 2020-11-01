package com.foo.rest.examples.spring.market.link;


import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

public class LinkFactoryProvider {

	public static final String HOST = HttpHeaders.HOST.toLowerCase();
	public static final String API = "x-api";
	public static final String VERSION = "x-version";
	public static final String PATH = "x-path";

	public LinkFactory getPublicLinkFactory(@Nonnull Map<String, List<String>> headers, @Nonnull String scheme, @Nonnull Map<String, List<String>> queryParameters) {
		Map<String, String> sanitizedHeaders = sanitizeHeaders(headers);
		return new LinkFactory(scheme, sanitizedHeaders.get(HOST), -1, getPublicBasePath(sanitizedHeaders), sanitizedHeaders.get(PATH), queryParameters);
	}

	public LinkFactory getPrivateLinkFactory(String serverUrl, String basePath, String path, @Nonnull Map<String, List<String>> queryParameters) {
		URL parseURL = parseURL(serverUrl);
		return new LinkFactory(parseURL.getProtocol(), parseURL.getHost(), parseURL.getPort(), basePath, getInternalPath(basePath, path), queryParameters);
	}

	/**
	 * @param basePath
	 * @param fullPath
	 * @return the given path after removing the base path from the beginning.
	 */
	private String getInternalPath(String basePath, String fullPath) {
		return fullPath.substring(basePath.length());
	}

	private Map<String, String> sanitizeHeaders(Map<String, List<String>> headers) {
		Map<String, String> sanitizedHeaders = new HashMap<>();
		headers.entrySet().stream()
				.filter(entry -> !entry.getValue().isEmpty())
				.forEach(entry -> sanitizedHeaders.put(entry.getKey().toLowerCase(), entry.getValue().get(0)));
		return sanitizedHeaders;
	}

	private String getPublicBasePath(Map<String, String> sanitazedHeaders) {
		return "/" + Lists.newArrayList(sanitazedHeaders.get(API), sanitazedHeaders.get(VERSION)).stream()
				.filter(a -> !a.equals("")).collect(Collectors.joining("/"));
	}

	private URL parseURL(String serverUrl) {
		try {
			return new URL(serverUrl);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("Invalid Server URL: " + serverUrl, e);
		}
	}

}
