package com.tagstered.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tagstered.exception.TagsteredBusinessException;
import com.tagstered.model.User;
import com.tagstered.service.UserService;

/**
 * @author matias
 *
 */
@RestController
public class UserController {
	
	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Tagstered";
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> user(@PathVariable("id") String userId) {
		try {
			return new ResponseEntity<User>(userService.findByUserId(userId), HttpStatus.OK);
		} catch (TagsteredBusinessException e) {
			logger.error("Error occured when retrieving user with userId: " + userId, e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
