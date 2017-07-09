package com.tagstered.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagstered.dao.UserDao;
import com.tagstered.model.Tag;
import com.tagstered.model.User;
import com.tagstered.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public User findById(String id) {
		User user = new User();
		user.setUserId(id);
		user.setId(1);
		Tag tag = new Tag();
		tag.setTagName("test");
		user.setFollowedTags(new ArrayList<Tag>());
		user.getFollowedTags().add(tag);
		return user;
	}

	@Override
	public User create(User user) throws Exception {
		User existing = userDao.findByUserId(user.getUserId());
		if(existing != null)
			throw new Exception("User already exists");
		
		return userDao.create(user);
		
	}

	@Override
	public User update(User user) throws Exception {
		User existing = userDao.findById(user.getId());
		if(existing == null)
			throw new Exception("User doesnt exist");
		
		if(existing.getFollowedTags() != null)
			existing.getFollowedTags().clear();
		else
			existing.setFollowedTags(user.getFollowedTags());
		
		return userDao.update(existing);
	}

	@Override
	public void delete(User user) throws Exception {
		User existing = userDao.findById(user.getId());
		if(existing == null)
			throw new Exception("User doesnt exist");
		
		userDao.delete(existing);
		
	}

}
