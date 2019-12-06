package com.projet.pharmatech.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String nom;
	String prenom;
	boolean client_abonne;
	
	
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
