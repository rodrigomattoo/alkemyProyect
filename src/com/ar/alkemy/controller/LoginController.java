package com.ar.alkemy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ar.alkemy.entity.User;
import com.ar.alkemy.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String login(Model model, HttpServletRequest request) {
		if (loginService.checkError(request)) {
			String error = loginService.getErrorFromSession(request);
			model.addAttribute("ERROR", error);
		}
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}

	@RequestMapping("/login")
	public String loginProcess(@ModelAttribute("user") User user, HttpServletRequest request) {
		if (user.equals(null)) {
			return "redirect:/";
		}		
		User userRequest = loginService.getUser(user);
		String view = null;
		if (userRequest == null) {
			String mnsj = "Usuario o Contraseña Invalida.";
			request.getSession().setAttribute("ERROR", mnsj);
			view = "redirect:/";
		} else {
			request.getSession().setAttribute("ROL", userRequest.getUserType());
			switch (userRequest.getUserType()) {
			case "admin":
				view = "redirect:/professorsList";
				break;
			case "student":
				request.getSession().setAttribute("ROL", userRequest.getUserType());
				request.getSession().setAttribute("ID", userRequest.getId());
				view = "redirect:/listAvailableSubjects";
				break;
			}			
		}
		return view;
	}

	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("ROL");
		request.getSession().removeAttribute("ID");
		return "redirect:/";
	}
}
