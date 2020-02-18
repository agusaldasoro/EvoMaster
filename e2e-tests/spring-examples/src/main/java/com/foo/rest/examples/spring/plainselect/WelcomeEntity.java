package com.foo.rest.examples.spring.plainselect;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "welcomes")
@SQLDelete(sql = "UPDATE welcomes SET is_deleted = true, last_updated_date = now() WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
@NamedQueries({
		@NamedQuery(
				name = "getAllWelcomes",
				query = "SELECT welcome FROM welcomes as welcome ORDER BY welcome.name ASC"),
		@NamedQuery(
				name = "findWelcomeWithName",
				query = "SELECT welcome FROM welcomes as welcome " +
						"WHERE welcome.name = :name")
})

public class WelcomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "content")
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
