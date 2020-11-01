package com.foo.rest.examples.spring.market.repository;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
@Entity(name = "brands")
@SQLDelete(sql = "UPDATE brands SET is_deleted = true, last_updated_date = now() WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
@NamedQueries({
		@NamedQuery(
				name = "getAllBrands",
				query = "SELECT brand FROM brands as brand ORDER BY brand.name ASC"),
		@NamedQuery(
				name = "findBrandWithName",
				query = "SELECT brand FROM brands as brand " +
						"WHERE brand.name = :name")
})
public class BrandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	// TODO: Check how to handle enums
	@Column(name = "type")
	private String type;
	@Column(name = "owner")
	private String owner;


	@OneToMany(mappedBy = "productId.brand", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ProductEntity> products = new LinkedList<>();

	@CreationTimestamp
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@UpdateTimestamp
	@Column(name = "last_updated_date")
	private Timestamp lastUpdatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
}
