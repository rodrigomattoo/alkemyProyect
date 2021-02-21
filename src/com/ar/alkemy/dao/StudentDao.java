package com.ar.alkemy.dao;

import java.util.List;

import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;

public interface StudentDao {

	public List<Subject> getListAvailableSubjects();
	public Subject getSubjectById(Integer id);
	public User getUserById(Integer id);
	public void register(Inscription inscription);
	public List<Inscription> getInscriptionsFromStudentId(Integer id);
	public Object getInscriptionsCount(Inscription inscription);
	public void updateSubject(Subject subject);
	public void updateAvailabilitySubject(Integer id, Integer availability);
}
