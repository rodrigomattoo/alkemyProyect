package com.ar.alkemy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ar.alkemy.entity.Professor;

@Repository
public class ProfessorDaoImpl implements ProfessorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Professor> getProfessors() {

		Session miSession = sessionFactory.getCurrentSession();

		Query<Professor> miQuery = miSession.createQuery("FROM Professor", Professor.class);

		List<Professor> professors = miQuery.getResultList();

		return professors;
	}

	@Override
	@Transactional
	public void insertProfessor(Professor professor) {

		Session miSession = sessionFactory.getCurrentSession();
		
		//miSession.save(professor);
		
		miSession.saveOrUpdate(professor);

	}

	@Override
	@Transactional
	public Professor getProfessorById(Integer id) {
		
		Session miSession = sessionFactory.getCurrentSession();
		
		Professor professor =  miSession.get(Professor.class, id);
		
		return professor;
	}

}
