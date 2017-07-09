package com.tagstered.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tagstered.dao.UserDao;
import com.tagstered.model.User;

@Repository
public class UserHibernateDao implements UserDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User findByUserId(String userId) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from( User.class);
		criteria.select(root);
		criteria.where( builder.equal(root.get("userId"), userId));
		List<User> byUserId = getSession().createQuery(criteria).getResultList();
		return byUserId.get(0);
	}

	@Override
	public User findById(Integer id) {
		return getSession().get(User.class, id);
	}

	@Override
	public User create(User user) {
		getSession().save(user);
		return user;
	}

	@Override
	public User update(User user) {
		getSession().update(user);
		return user;
	}

	@Override
	public void delete(User user) {
		getSession().delete(user);
		
	}

}
