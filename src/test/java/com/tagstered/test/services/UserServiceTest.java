package com.tagstered.test.services;

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
@DatabaseSetup("/user-dataset.xml")
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
		User created = userService.create("test", "q6wd1qd61q6dq16dqwd8q9d9wqq9q8");
		Assert.assertNotNull(created);
		Assert.assertEquals("test", created.getUserId());
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
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testFindByIdNonExisting() throws TagsteredBusinessException {
		User user = userService.findById(500000);
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testFindByUserIdNonExisting() throws TagsteredBusinessException {
		User user = userService.findByUserId("NonExisting");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testAddTagToUserAndUserAlreadyHasIt() throws TagsteredBusinessException {
		User updated = userService.addFollowedTag(1, "test");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = Exception.class)
	public void testCreateAlreadyExistingUser() throws TagsteredBusinessException {
		User toCreate = userService.findById(1);
		User created = userService.create(toCreate.getUserId(), "qwdq1w6dqw6dqw6dq1wdqw");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testUpdateNonExistingUser() throws TagsteredBusinessException {
		User user = new User();
		User updated = userService.update(user);
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test
	public void testRemoveFollowedTag() throws TagsteredBusinessException {
		User withNoFollowedTags = userService.removeFollowedTag(1, "test");
		Assert.assertNotNull(withNoFollowedTags);
		Assert.assertNotNull(withNoFollowedTags.getFollowedTags());
		Assert.assertTrue(withNoFollowedTags.getFollowedTags().isEmpty());
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagNonExistingInList() throws TagsteredBusinessException {
		User withError = userService.removeFollowedTag(1, "test2");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@SuppressWarnings("unused")
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagWhenThereAreNoTags() throws TagsteredBusinessException {
		User created = userService.create("anotherTestUser", "asd12ed211hd1d129hd129udh12");
		User updatedWithError = userService.removeFollowedTag(created.getId(), "test");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagWithNullUserId() throws TagsteredBusinessException {
		userService.removeFollowedTag(null, "test");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagWIthNullTagName() throws TagsteredBusinessException {
		userService.removeFollowedTag(1, null);
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagWithEmptyTagName() throws TagsteredBusinessException {
		userService.removeFollowedTag(1, "");
	}
	
	/**
	 * @throws TagsteredBusinessException
	 */
	@Test(expected = TagsteredBusinessException.class)
	public void testRemoveFollowedTagWFromNonExistingUser() throws TagsteredBusinessException {
		userService.removeFollowedTag(11111111, "test");
	}
	

}
