package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Customer;
import com.capgemini.forestrymanagementspringboot.exception.CustomerExceptions;

@SpringBootTest
class CustomerDaoImplTest {

	@Autowired
	private CustomerDao customerdao;
	private Customer bean = null; 
	 
	@Test
	void testAddCustomer() {
		bean = new Customer();
		bean.setCustomerId(63);
		bean.setCustomerName("abhaya");
		bean.setEmail("abahaya123@gmail.com");
		bean.setPostalCode(283732);
		bean.setStreetAdd1("banglore");
		bean.setStreetAdd2("BTM");
		bean.setTelephone(992645952);
		bean.setTown("BABA ka bhaba");
		boolean flag = customerdao.addCustomer(bean);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(CustomerExceptions.class, ()->{
				customerdao.addCustomer(bean);
			});
		}
	}
	
	@Test
	void testAllCustomer() {
		try {
		List<Customer> bean = customerdao.getAllCust();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(CustomerExceptions.class, ()->{
			customerdao.getAllCust();
		});
	}

}
	
	@Test
	void testGetCustomer() {
		int customerId = 43;
		try {
			Customer cust = customerdao.getCustomer(customerId);
			assertNotNull(cust);
		}catch(Exception e) {
			assertThrows(CustomerExceptions.class, ()->{
				customerdao.getCustomer(3);
				});
		}
	}
	
	@Test
	void testDeleteCustomer() {
		int customerId = 92;
		try {
			boolean check = customerdao.deleteCustomer(customerId);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(CustomerExceptions.class, ()->{
				customerdao.deleteCustomer(customerId);
				});
		}
	}

}
