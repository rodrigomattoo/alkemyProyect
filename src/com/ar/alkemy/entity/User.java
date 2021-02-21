package com.ar.alkemy.entity;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String dni;

	@Column
	private String file;

	@Column(name = "user_type")
	private String userType;

	public User() {
	}

	public User(String dni, String file, String userType) {
		this.dni = dni;
		this.file = file;
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", dni=" + dni + ", file=" + file + ", userType=" + userType + "]";
	}

	
	
	

}
