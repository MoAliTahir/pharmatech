package com.projet.pharmatech.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicament")
public class Medicament implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private String categorie;
	private String fournisseur;
	private double prix;
	private int quantiteStock;
	private String description;
	private LocalDate dateAjout;
	private LocalDateTime datePeremtion=null;
	
	
	public Medicament() {
		super();
	}
	
	
	
	public Medicament(String libelle, String categorie, String fournisseur, double prix, int quantiteStock,
			String description, LocalDate dateAjout, LocalDateTime datePeremtion) {
		super();
		this.libelle = libelle;
		this.categorie = categorie;
		this.fournisseur = fournisseur;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		this.description = description;
		this.dateAjout = dateAjout;
		this.datePeremtion = datePeremtion;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantite_stock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(LocalDate dateAjout) {
		this.dateAjout = dateAjout;
	}
	public LocalDateTime getDatePeremtion() {
		return datePeremtion;
	}
	public void setDatePeremtion(LocalDateTime datePeremtion) {
		this.datePeremtion = datePeremtion;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public boolean getPerime() {
		LocalDateTime now = LocalDateTime.now();
		if(datePeremtion==null) {
			return false;
		}
		return now.compareTo(this.datePeremtion)>0;
	}




	
	
	

}
