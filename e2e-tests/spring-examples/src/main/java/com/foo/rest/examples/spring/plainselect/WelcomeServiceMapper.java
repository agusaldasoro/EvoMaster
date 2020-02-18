package com.foo.rest.examples.spring.plainselect;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WelcomeServiceMapper {

	public WelcomeEntity domainToRepository(Welcome o) {
		WelcomeEntity entity = new WelcomeEntity();

		entity.setId(Optional.ofNullable(o.getId()).map(Long::parseLong).orElse(null));
		entity.setName(o.getName());
		entity.setContent(o.getContent());

		return entity;
	}

	public Welcome repositoryToDomain(WelcomeEntity o) {
		return new Welcome(o.getId().toString(), o.getContent(), o.getName());
	}
}
