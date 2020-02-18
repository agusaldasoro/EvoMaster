package com.foo.rest.examples.spring.plainselect;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WelcomeService {

	private final WelcomeRepository repository;
	private WelcomeServiceMapper mapper;

	public WelcomeService(WelcomeRepository welcomeRepository, WelcomeServiceMapper welcomeServiceMapper) {
		this.repository = welcomeRepository;
		this.mapper = welcomeServiceMapper;
	}

	@Transactional
	public Welcome create(Welcome api) {
		return mapper.repositoryToDomain(repository.create(mapper.domainToRepository(api)));
	}
}
