package com.foo.rest.examples.spring.market.controller;


import static com.foo.rest.examples.spring.market.link.LinkModelUtils.getLinkModelWithHref;

import com.foo.rest.examples.spring.market.endpoints.BrandApiEndpoints;
import com.foo.rest.examples.spring.market.link.BrandLinksModel;
import com.foo.rest.examples.spring.market.link.CollectionLinksModel;
import com.foo.rest.examples.spring.market.link.LinkFactory;
import com.foo.rest.examples.spring.market.link.LinkModelFactory;
import com.foo.rest.examples.spring.market.link.SpringLinkFactoryProvider;
import com.foo.rest.examples.spring.market.model.Brand;
import com.foo.rest.examples.spring.market.model.BrandModel;
import com.foo.rest.examples.spring.market.model.BrandsModel;
import com.foo.rest.examples.spring.market.model.PagedCollection;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.List;
import java.util.Optional;

@Component
public class BrandControllerMapper {

	private final SpringLinkFactoryProvider linkFactoryProvider;

	@Inject
	public BrandControllerMapper(SpringLinkFactoryProvider linkFactoryProvider) {
		this.linkFactoryProvider = linkFactoryProvider;
	}

	public BrandModel domainToDto(Brand apiDomain, ServletWebRequest servletWebRequest) {
		return domainToDtoUsingLinkFactory(apiDomain, linkFactoryProvider.getLinkFactory(servletWebRequest));
	}

	public Brand dtoToDomain(BrandModel brandDto) {
		Brand brand = new Brand(brandDto.getId(), brandDto.getName());
		Optional.ofNullable(brandDto.getDescription()).ifPresent(brand::setDescription);
		Optional.ofNullable(brandDto.getType()).ifPresent(type -> brand.setType(type.toString()));
		Optional.ofNullable(brandDto.getOwner()).ifPresent(brand::setOwner);
		return brand;
	}

	public BrandsModel domainToDtoCollection(PagedCollection<Brand> brandDomainPagedCollection, ServletWebRequest servletWebRequest) {
		BrandsModel collectionModel = new BrandsModel();
		Integer totalSize = brandDomainPagedCollection.getTotalSize();

		List<BrandModel> destinationCollection = Lists.newArrayList();

		LinkFactory itemLinkFactory;
		for (Brand brandDomain : brandDomainPagedCollection) {
			String brandPath = BrandApiEndpoints.getBrandCanonicalPath(brandDomain.getId());
			itemLinkFactory = linkFactoryProvider.getLinkFactory(servletWebRequest).withPath(brandPath);
			destinationCollection.add(domainToDtoUsingLinkFactory(brandDomain, itemLinkFactory));
		}
		collectionModel.setItems(destinationCollection);

		LinkFactory linkFactory = linkFactoryProvider.getLinkFactory(servletWebRequest);
		CollectionLinksModel targetLinks = new CollectionLinksModel();

		targetLinks.setSelf(LinkModelFactory.createLinkModelWithHref(linkFactory.buildSelf()));

		Optional.ofNullable(linkFactory.buildPrev(totalSize))
				.map(LinkModelFactory::createLinkModelWithHref)
				.ifPresent(targetLinks::setPrev);

		Optional.ofNullable(linkFactory.buildNext(totalSize))
				.map(LinkModelFactory::createLinkModelWithHref)
				.ifPresent(targetLinks::setNext);

		collectionModel.setLinks(targetLinks);
		collectionModel.setTotal(totalSize);

		return collectionModel;
	}

	private BrandModel domainToDtoUsingLinkFactory(Brand brandDomain, LinkFactory linkFactory) {
		BrandModel brandModel = new BrandModel();

		brandModel.setId(brandDomain.getId());
		brandModel.setName(brandDomain.getName());
		brandModel.setDescription(brandDomain.getDescription());
		Optional.ofNullable(brandDomain.getType())
				.ifPresent(type -> brandModel.setType(BrandModel.TypeEnum.fromString(type)));
		brandModel.setOwner(brandDomain.getOwner());

		BrandLinksModel apiLinksModel = new BrandLinksModel();

		apiLinksModel.setSelf(LinkModelFactory.createLinkModelWithHref(linkFactory.buildSelf()));
		apiLinksModel.setProducts(
				getLinkModelWithHref(linkFactory, BrandApiEndpoints.getProductsFromBrandCanonicalPath(brandDomain.getId())));
		brandModel.setLinks(apiLinksModel);

		return brandModel;
	}


}
