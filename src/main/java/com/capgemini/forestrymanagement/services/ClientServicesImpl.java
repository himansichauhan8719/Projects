package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.ClientDao;
import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.factory.Factory;

public class ClientServicesImpl implements ClientServices {

	ClientDao clientDao = Factory.getClientDao();

	@Override
	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	@Override
	public boolean loginClient(int clientId, String clientPassword) {
		return clientDao.loginClient(clientId, clientPassword);
	}

	@Override
	public List<Client> searchClient(int clientId) {
		return clientDao.searchClient(clientId);
	}

	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientId) {
		return clientDao.deleteClient(clientId);
	}

}
