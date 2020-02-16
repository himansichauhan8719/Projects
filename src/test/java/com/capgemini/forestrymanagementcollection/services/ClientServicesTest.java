package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;
	
class ClientServicesTest {

	private ClientServices clientServices = new ClientServicesImpl();
	ClientBean clientBean = new ClientBean();
	
	@BeforeEach
	public void addClient( ) {
		clientBean.setClientId(10);
		clientBean.setClientName("king");
		clientBean.setClientPassword("kingkhan");
		clientServices.addClient(clientBean);
	}
	
	@Test
	void testAddClient() {
		ClientBean clientBean1 = new ClientBean();
		clientBean1.setClientId(11);
		clientBean1.setClientName("dinga");
		clientBean1.setClientPassword("kingkhan1");
		assertTrue(clientServices.addClient(clientBean1));
	}

	@Test
	void testLoginClient() {
		assertTrue(clientServices.loginClient(clientBean.getClientId(), clientBean.getClientPassword()));
	}

	@Test
	void testSearchClient() {
		List<ClientBean> client = clientServices.searchClient(clientBean.getClientId());
		assertNotNull(client);
	}

	@Test
	void testGetAllClient() {
		List<ClientBean> allClient = clientServices.getAllClient();
		assertNotNull(allClient);
	}

	@Test
	void testDeleteClient() {
		assertTrue(clientServices.deleteClient(clientBean.getClientId()));
	}

	@Test
	void testUpdateClientName() {
		assertTrue(clientServices.updateClientName(clientBean.getClientId(), "azad"));
	}

	@Test
	void testUpdateClientPass() {
		assertTrue(clientServices.updateClientName(clientBean.getClientId(), "suraj"));
	}

}
