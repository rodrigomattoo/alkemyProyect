package com.ar.alkemy.dao;

import java.util.List;

import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;

public interface AdminDAO {
	
	public User getUserById(Integer id);

	public Professor getProfessorById(Integer id);

	public List<Subject> getSubjectsList();

	public List<Professor> getProfessorList();

	public void insertSubject(Subject subject);

	public Subject getSubjectById(Integer id);

	public void deleteProfessor(Integer id);

	public void saveProfessor(Professor professor);

	public void updateProfessor(Professor professor);

	public void updateSubject(Subject subject);

	public void deleteSubject(Integer id);

}
