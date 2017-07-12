package com.tagstered.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author matias
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "login";
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUserPage() {
		return "user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public String getTagPage() {
		return "tag";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}
}
