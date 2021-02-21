package com.ar.alkemy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;
import com.ar.alkemy.entity.InscriptionCount;

public interface StudentService {

	public String getRolFromSession(HttpServletRequest request);
	public boolean checkRol(String rol);
	public List<Subject> getListAvailableSubjects();
	public Subject getSubjectById(Integer id);
	public Integer getIdFromSession(HttpServletRequest request);
	public User getUserById(Integer id);
	public void register(Inscription inscription);
	public Boolean scheduleCheck(Subject subject, Integer id);
	public String getDataFromSession(HttpServletRequest request);
	public List<InscriptionCount> getAvailbility();
}
