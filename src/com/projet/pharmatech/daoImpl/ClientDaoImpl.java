package com.projet.pharmatech.daoImpl;

import java.util.List;

import com.projet.pharmatech.dao.IClientDao;
import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.entities.Medicament;

public class ClientDaoImpl extends EntityDaoImpl<Client>  implements IClientDao {

	@Override
	public List<Client> findAll() {
			return session.createQuery("select o from Client o").list();
	}

}
