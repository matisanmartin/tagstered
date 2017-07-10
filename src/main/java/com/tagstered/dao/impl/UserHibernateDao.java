package com.tagstered.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tagstered.dao.UserDao;
import com.tagstered.model.User;

@Repository("userDao")
public class UserHibernateDao implements UserDao {
	
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.tagstered.dao.UserDao#findByUserId(java.lang.String)
	 */
	@Override
	public User findByUserId(String userId) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from( User.class);
		criteria.select(root);
		criteria.where( builder.equal(root.get("userId"), userId));
		List<User> byUserId = getSession().createQuery(criteria).getResultList();
		if(byUserId != null && !byUserId.isEmpty())
			return byUserId.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see com.tagstered.dao.UserDao#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer id) {
		return getSession().get(User.class, id);
	}

	/* (non-Javadoc)
	 * @see com.tagstered.dao.UserDao#create(com.tagstered.model.User)
	 */
	@Override
	public User create(User user) {
		getSession().save(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.tagstered.dao.UserDao#update(com.tagstered.model.User)
	 */
	@Override
	public User update(User user) {
		getSession().update(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.tagstered.dao.UserDao#delete(com.tagstered.model.User)
	 */
	@Override
	public void delete(User user) {
		getSession().delete(user);
		
	}

}
