package com.tagstered.service;

import com.tagstered.exception.TagsteredBusinessException;
import com.tagstered.model.User;

/**
 * @author matias
 *
 */
public interface UserService {
	
	/**
	 * @param id
	 * @return
	 */
	User findById(String id);
	
	/**
	 * @param user
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User create(User user) throws TagsteredBusinessException;
	
	/**
	 * @param user
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User update(User user) throws TagsteredBusinessException;
	
	/**
	 * @param user
	 * @throws TagsteredBusinessException
	 */
	void delete(User user) throws TagsteredBusinessException;
	
	/**
	 * @param userId
	 * @param tag
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User addFollowedTag(Integer userId, String tag) throws TagsteredBusinessException;

}
