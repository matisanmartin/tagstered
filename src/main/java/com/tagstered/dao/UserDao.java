package com.tagstered.dao;

import com.tagstered.model.User;

public interface UserDao {
	
	/**
	 * @param userId
	 * @return
	 */
	User findByUserId(String userId);
	
	/**
	 * @param id
	 * @return
	 */
	User findById(Integer id);

	/**
	 * @param user
	 * @return
	 */
	User create(User user);

	/**
	 * @param user
	 * @return
	 */
	User update(User user);

	/**
	 * @param user
	 */
	void delete(User user);

}
