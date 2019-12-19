package com.projet.pharmatech.entities;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projet.pharmatech.services.MedicamentService;

@Entity
@Table(name="commande")
public class Commande implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(targetEntity = LigneCommande.class, fetch = FetchType.EAGER, mappedBy="commande", cascade = CascadeType.ALL)
	private List<LigneCommande> lignesCommande;
	@Column(name = "date_ajout")
	private Date dateAjout;
	@Column(name = "prix_total")
	private double prixTotal;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	
	
	public Commande() {
		super();
		dateAjout = new Date();
		this.lignesCommande = new ArrayList<LigneCommande>();
	}
	
	
	public Commande(List<LigneCommande> lignesCommande, Client client, double prixTotal) {
		super();
		this.lignesCommande = lignesCommande;
		this.dateAjout = new Date();
		this.client = client;
		this.prixTotal = prixTotal;
	}


	public int getId() {
		return id;
	}
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
 	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
 		this.lignesCommande=lignesCommande;
	}
 	//To be removed >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void AddListToLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande.addAll(lignesCommande);
	}
	public void AddElementToLignesCommande(LigneCommande lignesCommande) {
		this.lignesCommande.clear();
		this.lignesCommande.add(lignesCommande);
	}
	
	//Till here <<<<<<<<<<<<<<<<<<<<<<<<<<
		
	public Date getDateAjout() {
		return dateAjout;
	}
	
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


	public double getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
}
