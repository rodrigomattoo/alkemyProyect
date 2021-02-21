package com.ar.alkemy.entity;

import java.util.List;

import javax.persistence.*;

@Entity

public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, nullable = true)
	private Integer id;
	@Column
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column
	private String dni;
	@Column
	private Integer active;
	
	private String fullName;
			
	public Professor() {
	}

	public Professor(String name, String lastName, String dni, Integer active) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.active = active;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFullName() {
		return this.name +" "+ this.lastName;
	}
}
