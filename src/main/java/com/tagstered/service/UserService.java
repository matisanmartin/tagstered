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
	 * @throws TagsteredBusinessException 
	 */
	User findById(Integer id) throws TagsteredBusinessException;
	
	/**
	 * @param userId
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User findByUserId(String userId) throws TagsteredBusinessException;
	
	/**
	 * @param userName
	 * @param token
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User create(String userName, String token) throws TagsteredBusinessException;
	
	/**
	 * @param user
	 * @return
	 * @throws TagsteredBusinessException
	 */
	User update(User user) throws TagsteredBusinessException;
	
	/**
	 * @param userName
	 * @param token
	 * @return
	 * @throws TagsteredBusinessException 
	 */
	User createOrUpdateUser(String userName, String token) throws TagsteredBusinessException;
	
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

	/**
	 * @param userId
	 * @param tagName
	 * @return
	 * @throws TagsteredBusinessException 
	 */
	User removeFollowedTag(Integer userId, String tagName) throws TagsteredBusinessException;

}
