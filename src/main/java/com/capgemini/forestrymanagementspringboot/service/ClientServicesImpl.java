package com.capgemini.forestrymanagementspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.ClientDao;
import com.capgemini.forestrymanagementspringboot.dto.Client;

@Service
public class ClientServicesImpl implements ClientServices {
	
	@Autowired
	private ClientDao clientDao ;

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
