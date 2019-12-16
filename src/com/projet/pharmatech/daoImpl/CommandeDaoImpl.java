package com.projet.pharmatech.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.projet.pharmatech.dao.ICommandeDao;
import com.projet.pharmatech.entities.Commande;

 public class CommandeDaoImpl extends EntityDaoImpl<Commande> implements ICommandeDao, Serializable{

	@SuppressWarnings("unchecked")
 	@Override
	public List<Commande> findAll() {
		return session.createQuery("select c from Commande c").list();
	}

}
