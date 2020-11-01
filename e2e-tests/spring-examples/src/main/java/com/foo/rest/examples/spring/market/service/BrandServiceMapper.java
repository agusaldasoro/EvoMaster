package com.foo.rest.examples.spring.market.service;


import com.foo.rest.examples.spring.market.model.Brand;
import com.foo.rest.examples.spring.market.repository.BrandEntity;
import com.google.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Component
public class BrandServiceMapper {

	private final ProductServiceMapper productServiceMapper;

	@Inject
	public BrandServiceMapper(ProductServiceMapper productServiceMapper) {
		this.productServiceMapper = productServiceMapper;
	}

	public BrandEntity domainToRepository(Brand brand) {
		BrandEntity entity = new BrandEntity();

		entity.setId(Optional.ofNullable(brand.getId()).map(Long::parseLong).orElse(null));
		entity.setName(brand.getName());
		entity.setDescription(brand.getDescription());
		entity.setType(brand.getType());
		entity.setOwner(brand.getOwner());

		return entity;
	}

	public Brand repositoryToDomain(BrandEntity entity) {
		Brand brand = new Brand(entity.getId().toString(), entity.getName());
		Optional.ofNullable(entity.getDescription()).ifPresent(brand::setDescription);
		Optional.ofNullable(entity.getType()).ifPresent(brand::setType);
		Optional.ofNullable(entity.getOwner()).ifPresent(brand::setOwner);

		brand.setProducts(productServiceMapper.repositoryToDomainCollection(entity.getProducts()));
		return brand;
	}
}
