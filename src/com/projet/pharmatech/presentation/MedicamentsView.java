package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.entities.LigneCommande;
import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.services.CommandeService;
import com.projet.pharmatech.services.MedicamentService;

@ManagedBean(name="MedicamentsBean")
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
    
    private Medicament medicamentSelectionne;
    
    private int quantiteSelectionne;
    
    private Medicament medicamentARetirer;
    
 
    @PostConstruct
    public void init() {
    	 commandeService= new CommandeService();
    	 filteredMedicaments=new ArrayList<>();
    	 medicamentService=new MedicamentService();
    	 medicaments = new ArrayList<>();
    	 panier= new ArrayList<>();
    	 commande= new Commande();
    	 medicamentSelectionne= new Medicament();
    	 medicamentARetirer=new Medicament();
    	 
    	 Medicament m = new Medicament();
    	 m.setLibelle("Ali zefi");
    	 
    	 LigneCommande lc= new LigneCommande(m, 2, commande);
    	 
    	 panier.add(lc);
    	 	
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
                || Math.abs(Medicament.getQuantiteStock()-filterInt)<5
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
    
	
	public List<LigneCommande> getPanier() {
		return panier;
	}


	public Commande getCommande() {
		return commande;
	}


	public CommandeService getCommandeService() {
		return commandeService;
	}


	public void setPanier(List<LigneCommande> panier) {
		this.panier = panier;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public void setCommandeService(CommandeService commandeService) {
		this.commandeService = commandeService;
	}

	

	public Medicament getMedicamentSelectionne() {
		return medicamentSelectionne;
	}


	public void setMedicamentSelectionne(Medicament medicamentSelectionne) {
		this.medicamentSelectionne = medicamentSelectionne;
	}
	
	

	public int getQuantiteSelectionne() {
		return quantiteSelectionne;
	}


	public void setQuantiteSelectionne(int quantiteSelectionne) {
		this.quantiteSelectionne = quantiteSelectionne;
	}


	public void addLigneCommande(Medicament m, int q) {
		LigneCommande ligneCommande = new LigneCommande(m,q,this.commande);
		this.panier.add(ligneCommande);
	}
	
	
	public Medicament getMedicamentARetirer() {
		return medicamentARetirer;
	}


	public void setMedicamentARetirer(Medicament medicamentARetirer) {
		this.medicamentARetirer = medicamentARetirer;
	}


	public void validerCommande() {
		this.commandeService.add(this.commande);
	}
	
	public void annulerCommande() {
		this.panier.clear();
		this.commande= new Commande();
	}
	
	public void ajouterAuPanier() {
 		System.out.println("selectioné : "+this.medicamentSelectionne.getLibelle());
    	 
   	 	LigneCommande lc= new LigneCommande(this.medicamentSelectionne, this.quantiteSelectionne, commande);
   	 
   	 	panier.add(lc);
   	 	System.out.println("added----------------");
 	}
	
	public void retirerDuPanier() {
		panier=panier.stream().filter(t->t.getMedicament()!=medicamentARetirer).collect(Collectors.toList());
	}
	
    
}
