package com.projet.pharmatech.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String tel;
	private String role;
	
	
	
	public User() {
		super();
	}
	
	
	
	public User(String nom, String prenom, String login, String password, String tel, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.tel = tel;
		this.role = role;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
