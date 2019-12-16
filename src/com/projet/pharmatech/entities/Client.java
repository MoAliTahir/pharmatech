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
	@Column(name = "client_abonne")
	boolean clientAbonne = false;
	
	@OneToMany(targetEntity = Commande.class, mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	List<Commande> commandes;
	
	
	
	
	public Client() {
		super();
		this.commandes = new ArrayList<Commande>();
	}
	
	
	public Client(String nom, String prenom, boolean clientAbonne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.clientAbonne = clientAbonne;
		this.commandes = new ArrayList<Commande>();
	}




	public Client(String nom, String prenom, boolean clientAbonne, List<Commande> commandes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.clientAbonne = clientAbonne;
		this.commandes = commandes;
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

	public boolean isClientAbonne() {
		return clientAbonne;
	}
	public void setClientAbonne(boolean clientAbonne) {
		this.clientAbonne = clientAbonne;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
	
	
}
