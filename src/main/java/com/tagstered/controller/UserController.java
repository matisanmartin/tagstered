package com.tagstered.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<User>(userService.findById(userId), HttpStatus.OK);
	}

}
