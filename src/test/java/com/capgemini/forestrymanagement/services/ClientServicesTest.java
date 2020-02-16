package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Client;

class ClientServicesTest {

	private static ClientServices clientServices = new ClientServicesImpl();
	private static Client client = new Client();
	
	@BeforeAll
	static void addClient() {
		client.setClientId(786);
		client.setClientName("khan");
		client.setClientPassword("kingkhan");
		client.setRole("client");
		clientServices.addClient(client);
	}
	
	@AfterAll
	static void delete() {
		clientServices.deleteClient(client.getClientId());
	}
	
	
	@Test
	void testAddClient() {
		Client client1 = new Client();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		assertTrue(clientServices.addClient(client1));
		clientServices.deleteClient(client1.getClientId());
	}

	@Test
	void testLoginClient() {
		assertTrue(clientServices.loginClient(client.getClientId(), client.getClientPassword()));
	}

	@Test
	void testGetAllClient() {
		assertNotNull(clientServices.getAllClient());
	}

	@Test
	void testDeleteClient() {
		Client client1 = new Client();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		clientServices.addClient(client1);
		assertTrue(clientServices.deleteClient(client1.getClientId()));
	}

}
