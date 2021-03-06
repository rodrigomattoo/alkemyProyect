package com.ar.alkemy.service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.alkemy.dao.StudentDao;
import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public String getRolFromSession(HttpServletRequest request) {
		String rol = (String) request.getSession().getAttribute("ROL");
		return rol;
	}

	@Override
	public boolean checkRol(String rol) {
		Boolean result = false;
		if (!rol.equals("student") || rol.equals(null))
			result = true;
		return result;
	}

	@Override
	public List<Subject> getListAvailableSubjects() {
		List<Subject> list = studentDao.getListAvailableSubjects();
		return list;
	}

	@Override
	public Subject getSubjectById(Integer id) {
		Subject subject = studentDao.getSubjectById(id);
		return subject;
	}

	@Override
	public Integer getIdFromSession(HttpServletRequest request) {
		Integer id = (Integer) request.getSession().getAttribute("ID");
		return id;
	}

	@Override
	public User getUserById(Integer id) {
		User user = studentDao.getUserById(id);
		return user;
	}

	@Override
	public Integer register(Inscription inscription) {
		studentDao.register(inscription);
		Object obj = this.studentDao.getInscriptionsCount(inscription);
		Integer inscriptions = Integer.parseInt(obj.toString());
		Integer capacity = inscription.getSubject().getCapacity();
		Integer availability = capacity - inscriptions;
		inscription.getSubject().setAvailability(availability);
		studentDao.updateAvailabilitySubject(inscription.getSubject().getId(), availability);
		return availability;
	}

	@Override
	public Boolean scheduleCheck(Subject subject, Integer id) {
		List<Inscription> list = studentDao.getInscriptionsFromStudentId(id);
		Iterator<Inscription> it = list.iterator();
		Boolean result = false;
		while (it.hasNext() && !result) {
			Inscription inscription = (Inscription) it.next();
			String day = inscription.getSubject().getDay();
			String schedule = inscription.getSubject().getSchedule();
			if (day.equals(subject.getDay()) && schedule.equals(subject.getSchedule())) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public String getDataFromSession(HttpServletRequest request) {
		String error = (String) request.getSession().getAttribute("DATA");
		return error;
	}
	
	@Override
	public Object getCountInscription(Inscription inscription) {
		Object count = studentDao.getInscriptionsCount(inscription);
		return count;
	}
}
