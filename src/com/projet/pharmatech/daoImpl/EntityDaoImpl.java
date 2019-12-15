package com.projet.pharmatech.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;

import com.projet.pharmatech.utils.HibernateUtil;

public abstract class EntityDaoImpl<E> {
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
		E u = (E) session.save(e);
		session.getTransaction().commit();
		return u;
	}

	
	public E update(E e) {
		session.beginTransaction();
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
