package com.projet.pharmatech.dao;

import java.util.List;

public interface GenericDao<E> {
		
		public E add(E entity);
		
		public E update(E entity);
		
		public void delete(int id);
		
		public List<E> findAll();
		
		public E findById(int id);

}
