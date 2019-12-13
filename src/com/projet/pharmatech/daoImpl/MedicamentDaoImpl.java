package com.projet.pharmatech.daoImpl;

import java.util.List;

import com.projet.pharmatech.dao.IMedicamentDao;
import com.projet.pharmatech.entities.Medicament;

public class MedicamentDaoImpl extends EntityDaoImpl<Medicament>  implements IMedicamentDao {


	@Override
	public List<Medicament> findAll() {
		return session.createQuery("select o from Medicament o").list();
	}

}
