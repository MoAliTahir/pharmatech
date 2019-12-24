package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.hibernate.sql.Update;

import com.projet.pharmatech.entities.Client;
import com.projet.pharmatech.services.ClientService;

@ManagedBean(name="clientsBean")
public class ClientsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Client client;
	
	private ArrayList<Client> clients;
	
	private ClientService clientService;

	public ClientsBean() {
 	}
	
	@PostConstruct
	private void init() {
		clientService= new ClientService();
		client= new Client();
		clients= new ArrayList<>();
		clients.addAll(this.getClientService().findAll());
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	public void getUserInfo(Client client) {
		this.client=client;
	}
	
	public void addClient() {
		if(clientService.findById(client.getId())!=null) {
		   this.clientService.update(this.client);
		}
		else {
			   this.clientService.add(this.client);
		}
		client= new Client();
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	public void update(Client c) {
		this.client=c;
	}
	
	public void delete(Client c) {
		clientService.delete(c.getId());
	}
	
	public void reset() {
		client=new Client();
	}
}
