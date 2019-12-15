package com.projet.pharmatech.daoImpl;

import java.util.List;

import com.projet.pharmatech.dao.IClientDao;
import com.projet.pharmatech.entities.Client;

public class ClientDaoImpl extends EntityDaoImpl<Client>  implements IClientDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
			return session.createQuery("select o from Client o").list();
	}

}
