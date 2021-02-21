package com.ar.alkemy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ar.alkemy.entity.User;

@Repository
@Transactional
public class LoginDAOImp implements LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUser(User user) {
		
		Session miSession = sessionFactory.getCurrentSession();
			User userRequest =	(User) miSession.createCriteria(User.class).add(Restrictions.eq("dni", user.getDni()))
		.add(Restrictions.eq("file", user.getFile())).uniqueResult();
		return userRequest;
	}
}
