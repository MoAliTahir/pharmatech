package com.projet.pharmatech.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class LigneCommande {
	
    public LigneCommande(Commande cmd) {
    	dateAjout = new Date();
    	setCommande(cmd);
    }
    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicament")
	private Medicament medicament;
	@ManyToOne
	private Commande commande;
	private int quantite;
	private Date dateAjout;
	
	public int getId() {
		return id;
	}
	public int getQuantite() {
		return quantite;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
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
