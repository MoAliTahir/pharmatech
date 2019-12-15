package com.projet.pharmatech.services;

import java.util.List;

import com.projet.pharmatech.daoImpl.MedicamentDaoImpl;
import com.projet.pharmatech.entities.Medicament;

public class MedicamentService {
	MedicamentDaoImpl medicamentDao = new MedicamentDaoImpl();
	
	Medicament add(Medicament u) {
		return medicamentDao.add(u);
	};
	
	public Medicament update(Medicament u) {
		return medicamentDao.update(u);
	}


	public void delete(int id) {
		medicamentDao.delete(id);			
	}

	
	public List<Medicament> findAll() {
		return medicamentDao.findAll();
	}

	public Medicament findById(int id) {
		return medicamentDao.findById(id);
	}

	public List<Medicament> getAllMedicaments() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++ HERE IN MEDIC REPO");

		return medicamentDao.findAll();
	}
}
