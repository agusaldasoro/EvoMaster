package com.foo.rest.examples.spring.market.endpoints;

import com.foo.rest.examples.spring.market.model.PathSegmentEncoder;

/**
 * Auto-generated using Swagger Codegen.
 * <p>
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */

public final class BrandApiEndpoints {

	public static String createBrandUrl() {

		return "/v0/brands";
	}

	public static String createBrandCanonicalPath() {

		return "/brands";
	}

	public static String createProductInBrandUrl(String brandId) {
		String path = "/v0/brands/{brandId}/products";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String createProductInBrandCanonicalPath(String brandId) {
		String path = "/brands/{brandId}/products";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String deleteBrandUrl(String brandId) {
		String path = "/v0/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String deleteBrandCanonicalPath(String brandId) {
		String path = "/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String deleteProductUrl(String brandId, String productName) {
		String path = "/v0/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

	public static String deleteProductCanonicalPath(String brandId, String productName) {
		String path = "/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

	public static String getBrandUrl(String brandId) {
		String path = "/v0/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String getBrandCanonicalPath(String brandId) {
		String path = "/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String getBrandsUrl() {

		return "/v0/brands";
	}

	public static String getBrandsCanonicalPath() {

		return "/brands";
	}

	public static String getProductUrl(String brandId, String productName) {
		String path = "/v0/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

	public static String getProductCanonicalPath(String brandId, String productName) {
		String path = "/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

	public static String getProductsFromBrandUrl(String brandId) {
		String path = "/v0/brands/{brandId}/products";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String getProductsFromBrandCanonicalPath(String brandId) {
		String path = "/brands/{brandId}/products";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String updateBrandUrl(String brandId) {
		String path = "/v0/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String updateBrandCanonicalPath(String brandId) {
		String path = "/brands/{brandId}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		return path;
	}

	public static String updateProductUrl(String brandId, String productName) {
		String path = "/v0/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

	public static String updateProductCanonicalPath(String brandId, String productName) {
		String path = "/brands/{brandId}/products/{productName}";

		path = path.replace("{brandId}", PathSegmentEncoder.encode(brandId.toString()));

		path = path.replace("{productName}", PathSegmentEncoder.encode(productName.toString()));

		return path;
	}

}

