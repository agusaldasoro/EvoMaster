package com.foo.rest.examples.spring.market.controller;

import com.foo.rest.examples.spring.market.MarketApiDelegate;
import com.foo.rest.examples.spring.market.model.BrandModel;
import com.foo.rest.examples.spring.market.model.BrandPatchModel;
import com.foo.rest.examples.spring.market.model.ProductModel;
import com.foo.rest.examples.spring.market.model.ProductPatchModel;
import com.foo.rest.examples.spring.market.service.BrandService;
import com.foo.rest.examples.spring.market.service.ProductService;
import com.google.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Component
@RestController
public class ApplicationController implements MarketApiDelegate {

	private BrandService brandService;
	private BrandControllerMapper brandControllerMapper;
	private final ProductService productService;
	private ProductControllerMapper productControllerMapper;

	@Inject
	public ApplicationController(BrandService brandService, BrandControllerMapper brandControllerMapper,
								 ProductService productService, ProductControllerMapper productControllerMapper) {
		this.brandService = brandService;
		this.brandControllerMapper = brandControllerMapper;
		this.productService = productService;
		this.productControllerMapper = productControllerMapper;
	}

	/**
	 * POST /v0/brands
	 */
	@Override
	public ResponseEntity<?> createBrand(BrandModel brand, ServletWebRequest servletWebRequest) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(brandControllerMapper.domainToDto(
						brandService.create(brandControllerMapper.dtoToDomain(brand)),
						servletWebRequest));
	}

	@Override
	public ResponseEntity<?> createProductInBrand(String brandId, ProductModel product, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> deleteBrand(String brandId, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> deleteProduct(String brandId, String productName, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> getBrand(String brandId, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> getBrands(Integer offset, Integer limit, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> getProduct(String brandId, String productName, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> getProductsFromBrand(String brandId, Integer offset, Integer limit, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> updateBrand(String brandId, BrandPatchModel brand, ServletWebRequest servletWebRequest) {
		return null;
	}

	@Override
	public ResponseEntity<?> updateProduct(String brandId, String productName, ProductPatchModel product, ServletWebRequest servletWebRequest) {
		return null;
	}
}