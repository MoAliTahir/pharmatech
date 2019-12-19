package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.projet.pharmatech.entities.User;
import com.projet.pharmatech.services.UserService;

@ManagedBean(name = "gestionUsers")
@RequestScoped
public class GestionUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
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
		if (this.id == 0) {
			
			Iterator iterator = this.users.iterator();
			boolean loginExists = false;
			while (iterator.hasNext()) {
				User user = (User) iterator.next();
				if(user.getLogin().equalsIgnoreCase(this.login))
				{
					loginExists = true;
					break;
				}
			}
			
			if(loginExists)
			{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Nom d'utilisateur existe déjà.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}else
			{
				User u = userService.add(new User(nom, prenom, login, pass1, tel, role));
				this.users.add(u);

				setToNull();
				
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Utilisateur ajouté avec sussès");
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}
			
		}else
		{
			User u = userService.findById(this.getId());
			
			u.setLogin(this.getLogin());
			u.setNom(this.getNom());
			u.setPrenom(this.getNom());
			u.setPassword(this.getPass1());
			u.setRole(this.getRole());
			u.setTel(this.getTel());
			userService.update(u);
			
			this.init();
			setToNull();
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Utilisateur modifié avec sussès");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
	}


	public void getUserInfo(User u)
	{
		this.setId(u.getId());
		this.setLogin(u.getLogin());
		this.setNom(u.getNom());
		this.setPrenom(u.getPrenom());
		this.setRole(u.getRole());
		this.setPass1(u.getPassword());
		this.setPass2(u.getPassword());
		this.setTel(u.getTel());
	}
	
	public void setToNull() {
		this.setId(0);
		this.setNom(null);
		this.setPrenom(null);
		this.setLogin(null);
		this.setRole(null);
		this.setPass1(null);
		this.setPass2(null);
		this.setTel(null);
	}



}
