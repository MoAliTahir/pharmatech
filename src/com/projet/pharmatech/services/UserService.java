package com.projet.pharmatech.services;

import java.util.List;

import com.projet.pharmatech.daoImpl.UserDaoImpl;
import com.projet.pharmatech.entities.User;

public class UserService {
		UserDaoImpl userDao = new UserDaoImpl();
		
		User add(User u) {
			return userDao.add(u);
		}
		
		public User update(User u) {
			return userDao.update(u);
		}


		public void delete(int id) {
			userDao.delete(id);			
		}

		
		public List<User> findAll() {
			return userDao.findAll();
		}

		public User findById(int id) {
			return userDao.findById(id);
		}
		
		public User login(String userName, String password) {
			return userDao.login(userName, password);
		}
}
