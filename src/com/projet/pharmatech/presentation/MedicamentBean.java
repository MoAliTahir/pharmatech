package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="medicamentBean")
@SessionScoped
public class MedicamentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public MedicamentBean() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String libelle;
	private String categorie;
	private double prix;
	private int quantite_stock;
	private String description;
	private Date date_ajout;
	private LocalDateTime date_temps_peremtion;

	public void ajouterAuPanier() {
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println("-- TIME TO CELEBRATE!--");
		System.out.println("-----------------------");
		System.out.println("-----------------------");
	}
	public long getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public String getCategorie() {
		return categorie;
	}
	public double getPrix() {
		return prix;
	}
	public int getQuantite_stock() {
		return quantite_stock;
	}
	public String getDescription() {
		return description;
	}
	public Date getDate_ajout() {
		return date_ajout;
	}
	public LocalDateTime getDate_temps_peremtion() {
		return date_temps_peremtion;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}
	public void setDate_temps_peremtion(LocalDateTime date_temps_peremtion) {
		this.date_temps_peremtion = date_temps_peremtion;
	}
	
	



	
	
}
