package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.entities.LigneCommande;
import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.services.CommandeService;
import com.projet.pharmatech.services.MedicamentService;

@ManagedBean(name="MedicamentsViewBean")
@SessionScoped
public class MedicamentsView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Medicament> medicaments;
 
    private List<Medicament> filteredMedicaments;
    
    private List<LigneCommande> panier;
 
    private MedicamentService medicamentService;
    
    private Commande commande;
 
    private CommandeService commandeService;
    
 
    @PostConstruct
    public void init() {
    	 commandeService= new CommandeService();
    	 filteredMedicaments=new ArrayList<>();
    	 medicamentService=new MedicamentService();
    	 medicaments = new ArrayList<>();
    	 panier= new ArrayList<>();
    	 commande= new Commande();
    	 
    	 
    	 try {
           medicaments.addAll(medicamentService.getAllMedicaments());
     	 }catch(Exception e) {
     		 e.printStackTrace();
    	 }
    }

 
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();

        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
 
        Medicament Medicament = (Medicament) value;
        return 	   Medicament.getId()==filterInt
        		|| Medicament.getCategorie().toLowerCase().contains(filterText)
                || Medicament.getDescription().toLowerCase().contains(filterText)
                || (Medicament.getPerime() ? "Périmé" : "Valable").contains(filterText)
                || Medicament.getLibelle().toLowerCase().contains(filterText)
                || Math.abs(Medicament.getQuantite_stock()-filterInt)<5
                || Math.abs(Medicament.getPrix()-(double)filterInt)<5.0;
    }
 
    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
 
   
    public List<Medicament> filteredMedicaments() {
        return filteredMedicaments;
    }
 
    public void setFilteredMedicaments(List<Medicament> filteredMedicaments) {
       /* this.filteredMedicaments.clear();
        this.filteredMedicaments.addAll(filteredMedicaments);*/
    	this.filteredMedicaments=filteredMedicaments;
    }
 
    public void setService(MedicamentService service) {
        medicamentService = service;
    }


	public List<Medicament> getMedicaments() {
		return medicaments;
	}


	public List<Medicament> getFilteredMedicaments() {
		return filteredMedicaments;
	}


	public MedicamentService getMedicamentService() {
		return medicamentService;
	}


	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}


	public void setMedicamentService(MedicamentService medicamentService) {
		this.medicamentService = medicamentService;
	}
    
	public void addLigneCommande() {
		LigneCommande ligneCommande = new LigneCommande(this.commande);
		this.panier.add(ligneCommande);
	}
	
	public void validerCommande() {
		this.commandeService.add(this.commande);
	}
	
	public void annulerCommande() {
		this.panier.clear();
		this.commande= new Commande();
	}
	
	
	
    
}
