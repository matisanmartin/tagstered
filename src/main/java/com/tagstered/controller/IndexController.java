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
        return "user";
    }
}
