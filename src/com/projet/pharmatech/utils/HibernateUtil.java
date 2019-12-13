package com.projet.pharmatech.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.projet.pharmatech.entities.Medicament;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFact();
    //private static ServiceRegistry serviceRegistry;

 private static SessionFactory buildSessionFact() {
  try {

   return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Medicament.class).buildSessionFactory();

    
  } catch (Throwable ex) {
  
   System.err.println("Initial SessionFactory creation failed." + ex);
   throw new ExceptionInInitializerError(ex);
  }
 }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session openSession(){
     return sessionFactory.openSession();
    }
    
    public Session getCurrentSession(){
     return sessionFactory.getCurrentSession();
    }
    
    public static void close(){
     if(sessionFactory != null){
      sessionFactory.close();
     }
     sessionFactory = null;
    }
}