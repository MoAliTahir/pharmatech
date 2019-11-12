package com.projet.pharmatech.utils;

import org.hibernate.Session;

public class Test {

	
	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
		session.createQuery("select o from User o").list();
		
		session.createQuery("select o from Medicament o").list();

	}

}
