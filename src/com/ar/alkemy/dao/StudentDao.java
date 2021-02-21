package com.ar.alkemy.dao;

import java.util.List;

import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;
import com.ar.alkemy.entity.InscriptionCount;

public interface StudentDao {

	public List<Subject> getListAvailableSubjects();
	public Subject getSubjectById(Integer id);
	public User getUserById(Integer id);
	public void register(Inscription inscription);
	public List<Inscription> getInscriptionsFromStudentId(Integer id);
	public List<InscriptionCount> getInscriptionsCount();

}
