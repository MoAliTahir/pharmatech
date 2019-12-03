package com.projet.pharmatech.services;

import java.util.List;

import com.projet.pharmatech.daoImpl.UserDaoImpl;
import com.projet.pharmatech.entities.User;

public class UserService {
		UserDaoImpl userDao = new UserDaoImpl();
		
		User add(User u) {
			return userDao.add(u);
		};
		
		public User update(User u) {
			return userDao.update(u);
		}


		public void delete(Long id) {
			userDao.delete(id);			
		}

		
		public List<User> findAll() {
			return userDao.findAll();
		}

		public User findById(Long id) {
			return userDao.findById(id);
		}
}
