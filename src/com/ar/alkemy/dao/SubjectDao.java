package com.ar.alkemy.dao;

import java.util.List;

import com.ar.alkemy.entity.Subject;


public interface SubjectDao {
	
	public List<Subject> getSubjects();

	public void insertSubject(Subject subject);

	public Subject getSubjectById(Integer id);

}
