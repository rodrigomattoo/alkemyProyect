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
import com.ar.alkemy.entity.User;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserById(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		User user = miSession.get(User.class, id);

		return user;
	}

	@Override
	public Professor getProfessorById(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		Professor professor = miSession.get(Professor.class, id);

		return professor;

	}

	@Override
	public List<Subject> getSubjectsList() {

		Session miSession = sessionFactory.getCurrentSession();

		Query<Subject> miQuery = miSession.createQuery("FROM Subject", Subject.class);

		List<Subject> subjects = miQuery.getResultList();

		return subjects;
	}

	@Override
	public List<Professor> getProfessorList() {

		Session miSession = sessionFactory.getCurrentSession();

		Query<Professor> miQuery = miSession.createQuery("FROM Professor", Professor.class);

		List<Professor> professors = miQuery.getResultList();

		return professors;

	}

	@Override
	public void insertSubject(Subject subject) {

		Session miSession = sessionFactory.getCurrentSession();

		miSession.save(subject);

	}

	@Override
	public Subject getSubjectById(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		Subject subject = miSession.get(Subject.class, id);

		return subject;

	}

	@Override
	public void deleteProfessor(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		Professor professor = miSession.get(Professor.class, id);

		miSession.delete(professor);

	}

	@Override
	public void saveProfessor(Professor professor) {

		Session miSession = sessionFactory.getCurrentSession();

		miSession.save(professor);

	}

	@Override
	public void updateProfessor(Professor professor) {

		Session miSession = sessionFactory.getCurrentSession();

		miSession.update(professor);

	}

	@Override
	public void updateSubject(Subject subject) {

		Session miSession = sessionFactory.getCurrentSession();
		miSession.update(subject);

	}

	@Override
	public void deleteSubject(Integer id) {

		Session miSession = sessionFactory.getCurrentSession();

		Subject subject = miSession.get(Subject.class, id);

		miSession.delete(subject);
	}

}
