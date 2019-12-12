package com.projet.pharmatech.utils;

import org.hibernate.Session;

import com.projet.pharmatech.entities.User;

public class Test {

	
	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
		session.createQuery("select o from User o").list();
		
		session.createQuery("select o from Medicament o").list();

		/*UserDAOImpl dao = new UserDAOImpl();*/
		
		User user = new User();
		user.setNom("Tahir");
		user.setPrenom("Mohamed");
		user.setLogin("aliTahir");
		
		//dao.add(user);
		
		System.out.println("++++++++"+user.getNom());
		
		
	}

}
