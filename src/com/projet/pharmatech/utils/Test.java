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
import com.projet.pharmatech.daoImpl.UserDaoImpl;
import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.entities.Commande;
import com.projet.pharmatech.entities.LigneCommande;
import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.entities.User;

public class Test {

	
	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
		session.createQuery("select o from User o").list();
		
		UserDaoImpl userDao = new UserDaoImpl();
		ClientDaoImpl clientDao = new ClientDaoImpl();
		/*
		userDao.add(new User("Tahir", "Ali", "ali", "ali", "0681920973", "pharmacien"));
		
		
		clientDao.add(new Client("BK", "Tariq", false));
		clientDao.add(new Client("MLFI", "Amine", true));*/
			
		
		MedicamentDaoImpl medDao = new MedicamentDaoImpl();
		//medDao.add(new Medicament("Doliprane", "comprimé", "Fournisseur 1", 25, 150, "Une description", LocalDate.now() , LocalDateTime.of(2022, 05, 22, 00, 00)));
		//medDao.add(new Medicament("Rinomicine", "sachet", "Fournisseur 2", 20, 100, "Une description", LocalDate.now() , LocalDateTime.of(2021, 07, 01, 23, 59)));
		//medDao.add(new Medicament("Paracetamol", "comprimé", "Fournisseur 1", 15, 250, "Une description", LocalDate.now() , LocalDateTime.of(2022, 02, 28, 23, 59)));
		CommandeDaoImpl comDao = new CommandeDaoImpl();
		
		Commande commande = comDao.findById(6);
		
		//ArrayList<LigneCommande> lignes = new ArrayList<LigneCommande>();
		//lignes.add(new LigneCommande(medDao.findById(1), 2, commande));
		//lignes.add(new LigneCommande(medDao.findById(2), 1, commande));
		//lignes.add(new LigneCommande(medDao.findById(3), 4, commande));
		
		
		//commande.setLignesCommande(lignes);
		//commande.setClient(clientDao.findById(1));
		//commande.setPrixTotal(2*25+20+4*15);
		//comDao.update(commande);
		
		System.out.println(commande.getLignesCommande().size());
		
		
		/*CommandeDaoImpl commDaoImpl = new CommandeDaoImpl();
		Commande co = commDaoImpl.add(new Commande());
		LigneCommandeDaoImpl lignDao = new LigneCommandeDaoImpl();
		lignDao.add(new LigneCommande(medDao.findById(1), 5, co));
		lignDao.add(new LigneCommande(medDao.findById(3), 2, co));
		lignDao.add(new LigneCommande(medDao.findById(4), 3, co));
		ArrayList<LigneCommande> lignes = new ArrayList<LigneCommande>();
		lignes.add(new LigneCommande(new Medicament(), 2, ));
		
		
		commDaoImpl.add(new Commande());
		ClientDaoImpl cd = new ClientDaoImpl();
		
		co.setLignesCommande(lignDao.findAll());
		co.setClient(cd.findById(1));
		co.setPrixTotal(5*25+2*20+3*15);
		commDaoImpl.update(co);*/
	
	}

}
