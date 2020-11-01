package com.foo.rest.examples.spring.market.model;

import com.foo.rest.examples.spring.market.controller.ProductControllerMapper;
import org.springframework.stereotype.Component;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */

@Component
public class ProductPatcher {
	private ProductControllerMapper productControllerMapper;

	public ProductPatcher(ProductControllerMapper productControllerMapper) {
		this.productControllerMapper = productControllerMapper;
	}

	public void applyPatch(Product targetProduct, ProductPatchModel productPatch) {
		if (productPatch.getName().isPresent()) {
			targetProduct.setName(productPatch.getName().get());
		}
	}
}
