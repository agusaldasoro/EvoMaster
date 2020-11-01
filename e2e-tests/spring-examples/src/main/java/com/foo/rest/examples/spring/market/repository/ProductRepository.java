package com.foo.rest.examples.spring.market.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Repository
public class ProductRepository {
	private final EntityManager entityManager;

	public ProductRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ProductEntity create(ProductEntity productEntity) {
		entityManager.persist(productEntity);
		return productEntity;
	}
}