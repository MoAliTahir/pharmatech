package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.services.ClientService;
import com.projet.pharmatech.services.CommandeService;
import com.projet.pharmatech.services.MedicamentService;

@ManagedBean(name = "facturesBean")
@RequestScoped
public class FacturesBean implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		private List<Commande> commandes;
		private Commande selectedCommande;
		

		
		private CommandeService commandeService = new CommandeService();
		private MedicamentService medService = new MedicamentService();
		
		
		
		@PostConstruct
		public void init() {
			commandes = commandeService.findAll();
		
		}
		public List<Commande> getCommandes() {
			return commandes;
		}

		public void setCommandes(List<Commande> commandes) {
			this.commandes = commandes;
		}
		
		public Commande getSelectedCommande() {
			return selectedCommande;
		}
		public void setSelectedCommande(Commande selectedCommande) {
			this.selectedCommande = selectedCommande;
		}
		
		
		@SuppressWarnings("deprecation")
		public double getTotalPrice(Integer day) {
			double result =0;
			Iterator iterator = this.getCommandes().iterator();
			
			while (iterator.hasNext()) {
				Commande commande = (Commande) iterator.next();
				if(commande.getDateAjout().getDay() == day)
					result += commande.getPrixTotal();
			}
			
	        return result;
	    }
		
		
		public String getMedName(int id) {
			return medService.findById(id).getLibelle();
		}
}
