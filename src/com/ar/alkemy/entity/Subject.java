package com.ar.alkemy.entity;

import javax.persistence.*;

@Entity
public class Subject {

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
	
	@Column(name = "professor_id")
	private Integer professorId;
	
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

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	

}
