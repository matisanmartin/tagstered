package com.tagstered.service;

import com.tagstered.model.User;

public interface UserService {
	
	User findById(String id);
	
	User create(User user) throws Exception;
	
	User update(User user) throws Exception;
	
	void delete(User user) throws Exception;

}
