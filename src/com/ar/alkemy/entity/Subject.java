package com.ar.alkemy.entity;

import javax.persistence.*;

@Entity
public class Subject {

	private Integer professorId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String day;
	@Column
	private String schedule;
	@Column
	private Integer capacity;
	@Column
	private String description;
	@Column
	private Integer active;
	@Column
	private Integer availability;
	@ManyToOne
	private Professor professor;

	public Subject() {
	}

	public Subject(String name, String day, String schedule, Integer capacity, String description,
			Integer professorId) {
		this.name = name;
		this.day = day;
		this.schedule = schedule;
		this.capacity = capacity;
		this.description = description;
		this.professorId = professorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	
}
