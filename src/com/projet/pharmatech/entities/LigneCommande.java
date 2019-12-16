package com.projet.pharmatech.entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
	
	@Entity
	@Table(name="ligne_commande")
	public class LigneCommande implements Serializable {
      
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "medicament_id")
	private Medicament medicament;
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;
	
	
	
	
	public LigneCommande() {
	   	super();
	}
	
	
	public LigneCommande(Medicament medicament, int quantite, Commande commande) {
		super();
		this.medicament = medicament;
		this.quantite = quantite;
		this.commande = commande;
	}





	public int getId() {
		return id;
	}
	public int getQuantite() {
		return quantite;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
}
