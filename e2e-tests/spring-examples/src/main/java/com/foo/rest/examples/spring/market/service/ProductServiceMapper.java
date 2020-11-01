package com.foo.rest.examples.spring.market.service;


import com.foo.rest.examples.spring.market.model.Product;
import com.foo.rest.examples.spring.market.repository.BrandEntity;
import com.foo.rest.examples.spring.market.repository.ProductEntity;
import com.google.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Component
public class ProductServiceMapper {

	@Inject
	public ProductEntity domainToRepository(Product product, BrandEntity brandEntity) {
		ProductEntity entity = new ProductEntity();

		entity.setBrand(brandEntity);
		entity.setName(product.getName());

		return entity;
	}

	public Product repositoryToDomain(ProductEntity productEntity) {
		return new Product(productEntity.getName());
	}

	public List<Product> repositoryToDomainCollection(List<ProductEntity> products) {
		return products.stream()
				.map(this::repositoryToDomain)
				.collect(Collectors.toList());
	}
}
