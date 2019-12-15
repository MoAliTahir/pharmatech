package com.projet.pharmatech.entities;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(targetEntity = LigneCommande.class, fetch = FetchType.LAZY, mappedBy="commande", cascade = CascadeType.DETACH)
	private List<LigneCommande> lignesCommande;
	private Date dateAjout;
	private long prixTotal;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	
	
	public Commande() {
		super();
		dateAjout = new Date();
		this.lignesCommande = new ArrayList<LigneCommande>();
	}
	
	
	public Commande(List<LigneCommande> lignesCommande, Client client, long prixTotal) {
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
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	
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


	public long getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(long prixTotal) {
		this.prixTotal = prixTotal;
	}
}
