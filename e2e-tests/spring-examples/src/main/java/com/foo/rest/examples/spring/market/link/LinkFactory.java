package com.foo.rest.examples.spring.market.link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LinkFactory {

	private static final String OFFSET = "offset";
	private static final String LIMIT = "limit";
	private final String host;
	private final int port;
	private final String basePath;
	private final String path;
	private final String scheme;
	private final Map<String, List<String>> queryParameters;
	private final CollectionLinksPaginator collectionLinksPaginator;

	public LinkFactory(String scheme, String host, int port, String basePath, String path,
					   Map<String, List<String>> queryParameters, CollectionLinksPaginator collectionLinksPaginator) {
		this.scheme = scheme;
		this.host = host;
		this.port = port;
		this.basePath = basePath;
		this.path = path;
		this.queryParameters = queryParameters;
		this.collectionLinksPaginator = collectionLinksPaginator;
	}

	public LinkFactory(String scheme, String host, int port, String basePath, String path,
					   Map<String, List<String>> queryParameters) {
		this(scheme, host, port, basePath, path, queryParameters, new CollectionLinksPaginator());
	}

	/**
	 * @param newPath
	 * @return a new {@link LinkFactory} with the same attributes but a different path and without query parameters.
	 */
	public LinkFactory withPath(String newPath) {
		return new LinkFactory(scheme, host, port, basePath, newPath, new HashMap<>(), collectionLinksPaginator);
	}

	/**
	 * @return a new {@link LinkFactory} but without query parameters
	 */
	public LinkFactory withoutQueryParams() {
		return new LinkFactory(scheme, host, port, basePath, path, new HashMap<>(), collectionLinksPaginator);
	}

	/**
	 * @return a new {@link LinkBuilder}to create custom links that uses the scheme, host, port,
	 * basePath and path.
	 */
	@Nonnull
	public LinkBuilder makeLinkBuilder() {
		return new LinkBuilder(scheme, host)
				.port(port)
				.basePath(basePath)
				.path(path);
	}

	/**
	 * Build a self link to resource in uriInfo.
	 */
	@Nonnull
	public String buildSelf() {
		return makeLinkBuilder()
				.addQueryParams(queryParameters)
				.build();
	}

	/**
	 * Build the previous link for a collection. It will return null if the collection doesn't have
	 * previous.
	 */
	@Nullable
	public String buildPrev(final int totalSize) {
		int offset = collectionLinksPaginator.getOffset(queryParameters);
		int limit = collectionLinksPaginator.getLimit(queryParameters);
		if (offset == 0) {
			return null;
		}

		return makeLinkBuilder()
				.addQueryParams(queryParameters)
				.replaceQueryParam(OFFSET, String.valueOf(Math.max(0, offset - limit)))
				.replaceQueryParam(LIMIT, String.valueOf(limit))
				.build();
	}

	/**
	 * Build the next link for a collection. It will return null if the collection doesn't have
	 * next.
	 */
	@Nullable
	public String buildNext(final int totalSize) {
		int offset = collectionLinksPaginator.getOffset(queryParameters);
		int limit = collectionLinksPaginator.getLimit(queryParameters);
		if (offset + limit >= totalSize) {
			return null;
		}

		return makeLinkBuilder()
				.addQueryParams(queryParameters)
				.replaceQueryParam(OFFSET, String.valueOf(offset + limit))
				.replaceQueryParam(LIMIT, String.valueOf(limit))
				.build();
	}

}
