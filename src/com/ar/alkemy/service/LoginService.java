package com.ar.alkemy.service;

import javax.servlet.http.HttpServletRequest;

import com.ar.alkemy.entity.User;

public interface LoginService {

	public Boolean checkError(HttpServletRequest request);
	public String getErrorFromSession(HttpServletRequest request);
	public User getUser(User user);
}
