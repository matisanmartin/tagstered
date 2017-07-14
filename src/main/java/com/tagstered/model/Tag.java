package com.tagstered.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author matias
 *
 */
@Entity
@Table(name = "TAG", uniqueConstraints = { @UniqueConstraint(columnNames = { "TAG_NAME", "ID_USER" }) })
public class Tag {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/**
	 * 
	 */
	@Column(name = "TAG_NAME", nullable = false)
	private String tagName;

	/**
	 * 
	 */
	public Tag() {
		// Default constructor
	}

	/**
	 * @param tagName
	 */
	public Tag(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
