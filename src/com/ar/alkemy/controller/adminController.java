package com.ar.alkemy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;
import com.ar.alkemy.entity.User;
import com.ar.alkemy.service.AdminService;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;

@Controller
public class adminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/professorsList")
	public String professorsList(HttpServletRequest request, Model model) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		List<Professor> professor = adminService.getProfessorsList();
		model.addAttribute("professors", professor);
		model.addAttribute("mnjs", rol);
		return "professorsList";
	}

	@RequestMapping("/professorForm")
	public String professorForm(Model model, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		String error = (String) request.getSession().getAttribute("ERROR");
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		model.addAttribute("ERROR", error);
		return "professorForm";
	}

	@PostMapping("/insertProfessor")
	public String insertProfessor(@ModelAttribute("professor") Professor professor, HttpServletRequest request,
			Model model) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		if (adminService.checkProfessorForm(professor)) {
			String error = "Formulario invalido.";
			request.getSession().setAttribute("ERROR", error);
			return "redirect:/professorForm";
		} else {
			request.getSession().removeAttribute("ERROR");
			professor.setActive(1);
			adminService.saveProfessor(professor);
			return "redirect:/professorsList";
		}
	}

	@RequestMapping("/updateProfessorForm/{id}")
	public String updateProfessorForm(@PathVariable Integer id, HttpServletRequest request, Model model) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		Professor professor = adminService.getProfessorById(id);
		model.addAttribute("professor", professor);
		return "professorFormEdit";
	}

	@PostMapping("/updateProfessor")
	public String updateProfessor(@ModelAttribute("professor") Professor professor, HttpServletRequest request) {
		adminService.updateProfessor(professor);
		return "redirect:/professorsList";
	}

	@GetMapping("/deactivateProfessor/{id}")
	public String professorDelete(@PathVariable Integer id, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		adminService.deactivateProfessor(id);
		return "redirect:/professorsList";
	}

	@GetMapping("/activateProfessor/{id}")
	public String activateProfessor(@PathVariable Integer id, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		adminService.activateProfessor(id);
		return "redirect:/professorsList";
	}

	// Subjects
	@RequestMapping("/subjectsList")
	public String subjectsList(Model modelo, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		List<Subject> subjects = adminService.getSubjectsList();
		modelo.addAttribute("subjects", subjects);
		return "subjectsList";
	}

	@RequestMapping("/subjectForm")
	public String subjectForm(Model model, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		List<Professor> professors = adminService.getProfessorsList();
		model.addAttribute("professors", professors);
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "subjectForm";
	}

	@PostMapping("/insertSubject")
	public String insertSubject(@ModelAttribute("subject") Subject subject, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		if (adminService.checkSubjectForm(subject)) {
			String error = "Formulario invalido.";
			request.getSession().setAttribute("ERROR", error);
			return "redirect:/subjectForm";
		} else {
			Professor professor = adminService.getProfessorById(subject.getProfessorId());
			subject.setProfessor(professor);
			subject.setActive(1);
			subject.setAvailability(subject.getCapacity());
			adminService.insertSubject(subject);
			request.getSession().removeAttribute("ERROR");
			return "redirect:/subjectsList";
		}
	}

	@GetMapping("/updateSubjectForm")
	public String updateSubjectForm(@RequestParam("subjectId") Integer id, Model model, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		Subject subject = adminService.getSubjectById(id);
		model.addAttribute("subject", subject);
		List<Professor> professors = adminService.getProfessorsList();
		model.addAttribute("professors", professors);
		return "subjectFormEdit";
	}

	@PostMapping("updateSubject")
	public String updateSubject(@ModelAttribute("subject") Subject subject) {
		Professor professor = adminService.getProfessorById(subject.getProfessorId());
		subject.setProfessor(professor);
		adminService.updateSubject(subject);
		return "redirect:/subjectsList";
	}

	@GetMapping("deactivateSubject/{id}")
	public String deactivateSubject(@PathVariable Integer id, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		adminService.deactivateSubject(id);
		return "redirect:/subjectsList";
	}

	@GetMapping("activateSubject/{id}")
	public String activateSubject(@PathVariable Integer id, HttpServletRequest request) {
		String rol = adminService.getRolFromSession(request);
		if (adminService.checkRol(rol)) {
			return "redirect:/";
		}
		adminService.activateSubject(id);
		return "redirect:/subjectsList";
	}
}
