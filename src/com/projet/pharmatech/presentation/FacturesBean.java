package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.services.CommandeService;

@ManagedBean(name = "facturesBean")
@RequestScoped
public class FacturesBean implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		private List<Commande> commandes;

		
		private CommandeService commandeService = new CommandeService();
		
		
		
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
}
