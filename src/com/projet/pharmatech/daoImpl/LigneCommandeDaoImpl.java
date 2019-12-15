package com.projet.pharmatech.daoImpl;

import java.util.List;


import com.projet.pharmatech.dao.ILigneCommandeDao;
import com.projet.pharmatech.entities.LigneCommande;

public class LigneCommandeDaoImpl extends EntityDaoImpl<LigneCommande> implements ILigneCommandeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> findAll() {
		return session.createQuery("select l from LigneCommande l").list();
	}

}
