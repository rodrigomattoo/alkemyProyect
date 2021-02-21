package com.ar.alkemy.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.alkemy.dao.LoginDAO;
import com.ar.alkemy.entity.User;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	LoginDAO loginDao;

	@Override
	public Boolean checkError(HttpServletRequest request) {
		Boolean result = false;
		String error = this.getErrorFromSession(request);
		if (error != null)
			result = true;
		return result;
	}

	@Override
	public String getErrorFromSession(HttpServletRequest request) {
		String error = (String) request.getSession().getAttribute("ERROR");
		return error;
	}

	@Override
	public User getUser(User user) {
		User userRequest = loginDao.getUser(user);
		return userRequest;
	}
}
