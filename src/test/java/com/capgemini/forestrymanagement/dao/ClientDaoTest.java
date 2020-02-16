package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Client;

class ClientDaoTest {

	private static ClientDao clientDao = new ClientDaoImpl();
	private static Client client = new Client();
	
	@BeforeAll
	static void addClient() {
		client.setClientId(786);
		client.setClientName("khan");
		client.setClientPassword("kingkhan");
		client.setRole("client");
		clientDao.addClient(client);
	}
	
	@AfterAll
	static void delete() {
		clientDao.deleteClient(client.getClientId());
	}
	
	
	@Test
	void testAddClient() {
		Client client1 = new Client();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		assertTrue(clientDao.addClient(client1));
		clientDao.deleteClient(client1.getClientId());
	}

	@Test
	void testLoginClient() {
		assertTrue(clientDao.loginClient(client.getClientId(), client.getClientPassword()));
	}

	@Test
	void testGetAllClient() {
		assertNotNull(clientDao.getAllClient());
	}

	@Test
	void testDeleteClient() {
		Client client1 = new Client();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		clientDao.addClient(client1);
		assertTrue(clientDao.deleteClient(client1.getClientId()));
	}

}
