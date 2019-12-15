package com.projet.pharmatech.utils;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.Session;

import com.projet.pharmatech.daoImpl.ClientDaoImpl;
import com.projet.pharmatech.daoImpl.CommandeDaoImpl;
import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.entities.LigneCommande;
import com.projet.pharmatech.entities.Medicament;

public class Test {

	
	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
		session.createQuery("select o from User o").list();
		
		session.createQuery("select o from Medicament o").list();
		
		/*UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User("Tahir", "Ali", "ali", "ali", "0681920973", "pharmacien");
		
		
		userDao.add(user);*/
		CommandeDaoImpl comDao = new CommandeDaoImpl();
		ArrayList<LigneCommande> lComm = new ArrayList<LigneCommande>();
		Medicament medicament = new Medicament("Doliprane", "Comprimé", "Ahmed Fournisseur", 25, 50, "Description doli", null, null);
		Commande commandSearch = comDao.findById(1);
		LigneCommande ligneCommande = new LigneCommande(
				medicament, 3, commandSearch
				);
		lComm.add(
				ligneCommande
				);
		
		//Commande cmdf = new Commande();
		//comDao.add(cmdf);
		Client client = new Client("Tb", "Amine", false);
		ClientDaoImpl cd = new ClientDaoImpl();
		cd.add(client);
		Commande cmdUpdated = new Commande(lComm, client, 75);
		Commande cm = comDao.update(cmdUpdated);
		
		
		
		
	}

}
