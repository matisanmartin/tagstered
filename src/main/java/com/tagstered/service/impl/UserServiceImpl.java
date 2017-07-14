package com.tagstered.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tagstered.dao.UserDao;
import com.tagstered.exception.TagsteredBusinessException;
import com.tagstered.model.Tag;
import com.tagstered.model.User;
import com.tagstered.service.UserService;

/**
 * @author matias
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * 
	 */
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#findById(java.lang.String)
	 */
	@Override
	public User findById(Integer id) throws TagsteredBusinessException {
		User user = userDao.findById(id);
		if (user == null)
			throw new TagsteredBusinessException("User doesnt exist");
		return user;
	}

	/*
	 * (non-Javadoc)
	 */
	/**
	 * @param userName
	 * @return
	 * @throws TagsteredBusinessException
	 */
	@Override
	public User create(String userName, String token) throws TagsteredBusinessException {
		try {
			User user = new User();
			user.setUserId(userName);
			user.setToken(token);
			return userDao.create(user);
		} catch (Exception e) {
			logger.error("Cannot create object", e);
			throw new TagsteredBusinessException("Cannot create object");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#update(com.tagstered.model.User)
	 */
	@Override
	public User update(User user) throws TagsteredBusinessException {
		User existing = null;
		try {
			existing = userDao.findById(user.getId());
		} catch (Exception e) {
			logger.error("User doesnt exist or id is null", e);
			throw new TagsteredBusinessException("User doesnt exist");
		}

		existing.setUserId(user.getUserId());

		if (existing.getFollowedTags() != null)
			existing.getFollowedTags().clear();
		else
			existing.setFollowedTags(user.getFollowedTags());

		return userDao.update(existing);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#delete(com.tagstered.model.User)
	 */
	@Override
	public void delete(User user) throws TagsteredBusinessException {
		try {
			userDao.delete(user);
		} catch (Exception e) {
			logger.error("Cannot delete User", e);
			throw new TagsteredBusinessException("Cannot delete User");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#addFollowedTag(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public User addFollowedTag(Integer userId, String tag) throws TagsteredBusinessException {
		User user = userDao.findById(userId);

		if (user == null) {
			logger.error("User doesnt exist");
			throw new TagsteredBusinessException("User doesnt exist");
		}

		if (user.getFollowedTags() == null) {
			user.setFollowedTags(new ArrayList<>());
		} else {
			if (!user.getFollowedTags().isEmpty()) {
				long tagCountOnCurrentList = user.getFollowedTags().stream().filter(p -> tag.equals(p.getTagName()))
						.count();
				if (tagCountOnCurrentList > 0)
					throw new TagsteredBusinessException("User already added this tag");
			}
		}

		Tag newTag = new Tag();
		newTag.setTagName(tag);
		user.getFollowedTags().add(newTag);

		try {
			userDao.update(user);
		} catch (ConstraintViolationException e) {
			logger.error("Could not add followed tag", e);
			throw new TagsteredBusinessException("Could not add followed tag");
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#findByUserId(java.lang.String)
	 */
	@Override
	public User findByUserId(String userId) throws TagsteredBusinessException {
		User user = userDao.findByUserId(userId);
		if (user == null)
			throw new TagsteredBusinessException("User doesnt exist");
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#removeFollowedTag(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public User removeFollowedTag(Integer userId, String tagName) throws TagsteredBusinessException {

		if (tagName == null || "".equals(tagName)) {
			logger.error("Empty tagName");
			throw new TagsteredBusinessException("Cannot delete empty tag");
		}

		if (userId == null) {
			logger.error("userId is null");
			throw new TagsteredBusinessException("userId is null");
		}

		User user = userDao.findById(userId);

		if (user == null) {
			logger.error("User doesnt exist");
			throw new TagsteredBusinessException("User doesnt exist");
		}

		if (user.getFollowedTags() == null || user.getFollowedTags().isEmpty()) {
			logger.error("User doesnt have any followed tags and cannot delete tag: " + tagName);
			throw new TagsteredBusinessException(
					"User doesnt have any followed tags and cannot delete tag: " + tagName);
		}

		long count = user.getFollowedTags().stream().filter(p -> tagName.equals(p.getTagName())).count();

		if (count == 0) {
			logger.error("User doesnt follow this tag" + tagName);
			throw new TagsteredBusinessException("User doesnt follow this tag" + tagName);
		}

		user.getFollowedTags().removeIf(p -> tagName.equals(p.getTagName()));

		return userDao.update(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tagstered.service.UserService#createOrUpdateUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User createOrUpdateUser(String userName, String token) throws TagsteredBusinessException {
		if (userName == null || "".equals(userName))
			throw new TagsteredBusinessException("Cannot create user with empty username");

		if (token == null || "".equals(token))
			throw new TagsteredBusinessException("Cannot create user with empty token");

		User user = userDao.findByUserId(userName);

		if (user == null) {
			User toCreate = new User();
			toCreate.setUserId(userName);
			toCreate.setToken(token);
			return userDao.create(toCreate);
		} else {
			if (!token.equals(user.getToken())) {
				user.setToken(token);
				return userDao.update(user);
			}
		}

		return user;

	}

}
