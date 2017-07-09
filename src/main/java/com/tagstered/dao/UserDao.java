package com.tagstered.dao;

import com.tagstered.model.User;

public interface UserDao {
	
	User findByUserId(String userId);
	
	User findById(Integer id);

	User create(User user);

	User update(User user);

	void delete(User user);

}
