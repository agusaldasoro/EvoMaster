package com.foo.rest.examples.spring.market.service;

import com.foo.rest.examples.spring.market.model.Brand;
import com.foo.rest.examples.spring.market.model.Product;
import com.foo.rest.examples.spring.market.model.ProductPatchModel;
import com.foo.rest.examples.spring.market.model.ProductPatcher;
import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Service
public class ProductService {


	private ProductPatcher productPatcher;
	private BrandService brandService;

	@Inject
	public ProductService(ProductPatcher productPatcher, BrandService brandService) {
		this.productPatcher = productPatcher;
		this.brandService = brandService;
	}

	@Transactional
	public Product sparseUpdate(String brandId, String name, ProductPatchModel productPatchModel) {
		Brand brand = brandService.get(brandId);
		Product targetProduct = this.getByName(brand, name);
//
//		Optional.ofNullable(productPatchModel.getPublicEndpoint())
//				.ifPresent(publicEndpointOptional ->
//						publicEndpointOptional.ifPresent(this::testValidURL)
//				);
//
//		productPatcher.applyPatch(targetProduct, productPatchModel);
//
		Brand brandUpdated = brandService.update(brand);
		return this.getByName(brandUpdated, name);
	}

	/**
	 * This methods receives a brand and a prodct name, returning the corresponding Product
	 * if present. If not, it throws an NotFoundException.
	 *
	 * @param brand the brand of the product
	 * @param name  the name of the product to search
	 * @return the Product matching
	 */
	@Transactional(readOnly = true)
	public Product getByName(Brand brand, String name) {

		return brand.getProducts().stream()
				.filter(product -> name.equals(product.getName()))
				.findFirst()
				.orElseThrow(() -> createNotFoundException(brand, name));
	}

	@NotNull
	private NotFoundException createNotFoundException(Brand brand, String name) {
		return new NotFoundException("Product with name '" + name + "' in Brand with id '" +
				brand.getId() + "' was not found.");
	}

	public Object create(Product brand) {
		return null;
	}
}