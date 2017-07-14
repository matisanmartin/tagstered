package com.tagstered.controller.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tagstered.utils.TagsteredProperty;

@RestController
public class AuthenticationController {

	/**
	 * 
	 */
	@Autowired
	Environment env;

	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(AuthenticationController.class);

	/**
	 * 
	 */
	@RequestMapping(value = "/auth/clientId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagsteredProperty> getClientId() {
		logger.debug("getClientId {}");
		return new ResponseEntity<TagsteredProperty>(new TagsteredProperty(env.getProperty("instagram.client.id")), HttpStatus.OK);
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/auth/loginUrl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagsteredProperty> getLoginUrl() {
		logger.debug("getLoginUrl {}");
		return new ResponseEntity<TagsteredProperty>(new TagsteredProperty(env.getProperty("instagram.login.url")), HttpStatus.OK);
	}

}
