package com.projet.pharmatech.dao;

import java.util.List;

import org.hibernate.Session;

import com.projet.pharmatech.dao.entities.User;
import com.projet.pharmatech.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO{

	Session session = HibernateUtil.openSession();
	
	@Override
	public void add(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

	@Override
	public User update(User user) {
		session.beginTransaction();
		User u = (User) session.merge(user);
		session.getTransaction().commit();
		return u;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		User u = findById(id);
		session.delete(u);
		session.getTransaction().commit();
		
	}

	@Override
	public List<User> findAll() {
		return session.createQuery("select o from User o").list();
	}

	@Override
	public User findById(Long id) {
		return session.find(User.class, id);
	}

}
