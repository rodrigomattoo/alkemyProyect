package com.ar.alkemy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ar.alkemy.entity.Inscription;
import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;
import com.ar.alkemy.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/listAvailableSubjects")
	public String listAvailableSubjects(HttpServletRequest request, Model model) {
		String rol = studentService.getRolFromSession(request);
		String error= studentService.getDataFromSession(request);
		if (studentService.checkRol(rol)) {
			return "redirect:/";
		}
		List<Subject> list = studentService.getListAvailableSubjects();
		Boolean result = list.isEmpty();
		model.addAttribute("result", result);
		model.addAttribute("list", list);
		model.addAttribute("DATA", error);
		return "listAvailableSubjects";
		
	}

	@GetMapping("/subjectDetail/{id}")
	public String subjectDetail(@PathVariable Integer id, HttpServletRequest request, Model model) {
		String rol = studentService.getRolFromSession(request);
		if (studentService.checkRol(rol)) {
			return "redirect:/";
		}
		request.getSession().removeAttribute("ERROR");
		Subject subject = studentService.getSubjectById(id);
		model.addAttribute("subject", subject);
		return "subjectDetail";
	}

	@PostMapping("/registerInscription")
	public String register(@ModelAttribute("subject") Subject subject, HttpServletRequest request, Model model) {
		Integer id = studentService.getIdFromSession(request);
		User user = studentService.getUserById(id);
		Boolean check = studentService.scheduleCheck(subject, id);
		if(check) {
			String data = "Ya se encuentra inscripto en una materia en el mismo dia y horario.";
			request.getSession().setAttribute("DATA", data);
			return "redirect:/listAvailableSubjects";
		}else {
			Inscription inscription = new Inscription();
			inscription.setSubject(subject);
			inscription.setUser(user);
			studentService.register(inscription);
			String data = "Se ha Inscripto con exito.";
			request.getSession().removeAttribute("ERROR");
			request.getSession().setAttribute("DATA", data);
			return "redirect:/listAvailableSubjects";			
		}
	}
}
