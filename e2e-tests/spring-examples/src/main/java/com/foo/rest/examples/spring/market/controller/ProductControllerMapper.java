package com.foo.rest.examples.spring.market.controller;


import com.foo.rest.examples.spring.market.link.LinkFactory;
import com.foo.rest.examples.spring.market.link.ProductLinksModel;
import com.foo.rest.examples.spring.market.link.SpringLinkFactoryProvider;
import com.foo.rest.examples.spring.market.model.Product;
import com.foo.rest.examples.spring.market.model.ProductModel;
import com.foo.rest.examples.spring.market.model.ProductsModel;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.List;


@Component
public class ProductControllerMapper {

	private final SpringLinkFactoryProvider linkFactoryProvider;

	@Inject
	public ProductControllerMapper(SpringLinkFactoryProvider linkFactoryProvider) {
		this.linkFactoryProvider = linkFactoryProvider;
	}

	public ProductModel domainToDto(Product apiVersionDomain, String apiId, ServletWebRequest servletWebRequest) {
		return domainToDtoUsingLinkFactory(apiVersionDomain, apiId, linkFactoryProvider.getLinkFactory(servletWebRequest));
	}

	public Product dtoToDomain(ProductModel apiVersionDto) {
		return new Product(apiVersionDto.getName());
	}

	public ProductsModel domainToDtoCollection(List<Product> products, String brandId, ServletWebRequest servletWebRequest) {
		ProductsModel collectionModel = new ProductsModel();
		Integer totalSize = products.size();

		List<ProductModel> destinationCollection = Lists.newArrayList();

//		for (Product product : products) {
//			String apiVersionPath = BrandApiEndpoints.getByIdCanonicalPath(brandId, product.getName());
//			LinkFactory linkFactory = linkFactoryProvider.getPublicLinkFactory(servletWebRequest).withPath(apiVersionPath);
//
//			destinationCollection.add(domainToDtoUsingLinkFactory(product, brandId, linkFactory));
//		}
//		collectionModel.setItems(destinationCollection);
//
//		LinkFactory linkFactory = linkFactoryProvider.getPublicLinkFactory(servletWebRequest);
//		CollectionLinksModel targetLinks = new CollectionLinksModel();
//
//		targetLinks.setSelf(LinkModelFactory.createLinkModelWithHref(linkFactory.buildSelf()));
//
//		collectionModel.setLinks(targetLinks);
//		collectionModel.setTotal(totalSize);

		return collectionModel;
	}

	// TODO: Use this for brand enum
//	public ProductModel.StatusEnum domainToDtoStatus(ProductStatus apiVersionDomainStatus) {
//		switch (apiVersionDomainStatus) {
//			case PROPOSAL:
//				return ProductModel.StatusEnum.PROPOSAL;
//			case UNDER_DEVELOPMENT:
//				return ProductModel.StatusEnum.UNDER_DEVELOPMENT;
//			case RELEASED:
//				return ProductModel.StatusEnum.RELEASED;
//		}
//		throw new IllegalStateException("Unknown mapping " + apiVersionDomainStatus);
//	}
//
//	public ProductStatus dtoToDomainStatus(ProductModel.StatusEnum apiVersionDtoStatus) {
//		switch (apiVersionDtoStatus) {
//			case PROPOSAL:
//				return ProductStatus.PROPOSAL;
//			case UNDER_DEVELOPMENT:
//				return ProductStatus.UNDER_DEVELOPMENT;
//			case RELEASED:
//				return ProductStatus.RELEASED;
//		}
//		throw new IllegalStateException("Unknown mapping " + apiVersionDtoStatus);
//	}
//
//	public ProductStatus dtoToDomainStatus(ProductPatchModel.StatusEnum apiVersionDtoStatus) {
//		switch (apiVersionDtoStatus) {
//			case PROPOSAL:
//				return ProductStatus.PROPOSAL;
//			case UNDER_DEVELOPMENT:
//				return ProductStatus.UNDER_DEVELOPMENT;
//			case RELEASED:
//				return ProductStatus.RELEASED;
//		}
//		throw new IllegalStateException("Unknown mapping " + apiVersionDtoStatus);
//	}

	private ProductModel domainToDtoUsingLinkFactory(Product apiVersionDomain, String apiId, LinkFactory linkFactory) {
		ProductModel apiVersionModel = new ProductModel();
//
//		apiVersionModel.setVersion(apiVersionDomain.getVersion());
//		apiVersionModel.setDescription(apiVersionDomain.getDescription());
//		apiVersionModel.setStatus(Optional.ofNullable(apiVersionDomain.getStatus())
//				.map(this::domainToDtoStatus)
//				.orElse(null));
//
//		apiVersionModel.setPublicEndpoint(apiVersionDomain.getPublicEndpoint());
//		apiVersionModel.setLinks(setupProductLinksModel(apiVersionDomain, apiId, linkFactory));
//		apiVersionDomain.getBrandCodegenVersion().ifPresent(apiVersionModel::setBrandCodegenVersion);
//		apiVersionDomain.getComplianceBrandSpecVersion().ifPresent(apiVersionModel::setComplianceBrandSpecVersion);

		return apiVersionModel;
	}

	private ProductLinksModel setupProductLinksModel(Product apiVersionDomain, String apiId, LinkFactory linkFactory) {
		ProductLinksModel apiversionLinksModel = new ProductLinksModel();
//		apiversionLinksModel.setSelf(LinkModelFactory.createLinkModelWithHref(linkFactory.buildSelf()));
//
//		apiversionLinksModel.setResources(getLinkModelWithHref(linkFactory,
//				BrandResourceBrandEndpoints.getAllCanonicalPath(apiId, apiVersionDomain.getVersion())));
//		apiversionLinksModel.setRelatedBrands(getLinkModelWithHref(linkFactory,
//				ProductRelationsBrandEndpoints.getAllCanonicalPath(apiId, apiVersionDomain.getVersion())));
//		apiversionLinksModel.setBackendEvaluations(getLinkModelWithHref(linkFactory,
//				ProductBackendEvaluationBrandEndpoints.getAllCanonicalPath(apiId, apiVersionDomain.getVersion())));

		return apiversionLinksModel;
	}


}
