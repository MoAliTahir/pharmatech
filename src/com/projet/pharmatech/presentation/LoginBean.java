package com.projet.pharmatech.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.pharmatech.services.UserService;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	public boolean isLogged = false;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		UserService userService = new UserService();
		
		System.out.println(userService.login(userName, password));
		this.isLogged = true;
		return "acceuil.jsp?faces-redirect=true";
	}
	
	public String logout() {
		System.out.println("Logging out...");
		this.isLogged = false;
		
		return "login.jsp?faces-redirect=true";
	}
	
	
	
}
