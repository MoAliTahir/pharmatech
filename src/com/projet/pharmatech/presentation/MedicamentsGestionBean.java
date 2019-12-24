package com.projet.pharmatech.presentation;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.projet.pharmatech.entities.Medicament;

@ManagedBean(name="gestionMedicamentBean")
public class MedicamentsGestionBean {
	
	private Medicament medicament;
	private ArrayList<Medicament> medicaments;
	
}
