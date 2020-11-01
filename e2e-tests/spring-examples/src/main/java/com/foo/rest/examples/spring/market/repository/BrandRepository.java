package com.foo.rest.examples.spring.market.repository;

import com.google.inject.Inject;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.persistence.EntityManager;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Repository
public class BrandRepository {
	private final EntityManager entityManager;

	@Inject
	public BrandRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public BrandEntity create(BrandEntity brandEntity) {
		entityManager.persist(brandEntity);
		return brandEntity;
	}

	public Optional<BrandEntity> getById(Long id) {
		return Optional.ofNullable(entityManager.find(BrandEntity.class, id));
	}

}