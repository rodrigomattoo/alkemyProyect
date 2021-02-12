package com.ar.alkemy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Subject> getSubjects() {

		Session miSession = sessionFactory.getCurrentSession();

		Query<Subject> miQuery = miSession.createQuery("FROM Subject", Subject.class);

		List<Subject> subjects = miQuery.getResultList();

		return subjects;
	}

	@Override
	@Transactional
	public void insertSubject(Subject subject) {

		Session miSession = sessionFactory.getCurrentSession();

		miSession.saveOrUpdate(subject);

	}

	@Override
	@Transactional
	public Subject getSubjectById(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		Subject subject = miSession.get(Subject.class, id);

		return subject;

	}

}
