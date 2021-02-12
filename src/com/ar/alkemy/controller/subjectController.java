package com.ar.alkemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ar.alkemy.dao.ProfessorDao;
import com.ar.alkemy.dao.SubjectDao;
import com.ar.alkemy.entity.Professor;
import com.ar.alkemy.entity.Subject;

@Controller
public class subjectController {

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private ProfessorDao professorDao;

	@RequestMapping("/subjectsList")
	public String subjectsList(Model modelo) {

		List<Subject> subjects = subjectDao.getSubjects();

		modelo.addAttribute("subjects", subjects);

		return "subjectsList";

	}

	@RequestMapping("/subjectForm")
	public String professorForm(Model model) {

		Subject subject = new Subject();

		List<Professor> professors = professorDao.getProfessors();

		model.addAttribute("subject", subject);

		model.addAttribute("professors", professors);

		return "subjectForm";

	}

	@PostMapping("/insertSubject")
	public String insertProfessor(@ModelAttribute("subject") Subject subject) {

		subjectDao.insertSubject(subject);

		return "redirect:/subjectsList";

	}

	@GetMapping("/updateSubjectForm")
	public String update(@RequestParam("subjectId") Integer id, Model model) {

		Subject subject = subjectDao.getSubjectById(id);

		List<Professor> professors = professorDao.getProfessors();

		model.addAttribute("subject", subject);

		model.addAttribute("professors", professors);

		return "subjectForm";
	}

}
