package com.projet.pharmatech.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="client")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String nom;
	String prenom;
	boolean client_abonne;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isClient_abonne() {
		return client_abonne;
	}
	public void setClient_abonne(boolean client_abonne) {
		this.client_abonne = client_abonne;
	}
	
	
	
	
}
