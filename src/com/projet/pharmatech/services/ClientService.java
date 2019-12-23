package com.projet.pharmatech.services;

import java.util.List;

import com.projet.pharmatech.daoImpl.ClientDaoImpl;
import com.projet.pharmatech.entities.Client;

public class ClientService {
	ClientDaoImpl clientDao = new ClientDaoImpl();
	
	public Client add(Client u) {
		return clientDao.add(u);
	};
	
	public Client update(Client u) {
		return clientDao.update(u);
	}


	public void delete(int id) {
		clientDao.delete(id);			
	}

	
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public Client findById(int id) {
		return clientDao.findById(id);
	}
}
