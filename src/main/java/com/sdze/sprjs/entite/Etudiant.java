package com.sdze.sprjs.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String email;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Etudiant(String login, String email, String password) {
		super();
		this.login = login;
		this.email = email;
		this.password = password;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
