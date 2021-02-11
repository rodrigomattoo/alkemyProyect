package com.ar.alkemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ar.alkemy.entity.User;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String login(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "index";
	}
	
	@RequestMapping("loginProcess")
	public String loginProgcess() {
		
		
		return null;
	}

}
