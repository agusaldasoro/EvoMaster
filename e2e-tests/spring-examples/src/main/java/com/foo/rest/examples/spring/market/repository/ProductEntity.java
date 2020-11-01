package com.foo.rest.examples.spring.market.repository;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Entity(name = "products")
@SQLDelete(sql = "UPDATE products SET is_deleted = true, last_updated_date = now() WHERE brand_id = ? and name = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
public class ProductEntity {

	@EmbeddedId
	private ProductId productId = new ProductId();
	@Column(name = "name")
	private String name;
	@CreationTimestamp
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@UpdateTimestamp
	@Column(name = "last_updated_date")
	private Timestamp lastUpdatedDate;


	@Transient
	public BrandEntity getBrand() {
		return productId.getBrand();
	}

	public void setBrand(BrandEntity brand) {
		this.productId.setBrand(brand);
	}

	@Transient
	public String getName() {
		return productId.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
