package com.projet.pharmatech.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.Session;

import com.projet.pharmatech.daoImpl.ClientDaoImpl;
import com.projet.pharmatech.daoImpl.CommandeDaoImpl;
import com.projet.pharmatech.daoImpl.LigneCommandeDaoImpl;
import com.projet.pharmatech.daoImpl.MedicamentDaoImpl;
import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.entities.LigneCommande;
import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.entities.User;

public class Test {

	
	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
		session.createQuery("select o from User o").list();
		
		/*
		
		CommandeDaoImpl commDao = new CommandeDaoImpl();
		List<Commande> commandes = commDao.findAll();
		
		Iterator iterator = commandes.iterator();
		
		while (iterator.hasNext()) {
			Commande object = (Commande) iterator.next();
			System.out.println("Commande: --> Prix: " + object.getPrixTotal());
			
			Iterator iterator2 = object.getLignesCommande().iterator();
			
			while (iterator2.hasNext()) {
				LigneCommande object2 = (LigneCommande) iterator2.next();
				
				System.out.println("Ligne de commande : Quantite ++> " + object2.getQuantite());
			}
			
		}
		*/
		/*UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User("Tahir", "Ali", "ali", "ali", "0681920973", "pharmacien");
		
		
		userDao.add(user);*/
		/*
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
		Commande cm = comDao.update(cmdUpdated);*/
		
		MedicamentDaoImpl medDao = new MedicamentDaoImpl();
		//medDao.add(new Medicament("Doliprane", "comprimé", "Fournisseur 1", 25, 150, "Une description", LocalDate.now() , LocalDateTime.of(2022, 05, 22, 00, 00)));
		//medDao.add(new Medicament("Rinomicine", "sachet", "Fournisseur 2", 20, 100, "Une description", LocalDate.now() , LocalDateTime.of(2021, 07, 01, 23, 59)));
		//medDao.add(new Medicament("Paracetamol", "comprimé", "Fournisseur 1", 15, 250, "Une description", LocalDate.now() , LocalDateTime.of(2022, 02, 28, 23, 59)));
		CommandeDaoImpl commDaoImpl = new CommandeDaoImpl();
		Commande co = commDaoImpl.add(new Commande());
		LigneCommandeDaoImpl lignDao = new LigneCommandeDaoImpl();
		lignDao.add(new LigneCommande(medDao.findById(1), 5, co));
		lignDao.add(new LigneCommande(medDao.findById(3), 2, co));
		lignDao.add(new LigneCommande(medDao.findById(4), 3, co));
		
		
		ClientDaoImpl cd = new ClientDaoImpl();
		
		co.setLignesCommande(lignDao.findAll());
		co.setClient(cd.findById(1));
		co.setPrixTotal(5*25+2*20+3*15);
		commDaoImpl.update(co);
	
	}

}
