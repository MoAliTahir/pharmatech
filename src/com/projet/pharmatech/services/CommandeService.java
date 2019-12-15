package com.projet.pharmatech.services;

import java.util.List;

import com.projet.pharmatech.daoImpl.CommandeDaoImpl;
import com.projet.pharmatech.entities.Commande;


public class CommandeService {
	
	CommandeDaoImpl commandeDao = new CommandeDaoImpl();
	
	Commande add(Commande c){
		return commandeDao.add(c);
	}
	
	Commande update(Commande c) {
		return commandeDao.update(c);
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

}
