package com.projet.pharmatech.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;

import com.projet.pharmatech.utils.HibernateUtil;

public abstract class EntityDaoImpl<E>  {
	Session session = HibernateUtil.openSession();
	private Class<E> type;
	
	@SuppressWarnings("unchecked")
	EntityDaoImpl(){
		Type  t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t ;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	public E add(E e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		
		String className = e.getClass().getSimpleName();
		@SuppressWarnings("unchecked")
		E u = (E) session.createQuery("select o from "+ className +" o where o.id = (select max(e.id) from "+ className + " e)").uniqueResult();
		
		return u;
	}

	
	public E update(E e) {
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		E u = (E) session.merge(e);
		session.getTransaction().commit();
		return u;
	}


	public void delete(int id) {
		session.beginTransaction();
		E u = findById(id);
		session.delete(u);
		session.getTransaction().commit();
		
	}

	
	public abstract List<E> findAll();
	
	public E findById(int id) {
		return session.find(type, id);
		//TODO: Check
	}
}
