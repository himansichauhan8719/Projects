package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;

class ClientDaoTest {

	private static ClientDao clientDao = new ClientDaoImpl();
	private static ClientBean client = new ClientBean();
	
	@BeforeAll
	static void addScheduler() {
		client.setClientId(999);
		client.setClientName("mansi");
		client.setPassword("mansi999");
		client.setRole("client");
		clientDao.addClient(client);
	}
	
	@AfterAll
	static void delete() {
		clientDao.deleteClient(client.getClientId(), client.getPassword());
	}
	

	
	@Test
	void testAddClient() {
		ClientBean client1 = new ClientBean();
		client1.setClientId(9926);
		client1.setClientName("mansi");
		client1.setPassword("mansi999");
		client1.setRole("client");
		assertTrue(clientDao.addClient(client1));
		clientDao.deleteClient(client1.getClientId(), client1.getPassword());
	}

	@Test
	void testLoginClient() {
		assertTrue(clientDao.loginClient(client.getClientId(), client.getPassword()));
	}

	@Test
	void testSearchClient() {
	}

	@Test
	void testGetAllClient() {
		assertNotNull(clientDao.getAllClient());
	}

	@Test
	void testDeleteClient() {
		ClientBean client1 = new ClientBean();
		client1.setClientId(9926);
		client1.setClientName("mansi");
		client1.setPassword("mansi999");
		client1.setRole("client");
		clientDao.addClient(client1);
		assertTrue(clientDao.deleteClient(client1.getClientId(), client1.getPassword()));

	}

}
