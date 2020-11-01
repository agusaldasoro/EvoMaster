package com.foo.rest.examples.spring.market;

import com.foo.rest.examples.spring.market.error.ErrorModel;
import com.foo.rest.examples.spring.market.error.EtagIfmatchErrorModel;
import com.foo.rest.examples.spring.market.error.InputValidationErrorModel;
import com.foo.rest.examples.spring.market.model.BrandModel;
import com.foo.rest.examples.spring.market.model.BrandPatchModel;
import com.foo.rest.examples.spring.market.model.BrandsModel;
import com.foo.rest.examples.spring.market.model.ProductModel;
import com.foo.rest.examples.spring.market.model.ProductPatchModel;
import com.foo.rest.examples.spring.market.model.ProductsModel;

/**
 * Brand API REST Controller. Auto-generated using Swagger Codegen.
 * <p>
 * <p><b>DO NOT MODIFY THIS FILE. Changes will be overwritten.</b>
 */
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = "/v0")
@io.swagger.annotations.Api(description = "the Brand Controller")
public final class MarketRest {

	@org.springframework.beans.factory.annotation.Autowired
	private MarketApiDelegate apiDelegate;


	/**
	 * Path: /brands
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.POST,
			value = "/brands",
			consumes = {"application/json"},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Creates an `Brand` object. ", response = BrandModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 201, message = "`Brand` created", response = BrandModel.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = InputValidationErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> createBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` to create.", required = true) @org.springframework.web.bind.annotation.RequestBody(required = true) BrandModel brand,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.createBrand(
				brand,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}/products
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.POST,
			value = "/brands/{brandId}/products",
			consumes = {"application/json"},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Creates a `Product` object in a brand. ", response = ProductModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 201, message = "`Product` created", response = ProductModel.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = InputValidationErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> createProductInBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "The `Product` to create.", required = true) @org.springframework.web.bind.annotation.RequestBody(required = true) ProductModel product,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.createProductInBrand(
				brandId,
				product,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.DELETE,
			value = "/brands/{brandId}",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Deletes the `Brand` object. ", tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 204, message = "Successfully deleted `Brand`."),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> deleteBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.deleteBrand(
				brandId,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}/products/{productName}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.DELETE,
			value = "/brands/{brandId}/products/{productName}",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Deletes the `Product` object. ", tags = {"Products",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 204, message = "Successfully deleted `Product`."),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> deleteProduct(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "The `Product` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "productName", required = true) String productName,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.deleteProduct(
				brandId,
				productName,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.GET,
			value = "/brands/{brandId}",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Gets the `Brand` object. ", response = BrandModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "The `Brand` object with the given identifier.", response = BrandModel.class),

			@io.swagger.annotations.ApiResponse(code = 304, message = "Not modified"),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> getBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.getBrand(
				brandId,
				servletWebRequest);
	}


	/**
	 * Path: /brands
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.GET,
			value = "/brands",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "A Brand is the representation of a store. ", response = BrandsModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Returns the `Brands`", response = BrandsModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> getBrands(
			@io.swagger.annotations.ApiParam(value = "Offset. First record of the list", required = false) @org.springframework.web.bind.annotation.RequestParam(value = "offset", required = false) Integer offset,
			@io.swagger.annotations.ApiParam(value = "Limit, aka page-length.", required = false) @org.springframework.web.bind.annotation.RequestParam(value = "limit", required = false) Integer limit,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.getBrands(
				offset,
				limit,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}/products/{productName}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.GET,
			value = "/brands/{brandId}/products/{productName}",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Gets the `Product` object. ", response = ProductModel.class, tags = {"Product",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "The `Product` object with the given identifier.", response = ProductModel.class),

			@io.swagger.annotations.ApiResponse(code = 304, message = "Not modified"),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> getProduct(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "The `Product` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "productName", required = true) String productName,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.getProduct(
				brandId,
				productName,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}/products
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.GET,
			value = "/brands/{brandId}/products",
			consumes = {},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Gets the `Products` objects. ", response = ProductsModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "All the `Products` from the brand with the given identifier.", response = ProductsModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> getProductsFromBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "Offset. First record of the list", required = false) @org.springframework.web.bind.annotation.RequestParam(value = "offset", required = false) Integer offset,
			@io.swagger.annotations.ApiParam(value = "Limit, aka page-length.", required = false) @org.springframework.web.bind.annotation.RequestParam(value = "limit", required = false) Integer limit,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.getProductsFromBrand(
				brandId,
				offset,
				limit,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.PATCH,
			value = "/brands/{brandId}",
			consumes = {"application/json"},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Updates the `Brand` object. ", response = BrandModel.class, tags = {"Brands",})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully updated `Brand`.", response = BrandModel.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = InputValidationErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> updateBrand(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "The updated `Brand` object.", required = true) @org.springframework.web.bind.annotation.RequestBody(required = true) BrandPatchModel brand,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.updateBrand(
				brandId,
				brand,
				servletWebRequest);
	}


	/**
	 * Path: /brands/{brandId}/products/{productName}
	 */
	@org.springframework.web.bind.annotation.RequestMapping(
			method = org.springframework.web.bind.annotation.RequestMethod.PATCH,
			value = "/brands/{brandId}/products/{productName}",
			consumes = {"application/json"},
			produces = {"application/json"}
	)
	@io.swagger.annotations.ApiOperation(value = "", notes = "Updates the `Product` object. ", response = ProductModel.class, tags = {"Products"})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully updated `Product`.", response = ProductModel.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = InputValidationErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "First, you need to tell me who you are.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 403, message = "Are you trying to do something illegal here?", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Object not found.", response = ErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 412, message = "Precondition failed.", response = EtagIfmatchErrorModel.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Oops... Something wrong on our side.", response = ErrorModel.class)
	})
	public org.springframework.http.ResponseEntity<?> updateProduct(
			@io.swagger.annotations.ApiParam(value = "The `Brand` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "brandId", required = true) String brandId,
			@io.swagger.annotations.ApiParam(value = "The `Product` identifier or name", required = true) @org.springframework.web.bind.annotation.PathVariable(value = "productName", required = true) String productName,
			@io.swagger.annotations.ApiParam(value = "The updated `Product` object.", required = true) @org.springframework.web.bind.annotation.RequestBody(required = true) ProductPatchModel product,
			org.springframework.web.context.request.ServletWebRequest servletWebRequest
	) {
		return apiDelegate.updateProduct(
				brandId,
				productName,
				product,
				servletWebRequest);
	}

	/**
	 * Binding for enums
	 */
	@org.springframework.web.bind.annotation.InitBinder
	public void initBinder(final org.springframework.web.bind.WebDataBinder webdataBinder) {
	}

}

