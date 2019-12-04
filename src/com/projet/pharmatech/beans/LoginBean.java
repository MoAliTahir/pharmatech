package com.projet.pharmatech.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	
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
	
	public String validateUserLogin(){
		if(true) {
			return "y";
		}else {
			return "n";
		}
	}
	
	
	
}
