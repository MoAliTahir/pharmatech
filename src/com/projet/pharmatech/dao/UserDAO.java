package com.projet.pharmatech.dao;

import java.util.List;

import com.projet.pharmatech.dao.entities.User;

public interface UserDAO {
	
	public User add(User user);
	
	public User update(User user);
	
	public void delete(User user);
	
	public List<User> findAll();
}
