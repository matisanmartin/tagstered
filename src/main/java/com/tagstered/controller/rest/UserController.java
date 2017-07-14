package com.tagstered.controller.rest;

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
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value =  "/user/{id}/{token}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@PathVariable("id") String userId, @PathVariable("token") String token) {
		try {
			return new ResponseEntity<User>(userService.create(userId, token), HttpStatus.OK);
		} catch (TagsteredBusinessException e) {
			logger.error("Error occured when creating user: " + userId, e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value =  "/user/{id}/{token}/createOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createOrUpdate(@PathVariable("id") String userId, @PathVariable("token") String token) {
		try {
			return new ResponseEntity<User>(userService.createOrUpdateUser(userId, token), HttpStatus.OK);
		} catch (TagsteredBusinessException e) {
			logger.error("Error occured when creating user: " + userId, e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param userId
	 * @param tagName
	 * @return
	 */
	@RequestMapping(value = "/user/{id}/tag/{tagName}/add", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addTag(@PathVariable("id") Integer userId, @PathVariable("tagName") String tagName) {
		try {
			return new ResponseEntity<User>(userService.addFollowedTag(userId, tagName), HttpStatus.OK);
		} catch(TagsteredBusinessException e) {
			logger.error("Error occured when adding tag: " + tagName + " for user: " + userId, e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param userId
	 * @param tagName
	 * @return
	 */
	@RequestMapping(value = "/user/{id}/tag/{tagName}/remove", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> removeTag(@PathVariable("id") Integer userId, @PathVariable("tagName") String tagName) {
		try {
			return new ResponseEntity<User>(userService.removeFollowedTag(userId, tagName), HttpStatus.OK);
		} catch (TagsteredBusinessException e) {
			logger.error("Error occured when removing tag: " + tagName + " for user: " + userId, e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
