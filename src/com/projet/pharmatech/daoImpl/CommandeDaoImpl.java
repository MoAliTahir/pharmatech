package com.projet.pharmatech.daoImpl;

import java.util.List;

import com.projet.pharmatech.entities.Commande;

public class CommandeDaoImpl extends EntityDaoImpl<Commande> {

	@Override
	public List<Commande> findAll() {
		return session.createQuery("select c from Commande c").list();
	}
	
	
}
