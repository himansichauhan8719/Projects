package com.capgemini.forestrymanagementspringboot.dao;

import java.util.List;

import com.capgemini.forestrymanagementspringboot.dto.Client;

public interface ClientDao {
	public boolean addClient(Client client);

	public boolean loginClient(int clientId, String clientPassword);

	public List<Client> searchClient(int clientId);

	public List<Client> getAllClient();

	public boolean deleteClient(int clientId);
}
