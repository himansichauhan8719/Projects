package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Client;
import com.capgemini.forestrymanagementspringboot.exception.ClientExceptions;

@SpringBootTest
class ClientDaoImplTest {

	@Autowired
	private ClientDao clientdao;
	private Client client = null; 
	 
	@Test
	void testAddClient() {
		client = new Client();
		client.setClientId(65);
		client.setClientName("susmita");
		client.setClientPassword("susmita123");
		client.setRole("Client");
		
		try {
		boolean flag = clientdao.addClient(client);
		assertEquals(flag,true);
			
		} catch(Exception e) {
			assertThrows(ClientExceptions.class, ()->{
				clientdao.addClient(client);
			});
		}
	}
	
	@Test
	void testAllContract() {
		try {
		List<Client> bean = clientdao.getAllClient();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ClientExceptions.class, ()->{
			clientdao.getAllClient();
		});
	}

}
	
	
	@Test
	void testDeleteClient() {
		int clientId = 92;
		try {
			boolean check = clientdao.deleteClient(clientId);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ClientExceptions.class, ()->{
				clientdao.deleteClient(clientId);
				});
		}
	}
}

