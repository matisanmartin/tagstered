package com.tagstered.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
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

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#findById(java.lang.String)
	 */
	@Override
	public User findById(Integer id) throws TagsteredBusinessException {
		User user = userDao.findById(id);
		if(user == null)
			throw new TagsteredBusinessException("User doesnt exist");
		return user;
	}

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#create(com.tagstered.model.User)
	 */
	@Override
	public User create(User user) throws TagsteredBusinessException {
		try {
			return userDao.create(user);
		} catch(Exception e) {
			logger.error("Cannot create object", e);
			throw new TagsteredBusinessException("Cannot create object");
		}
	}

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#update(com.tagstered.model.User)
	 */
	@Override
	public User update(User user) throws TagsteredBusinessException {
		User existing = userDao.findById(user.getId());
		if (existing == null)
			throw new TagsteredBusinessException("User doesnt exist");

		existing.setUserId(user.getUserId());

		if (existing.getFollowedTags() != null)
			existing.getFollowedTags().clear();
		else
			existing.setFollowedTags(user.getFollowedTags());

		return userDao.update(existing);
	}

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#delete(com.tagstered.model.User)
	 */
	@Override
	public void delete(User user) throws TagsteredBusinessException {
		try {
			userDao.delete(user);
		} catch(Exception e) {
			logger.error("Cannot delete User", e);
			throw new TagsteredBusinessException("Cannot delete User");
		}
	}

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#addFollowedTag(java.lang.Integer, java.lang.String)
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
		userDao.update(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.tagstered.service.UserService#findByUserId(java.lang.String)
	 */
	@Override
	public User findByUserId(String userId) throws TagsteredBusinessException {
		User user = userDao.findByUserId(userId);
		if(user == null)
			throw new TagsteredBusinessException("User doesnt exist");
		return user;
	}

}
