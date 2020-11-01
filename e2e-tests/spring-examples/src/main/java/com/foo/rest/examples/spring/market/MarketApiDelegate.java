package com.foo.rest.examples.spring.market;

import com.foo.rest.examples.spring.market.model.BrandModel;
import com.foo.rest.examples.spring.market.model.BrandPatchModel;
import com.foo.rest.examples.spring.market.model.ProductModel;
import com.foo.rest.examples.spring.market.model.ProductPatchModel;

/**
 * Brand API Delegate Interface. Auto-generated using Swagger Codegen.
 * <p>
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */

public interface MarketApiDelegate {

	public org.springframework.http.ResponseEntity<?> createBrand(
			BrandModel brand,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> createProductInBrand(
			String brandId,
			ProductModel product,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> deleteBrand(
			String brandId,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> deleteProduct(
			String brandId,
			String productName,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> getBrand(
			String brandId,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> getBrands(
			Integer offset,
			Integer limit,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> getProduct(
			String brandId,
			String productName,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> getProductsFromBrand(
			String brandId,
			Integer offset,
			Integer limit,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> updateBrand(
			String brandId,
			BrandPatchModel brand,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

	public org.springframework.http.ResponseEntity<?> updateProduct(
			String brandId,
			String productName,
			ProductPatchModel product,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	);

}
