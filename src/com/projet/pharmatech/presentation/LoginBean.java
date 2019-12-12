package com.projet.pharmatech.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.projet.pharmatech.entities.User;
import com.projet.pharmatech.services.UserService;
import com.projet.pharmatech.utils.SessionUtil;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
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
		User user = userService.login(userName, password);
  		if (user != null) {
			System.out.println("Logging In...");
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("authUser", user);
			session.setAttribute("isAdmin", user.getRole().equals("admin"));
			if(user.getRole().equals("admin"))
				return "/admin/acceuil.xhtml?faces-redirect=true";
			return "acceuil.xhtml?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(
							FacesMessage.SEVERITY_WARN, 
							"Incorrect Username and Passowrd", 
							"Please enter correct username and Password"
							)
					);
			return "login.jsp?faces-redirect=true";
		}
	}
	
	public String logout() {
		System.out.println("Logging out...");
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		
		return "login.xhtml?faces-redirect=true";
	}
	
	
	
}
