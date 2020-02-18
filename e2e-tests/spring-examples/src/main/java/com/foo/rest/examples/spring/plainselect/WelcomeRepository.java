package com.foo.rest.examples.spring.plainselect;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WelcomeRepository {
	private final EntityManager entityManager;

	public WelcomeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public WelcomeEntity create(WelcomeEntity welcomeEntity) {
		entityManager.persist(welcomeEntity);
		return welcomeEntity;
	}
}
