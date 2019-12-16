package com.projet.pharmatech.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.projet.pharmatech.dao.IMedicamentDao;
import com.projet.pharmatech.entities.Medicament;

public class MedicamentDaoImpl extends EntityDaoImpl<Medicament>  implements IMedicamentDao, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicament> findAll() {
		return session.createQuery("select o from Medicament o").list();
	}



}
