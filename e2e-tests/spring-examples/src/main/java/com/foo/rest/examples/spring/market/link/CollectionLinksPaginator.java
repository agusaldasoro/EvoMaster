package com.foo.rest.examples.spring.market.link;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CollectionLinksPaginator {

	public static final String OFFSET = "offset";
	public static final String LIMIT = "limit";

	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final int MAX_PAGE_SIZE = 100;

	public int getOffset(Map<String, List<String>> queryParameters) {
		Integer offset = getIntValue(queryParameters, OFFSET).orElse(0);
		if (offset < 0) {
			throw new IllegalArgumentException(String.format("Invalid offset. Value %d must be equal or greater than 0", offset));
		}
		return offset;
	}

	public int getLimit(Map<String, List<String>> queryParameters) {
		Integer limit = getIntValue(queryParameters, LIMIT).orElse(DEFAULT_PAGE_SIZE);
		if (limit < 0) {
			throw new IllegalArgumentException(String.format("Invalid limit. Value %d must be equal or greater than 0", limit));
		}
		return limit > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : limit;
	}

	private Optional<Integer> getIntValue(Map<String, List<String>> queryParameters, String key) {
		return Optional.ofNullable(queryParameters)
				.map(params -> params.get(key))
				.map(paramValues -> paramValues.get(0))
				.filter(value -> !value.isEmpty())
				.map(Integer::parseInt);
	}

}
