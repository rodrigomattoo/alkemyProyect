package com.ar.alkemy.dao;

import java.util.List;

import com.ar.alkemy.entity.Professor;

public interface ProfessorDao {
	
	public List<Professor> getProfessors();

	public void insertProfessor(Professor professor);

	public Professor getProfessorById(Integer id);
	
	

}
