package com.ar.alkemy.entity;

import javax.persistence.*;

@Entity

public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column//(name = "id")
	private Integer id;

	@Column//(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;
	
	@Column//(name = "dni")
	private String dni;

	@Column//(name = "active")
	private Integer active;

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

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", active="
				+ active + "]";
	}

}
