package com.tagstered.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author matias
 *
 */
@Entity
@Table(name = "TAG")
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
