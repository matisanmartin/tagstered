package com.tagstered.test.services;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.tagstered.exception.TagsteredBusinessException;
import com.tagstered.model.Tag;
import com.tagstered.model.User;
import com.tagstered.service.UserService;
import com.tagstered.spring.config.ApplicationConfig;
import com.tagstered.spring.config.HibernateConfig;

/**
 * @author matias
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationConfig.class, HibernateConfig.class })
@TestPropertySource(locations = "classpath:test.properties")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@DatabaseSetup("user-dataset.xml")
public class UserServiceTest {

	/**
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * 
	 */
	@Test
	public void testUserServiceIsNotNull() {
		Assert.assertNotNull(userService);
	}

	/**
	 * @throws TagsteredBusinessException
	 */
	@Test
	public void testCreateUser() throws TagsteredBusinessException {
		User user = new User();
		user.setUserId("test");
		user.setFollowedTags(new ArrayList<>());
		Tag tag = new Tag();
		tag.setTagName("test");
		user.getFollowedTags().add(tag);

		User created = userService.create(user);
		Assert.assertNotNull(created);
		Assert.assertEquals(user.getUserId(), created.getUserId());
		Assert.assertNotNull(created.getFollowedTags());
		Assert.assertEquals(user.getFollowedTags().size(), created.getFollowedTags().size());
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test
	public void testAddTagToUser() throws TagsteredBusinessException {
		User user = userService.findById(1);
		User updated = userService.addFollowedTag(1, "test2");
		Assert.assertEquals(user.getFollowedTags().size(), updated.getFollowedTags().size()-1);
	}

	/**
	 * @throws TagsteredBusinessException
	 */
	@Test
	public void testFindUserById() throws TagsteredBusinessException {
		User user = userService.findById(1);
		Assert.assertNotNull(user);
		Assert.assertEquals(new Integer(1), user.getId());
		Assert.assertEquals("matism", user.getUserId());
		Assert.assertNotNull(user.getFollowedTags());
		Assert.assertFalse(user.getFollowedTags().isEmpty());
	}

	/**
	 * @throws TagsteredBusinessException
	 */
	@Test
	public void testFindUserByUserId() throws TagsteredBusinessException {
		User user = userService.findByUserId("matism");
		Assert.assertNotNull(user);
		Assert.assertEquals("matism", user.getUserId());
	}

}
