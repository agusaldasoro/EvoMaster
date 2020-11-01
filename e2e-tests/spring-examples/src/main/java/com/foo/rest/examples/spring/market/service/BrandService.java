package com.foo.rest.examples.spring.market.service;

import com.foo.rest.examples.spring.market.model.Brand;
import com.foo.rest.examples.spring.market.repository.BrandRepository;
import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import javax.ws.rs.NotFoundException;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Service
public class BrandService {

	private final BrandRepository repository;
	private final BrandServiceMapper mapper;

	@Inject
	public BrandService(BrandRepository brandRepository, BrandServiceMapper brandServiceMapper) {
		this.repository = brandRepository;
		this.mapper = brandServiceMapper;
	}

	@Transactional
	public Brand create(Brand brand) {
		return mapper.repositoryToDomain(repository.create(mapper.domainToRepository(brand)));
	}


	@Transactional(readOnly = true)
	public Optional<Brand> findById(Long brandId) {
		return repository.getById(brandId).map(mapper::repositoryToDomain);
	}


	/**
	 * @param brandIdentifier
	 * @return the {@link Brand} by id
	 */
	@Transactional(readOnly = true)
	public Brand get(String brandIdentifier) {

		return this.findById(Long.parseLong(brandIdentifier))
				.orElseThrow(() -> createNotFoundException(brandIdentifier));
	}


	@NotNull
	private NotFoundException createNotFoundException(String brandId) {
		return new NotFoundException("Brand with identifier '" + brandId + "' was not found.");
	}

	public Brand update(Brand brand) {
		return null;
	}
}
