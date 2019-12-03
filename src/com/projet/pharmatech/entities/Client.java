package com.projet.pharmatech.entities;

public class Client {
	
	int id;
	String nom;
	String prenom;
	int nombre_medicaments_achetes;
	
	
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getNombre_medicaments_achetes() {
		return nombre_medicaments_achetes;
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
	public void setNombre_medicaments_achetes(int nombre_medicaments_achetes) {
		this.nombre_medicaments_achetes = nombre_medicaments_achetes;
	}
	
	
	
	
}
