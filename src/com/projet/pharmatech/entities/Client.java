package com.projet.pharmatech.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
		
	@OneToMany(targetEntity = Commande.class, mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	List<Commande> commandes;
	private String CNE;
	
	
	
	
	public Client() {
		super();
		this.commandes = new ArrayList<Commande>();
	}
	
	
	public Client(String nom, String prenom, String CNE) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.CNE=CNE;
 		this.commandes = new ArrayList<Commande>();
	}




	public Client(String nom, String prenom, List<Commande> commandes, String CNE) {
		super();
		this.nom = nom;
		this.prenom = prenom;
 		this.commandes = commandes;
 		this.CNE=CNE;
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

	public String getCNE() {
		return CNE;
	}


	public void setCNE(String cNE) {
		CNE = cNE;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
	
	
}
