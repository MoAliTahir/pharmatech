package com.projet.pharmatech.daoImpl;

import com.projet.pharmatech.dao.IUserDao;
import com.projet.pharmatech.entities.User;

public class UserDaoImpl extends EntityDaoImpl<User>  implements IUserDao {

	public User login(String userName, String password) {
		return (User) this.session.createQuery("select u from User u where u.login='"+userName+"' and u.password='"+password+"'").uniqueResult();
	}

}
