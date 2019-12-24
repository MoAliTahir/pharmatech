package com.projet.pharmatech.services;

import java.io.Serializable;
import java.util.List;

import com.projet.pharmatech.daoImpl.ClientDaoImpl;
import com.projet.pharmatech.entities.Client;

public class ClientService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClientDaoImpl clientDao = new ClientDaoImpl();
	
	public ClientService() {
		// TODO Auto-generated constructor stub
	}
	
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

	public ClientDaoImpl getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDaoImpl clientDao) {
		this.clientDao = clientDao;
	}
	
	
}
