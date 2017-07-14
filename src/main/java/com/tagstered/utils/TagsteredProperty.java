package com.tagstered.utils;

/**
 * @author matias
 *
 */
public class TagsteredProperty {

	/**
	 * 
	 */
	String value;

	/**
	 * @param property
	 */
	public TagsteredProperty(String property) {
		this.value = property;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
