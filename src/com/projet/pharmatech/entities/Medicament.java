package com.projet.pharmatech.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "medicament")
public class Medicament implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private String categorie;
	private double prix;
	private int quantite_stock;
	private String description;
	private LocalDate date_ajout;
	private LocalDateTime date_temps_peremtion=null;
	
	
	public Medicament() {
		super();
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getQuantite_stock() {
		return quantite_stock;
	}
	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(LocalDate date_ajout) {
		this.date_ajout = date_ajout;
	}
	public LocalDateTime getDate_temps_peremtion() {
		return date_temps_peremtion;
	}
	public void setDate_temps_peremtion(LocalDateTime date_temps_peremtion) {
		this.date_temps_peremtion = date_temps_peremtion;
	}



	public boolean getPerime() {
		LocalDateTime now = LocalDateTime.now();
		if(date_temps_peremtion==null) {
			return false;
		}
		return now.compareTo(this.date_temps_peremtion)>0;
	}
	
	
	

}
