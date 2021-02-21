package com.ar.alkemy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;

public interface AdminService {

	public Boolean userCheck(String dni, String psw, Integer id);
	public Professor getProfessorById(Integer id);
	public String getRolFromSession(HttpServletRequest request);
	public Boolean checkRol(String rol);
	public List<Subject> getSubjectsList();
	public List<Professor> getProfessorsList();
	public void insertSubject(Subject subject);
	public Subject getSubjectById(Integer id);
	public void deleteProfessor(Integer id);
	public void saveProfessor(Professor professor);
	public void updateProfessor(Professor professor);
	public void updateSubject(Subject subject);
	public void deleteSubject(Integer id);
	public void deactivateProfessor(Integer id);
	public void activateProfessor(Integer id);
	public void deactivateSubject(Integer id);
	public void activateSubject(Integer id);
	public Boolean checkProfessorForm(Professor professor);
	public Boolean checkSubjectForm(Subject subject);
}
