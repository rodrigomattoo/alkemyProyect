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
import com.ar.alkemy.entity.Professor;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorDao professorDao;
	
	@RequestMapping("/professorsList")	
	public String professorsList(Model modelo) {
		
		List<Professor> professors = professorDao.getProfessors();
		
		
		modelo.addAttribute("professors", professors);
		
		return "professorsList";
		
	}
	
	
	@RequestMapping("/professorForm")
	public String professorForm(Model model) {
		
		//bind de datos de los profesores.
		
		Professor professor = new Professor();
		
		model.addAttribute("professor", professor);
		
		return "professorForm";
		
	}
	
	@PostMapping("/insertProfessor")
	public String insertProfessor(@ModelAttribute("professor") Professor professor) {
		
		
		professorDao.insertProfessor(professor);
		
		return "redirect:/professorsList";
		
	}
	
	@GetMapping("/updateForm")
	public String update(@RequestParam("professorId") Integer id, Model model) {
		
		//Obtener el cliente de la url.
		Professor professor = professorDao.getProfessorById(id);
		
		//Estblecer el cliente como atributo del modelo.
		model.addAttribute("professor", professor);
		
		//enviar al formulario.
		return "professorForm";
	}
	

}
