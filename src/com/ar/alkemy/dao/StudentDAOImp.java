package com.ar.alkemy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;
import com.ar.alkemy.entity.InscriptionCount;

@Repository
@Transactional
public class StudentDAOImp implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Subject> getListAvailableSubjects() {
		Session miSession = sessionFactory.getCurrentSession();
		// agregar todos los campos en la query.
		Query query = miSession.createQuery("SELECT s FROM Subject s WHERE active = 1 ORDER BY name");
		List<Subject> list = query.getResultList();
		return list;
	}

	@Override
	public Object getInscriptionsCount(Inscription inscription) {
		Session miSession = sessionFactory.getCurrentSession();
		Integer id = inscription.getSubject().getId();
		Query query = miSession.createQuery("SELECT COUNT(i) FROM Inscription i WHERE subject_id = " + id);
		Object result = query.getSingleResult();
		return result;
	}

	@Override
	public Subject getSubjectById(Integer id) {
		Session miSession = sessionFactory.getCurrentSession();
		Subject subject = miSession.get(Subject.class, id);
		return subject;
	}

	@Override
	public User getUserById(Integer id) {
		Session miSession = sessionFactory.getCurrentSession();
		User user = miSession.get(User.class, id);
		return user;
	}

	@Override
	public void register(Inscription inscription) {
		Session miSession = sessionFactory.getCurrentSession();
		miSession.save(inscription);
	}

	@Override
	public List<Inscription> getInscriptionsFromStudentId(Integer id) {
		Session miSession = sessionFactory.getCurrentSession();
		Query query = miSession.createQuery("SELECT i FROM Inscription i WHERE user_id = " + id);
		List<Inscription> list = query.getResultList();
		return list;
	}

	@Override
	public void updateSubject(Subject subject) {
		Session miSession = sessionFactory.getCurrentSession();
		miSession.update(subject);
	}

	@Override
	public void updateAvailabilitySubject(Integer id, Integer availability) {
		Session miSession = sessionFactory.getCurrentSession();
		int query = miSession.createQuery("UPDATE Subject s SET availability =" + availability + "WHERE id =" + id).executeUpdate();
	}
}
