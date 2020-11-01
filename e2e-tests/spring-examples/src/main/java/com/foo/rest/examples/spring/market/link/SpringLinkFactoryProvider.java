package com.foo.rest.examples.spring.market.link;

import com.google.common.collect.Lists;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;

public class SpringLinkFactoryProvider extends LinkFactoryProvider {

	public LinkFactory getLinkFactory(@Nonnull ServletWebRequest servletWebRequest) {
		return super.getPublicLinkFactory(
				getHeaders(servletWebRequest.getRequest()),
				servletWebRequest.getRequest().getScheme(),
				getQueryParameters(servletWebRequest.getRequest()));
	}

	/**
	 * Converts the parameterMap of Map<String, String[]> to Map<String, List<String>>
	 */
	private static Map<String, List<String>> getQueryParameters(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getParameterMap().entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, (Map.Entry<String, String[]> entry) -> Lists.newArrayList(entry.getValue())));
	}

	/**
	 * Creates a headers map of Map<String, List<String>> using the methods that are provided by HttpServletRequest
	 */
	private static Map<String, List<String>> getHeaders(HttpServletRequest httpServletRequest) {
		return Collections.list(httpServletRequest.getHeaderNames()).stream()
				.collect(Collectors.toMap(Function.identity(), name -> Collections.list(httpServletRequest.getHeaders(name))));
	}

}
