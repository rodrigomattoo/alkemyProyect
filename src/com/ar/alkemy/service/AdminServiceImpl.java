package com.ar.alkemy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.alkemy.controller.adminController;
import com.ar.alkemy.dao.AdminDAO;
import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Boolean userCheck(String dni, String psw, Integer id) {
		Boolean result = false;
		User user = adminDAO.getUserById(id);
		if (user.getDni().equals(dni) && user.getFile().equals(psw)) {
			result = true;
		}
		return result;
	}

	@Override
	public Professor getProfessorById(Integer id) {
		Professor professor = adminDAO.getProfessorById(id);
		return professor;
	}

	@Override
	public String getRolFromSession(HttpServletRequest request) {
		String rol = (String) request.getSession().getAttribute("ROL");
		return rol;
	}

	@Override
	public Boolean checkRol(String rol) {
		Boolean result = false;
		if (!rol.equals("admin") || rol.equals(null))
			result = true;
		return result;
	}

	@Override
	public List<Subject> getSubjectsList() {
		List<Subject> subjects = adminDAO.getSubjectsList();
		return subjects;
	}

	@Override
	public List<Professor> getProfessorsList() {
		List<Professor> professors = adminDAO.getProfessorList();
		return professors;
	}

	@Override
	public void insertSubject(Subject subject) {
		adminDAO.insertSubject(subject);
	}

	@Override
	public Subject getSubjectById(Integer id) {
		Subject subject = adminDAO.getSubjectById(id);
		return subject;
	}

	@Override
	public void deleteProfessor(Integer id) {
		adminDAO.deleteProfessor(id);
	}

	@Override
	public void saveProfessor(Professor professor) {
		adminDAO.saveProfessor(professor);
	}

	@Override
	public void updateProfessor(Professor professor) {
		adminDAO.updateProfessor(professor);
	}

	@Override
	public void updateSubject(Subject subject) {
		adminDAO.updateSubject(subject);
	}

	@Override
	public void deleteSubject(Integer id) {
		adminDAO.deleteSubject(id);
	}

	@Override
	public void deactivateProfessor(Integer id) {
		Professor professor = adminDAO.getProfessorById(id);
		professor.setActive(0);
		adminDAO.updateProfessor(professor);
	}

	@Override
	public void activateProfessor(Integer id) {
		Professor professor = adminDAO.getProfessorById(id);
		professor.setActive(1);
		adminDAO.updateProfessor(professor);
	}

	@Override
	public void deactivateSubject(Integer id) {
		Subject subject = adminDAO.getSubjectById(id);
		subject.setActive(0);
		adminDAO.updateSubject(subject);
	}

	@Override
	public void activateSubject(Integer id) {
		Subject subject = adminDAO.getSubjectById(id);
		subject.setActive(1);
		adminDAO.updateSubject(subject);
	}

	@Override
	public Boolean checkProfessorForm(Professor professor) {
		Boolean result = false;
		String name = professor.getName().trim();
		String lastName = professor.getLastName().trim();
		String dni = professor.getDni().trim();
		if (name.isEmpty() || lastName.isEmpty() || dni.isEmpty())
			result = true;
		return result;
	}

	@Override
	public Boolean checkSubjectForm(Subject subject) {
		Boolean result = false;
		String name = subject.getName().trim();
		String day = subject.getDay().trim();
		String schedule = subject.getSchedule().trim();
		Integer capacity = subject.getCapacity();
		String description = subject.getDescription().trim();
		if (name.isEmpty()||day.isEmpty()||schedule.isEmpty()||description.isEmpty()||capacity == null) {
			result = true;
		}
		return result;
	}

}
