package com.projet.pharmatech.services;

import java.io.Serializable;


import java.util.List;

import com.projet.pharmatech.daoImpl.CommandeDaoImpl;
import com.projet.pharmatech.entities.Commande;

public class CommandeService implements Serializable{
	/**
	 * 
	 */
	MedicamentService medicamentService = new MedicamentService();
	private static final long serialVersionUID = 1L;
	CommandeDaoImpl commandeDao = new CommandeDaoImpl();
	
	public Commande add(Commande c) {
		c.getLignesCommande().stream().
		forEach(m ->
		{
			medicamentService.findById(m.getMedicament().getId()).setQuantiteStock(m.getMedicament().getQuantiteStock()-m.getQuantite());
											medicamentService.update(medicamentService.findById(m.getMedicament().getId()));
												} );
		
		return commandeDao.add(c);
	};
	
	public Commande update(Commande u) {
		return commandeDao.update(u);
	}

	public void delete(int id) {
		commandeDao.delete(id);			
	}

	
	public List<Commande> findAll() {
		return commandeDao.findAll();
	}

	public Commande findById(int id) {
		return commandeDao.findById(id);
	}

	public List<Commande> getAllMedicaments() {
		return commandeDao.findAll();
	}

}
