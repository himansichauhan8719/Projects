package com.capgemini.forestrymanagementspringboot.service;

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
class ClientServImplTest {

	@Autowired
	private ClientServices clients;
	private Client client = null; 
	 
	@Test
	void testAddClient() {
		client = new Client();
		client.setClientId(65);
		client.setClientName("susmita");
		client.setClientPassword("susmita123");
		client.setRole("Client");
		
		boolean flag = clients.addClient(client);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ClientExceptions.class, ()->{
				clients.addClient(client);
			});
		}
	}
	
	@Test
	void testAllContract() {
		try {
		List<Client> bean = clients.getAllClient();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ClientExceptions.class, ()->{
			clients.getAllClient();
		});
	}

}
	
	
	@Test
	void testDeleteClient() {
		int clientId = 92;
		try {
			boolean check = clients.deleteClient(clientId);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ClientExceptions.class, ()->{
				clients.deleteClient(clientId);
				});
		}
	}
}

