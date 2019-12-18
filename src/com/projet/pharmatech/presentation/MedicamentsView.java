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
    
    private Medicament medicamentSelectionne;
    
    private LigneCommande ligneARetirer;
 
    private int quantite;
    
    
    public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		System.out.println(quantite);
		this.quantite = quantite;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public LigneCommande getLigneARetirer() {
		return ligneARetirer;
	}


	public void setLigneARetirer(LigneCommande ligneARetirer) {
		this.ligneARetirer = ligneARetirer;
	}


	@PostConstruct
    public void init() {
    	 commandeService= new CommandeService();
    	 filteredMedicaments=new ArrayList<>();
    	 medicamentService=new MedicamentService();
    	 medicaments = new ArrayList<>();
    	 panier= new ArrayList<>();
    	 commande= new Commande();
    	 medicamentSelectionne= new Medicament();
    	 
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
		this.panier.clear();
		this.panier.addAll(panier==null?(new ArrayList<LigneCommande>()):(panier));
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


	public void addLigneCommande(Medicament m, int q) {
		LigneCommande ligneCommande = new LigneCommande(m,q,this.commande);
		this.panier.add(ligneCommande);
	}
	
	public void validerCommande() {
		this.commandeService.add(this.commande);
	}
	
	public void annulerCommande() {
		this.panier.clear();
		this.commande= new Commande();
	}
	public void retirerDuPanier() {
		panier.remove(this.ligneARetirer);
	}
	public void ajouterAuPanier() {
			if(!(medicamentSelectionne.getQuantiteStock()<quantite) && quantite>0) {
				
				final int q = panier.stream().filter(l->l.getMedicament()==medicamentSelectionne).mapToInt(l->l.getQuantite()).sum();
				if(q==0) {
					LigneCommande lc= new LigneCommande(this.medicamentSelectionne, quantite, commande);
					panier.add(lc);
				}else {
					
					System.out.println(q+quantite);
					panier.stream().filter(t->t.getMedicament()==medicamentSelectionne).forEach(t->t.setQuantite(q+quantite));
					
				}
				
				
			}
  	}
	
	
}
