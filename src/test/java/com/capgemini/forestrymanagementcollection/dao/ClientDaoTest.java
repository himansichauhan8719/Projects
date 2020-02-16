package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;
import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;

class ClientDaoTest {

	private ClientDao clientDao = new ClientDaoImpl();
	ClientBean clientBean = new ClientBean();
	
	@BeforeEach
	public void addClient( ) {
		clientBean.setClientId(10);
		clientBean.setClientName("king");
		clientBean.setClientPassword("kingkhan");
		clientDao.addClient(clientBean);
	}
	
	@Test
	void testAddClient() {
		ClientBean clientBean1 = new ClientBean();
		clientBean1.setClientId(11);
		clientBean1.setClientName("dinga");
		clientBean1.setClientPassword("kingkhan1");
		assertTrue(clientDao.addClient(clientBean1));
	}

	@Test
	void testLoginClient() {
		assertTrue(clientDao.loginClient(clientBean.getClientId(), clientBean.getClientPassword()));
	}

	@Test
	void testSearchClient() {
		List<ClientBean> client = clientDao.searchClient(clientBean.getClientId());
		assertNotNull(client);
	}

	@Test
	void testGetAllClient() {
		List<ClientBean> allClient = clientDao.getAllClient();
		assertNotNull(allClient);
	}

	@Test
	void testDeleteClient() {
		assertTrue(clientDao.deleteClient(clientBean.getClientId()));
	}

	@Test
	void testUpdateClientName() {
		assertTrue(clientDao.updateClientName(clientBean.getClientId(), "azad"));
	}

	@Test
	void testUpdateClientPass() {
		assertTrue(clientDao.updateClientName(clientBean.getClientId(), "suraj"));
	}

}
