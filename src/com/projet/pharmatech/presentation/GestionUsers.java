package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import com.projet.pharmatech.entities.User;
import com.projet.pharmatech.services.UserService;

@ManagedBean(name = "gestionUsers")
public class GestionUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	private String login;
	private String tel;
	private String role;
	private String pass1;
	private String pass2;

	private List<User> users;
	
	UserService userService = new UserService();
	
	
	@PostConstruct
    public void init() {
        setUsers(userService.findAll());
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
	
	
	public String getPass1() {
		return pass1;
	}




	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}




	public String getPass2() {
		return pass2;
	}




	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}




	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser() {
		User u = userService.add(new User(nom, prenom, login, pass1, tel, role));
		this.users.add(u);
		this.nom = null;
		this.prenom = null;
		this.login = null;
		this.pass1 = null;
		this.pass2 = null;
		this.tel = null;
	}

}
