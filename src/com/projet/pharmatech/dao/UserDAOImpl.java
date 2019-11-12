package com.projet.pharmatech.dao;

import java.util.List;

import org.hibernate.Session;

import com.projet.pharmatech.dao.entities.User;
import com.projet.pharmatech.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO{

	Session session = HibernateUtil.openSession();
	
	@Override
	public User add(User user) {
		session.beginTransaction();
		User u = (User) session.save(user);
		session.getTransaction().commit();
		return u;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
