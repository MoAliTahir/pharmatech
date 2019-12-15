package com.projet.pharmatech.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="RouterBean")
@SessionScoped
public class RouterBean {

	public String gotoIndex(){
  			return "index";
 	}
}
