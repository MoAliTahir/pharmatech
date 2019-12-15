package com.projet.pharmatech.daoImpl;

import java.util.List;

import com.projet.pharmatech.dao.IUserDao;
import com.projet.pharmatech.entities.User;

public class UserDaoImpl extends EntityDaoImpl<User>  implements IUserDao {

	public User login(String userName, String password) {
		return (User) this.session.createQuery("select u from User u where u.login='"+userName+"' and u.password='"+password+"'").uniqueResult();
	}

	@Override
	public List<User> findAll() {
		return session.createQuery("select u from User u").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
