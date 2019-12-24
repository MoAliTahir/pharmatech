package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.services.MedicamentService;

@ManagedBean(name="gestionMedicamentBean")
@ViewScoped
public class MedicamentsGestionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Medicament medicament;
	private List<Medicament> medicaments;
	private MedicamentService medicamentService;
	
	@PostConstruct
	private void init() {
		medicament = new Medicament();
		medicamentService= new MedicamentService();
		medicaments=medicamentService.findAll();
	}
	
	public MedicamentsGestionBean() {
		medicament = new Medicament();
		medicamentService= new MedicamentService();
		medicaments=medicamentService.findAll();
 	}
	
	
	public void addMed() {
		
		if(medicamentService.findById(medicament.getId())!=null) {
			   this.medicamentService.update(medicament);
			}
			else {
				   this.medicamentService.save(medicament);
			}
			medicament= new Medicament();
	}
	

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(ArrayList<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public MedicamentService getMedicamentService() {
		return medicamentService;
	}

	public void setMedicamentService(MedicamentService medicamentService) {
		this.medicamentService = medicamentService;
	}
	
	public void reset() {
		this.medicament= new Medicament();
	}
	
	public void setMed(Medicament m) {
		medicament=m;
	}
	
	public void update(Medicament m) {
		medicamentService.update(m);
	}
	
	public void delete(Medicament m) {
		medicamentService.delete(m.getId());
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	
}
