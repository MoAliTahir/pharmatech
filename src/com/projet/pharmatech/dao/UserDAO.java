package com.projet.pharmatech.dao;

import java.util.List;

import com.projet.pharmatech.entities.User;


public interface UserDAO {
	
	public void add(User user);
	
	public User update(User user);
	
	public void delete(Long id);
	
	public List<User> findAll();
	
	public User findById(Long id);
}
