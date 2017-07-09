package com.tagstered.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author matias
 *
 */
@Entity
@Table(name = "USER")
public class User {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	/**
	 * 
	 */
	@Column(name = "USER_ID", unique = true)
	String userId;

	/**
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	Collection<Tag> followedTags;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<Tag> getFollowedTags() {
		return followedTags;
	}

	public void setFollowedTags(Collection<Tag> followedTags) {
		this.followedTags = followedTags;
	} 
}		
