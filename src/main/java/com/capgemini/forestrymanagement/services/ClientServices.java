package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dto.Client;

public interface ClientServices {

	public boolean addClient(Client client);

	public boolean loginClient(int clientId, String clientPassword);

	public List<Client> searchClient(int clientId);

	public List<Client> getAllClient();

	public boolean deleteClient(int clientId);
}
