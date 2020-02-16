package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;

class CustomerServicesTest {

	private static CustomerServices customerServices = new CustomerServicesImpl();
	private static CustomerBean customer = new CustomerBean();
	
	@BeforeAll
	static void addCustomers() {
		customer.setCustomerName("khan1");
		customer.setCustomerId(201);
		customer.setEmail("skhan1@gmail.com");
		customer.setPostalCode(59122);
		customer.setStreetAdd1("raibag Road1");
		customer.setStreetAdd2("Raibag Road21");
		customer.setTelephone(73531817);
		customer.setTown("kabbur1");
		customerServices.addCustomer(customer);
	}
	
	@AfterAll
	static void delete() {
		customerServices.deleteCustomer(customer.getCustomerId());
	}
	
	
	
	@Test
	void testAddCustomer() {
		CustomerBean customer1 = new CustomerBean();
		customer1.setCustomerName("khan");
		customer1.setCustomerId(20);
		customer1.setEmail("skhan@gmail.com");
		customer1.setPostalCode(591222);
		customer1.setStreetAdd1("raibag Road");
		customer1.setStreetAdd2("Raibag Road2");
		customer1.setTelephone(735318171);
		customer1.setTown("kabbur");
		assertTrue(customerServices.addCustomer(customer1));
		customerServices.deleteCustomer(customer1.getCustomerId());
	}

	@Test
	void testDeleteCustomer() {
		CustomerBean customer1 = new CustomerBean();
		customer1.setCustomerName("khan");
		customer1.setCustomerId(20);
		customer1.setEmail("skhan@gmail.com");
		customer1.setPostalCode(591222);
		customer1.setStreetAdd1("raibag Road");
		customer1.setStreetAdd2("Raibag Road2");
		customer1.setTelephone(735318171);
		customer1.setTown("kabbur");
		customerServices.addCustomer(customer1);
		assertTrue(customerServices.deleteCustomer(customer1.getCustomerId()));
	}

	@Test
	void testGetCustomer() {
		assertNotNull(customerServices.getCustomer(customer.getCustomerId()));
	}

	@Test
	void testGetAllCust() {
		assertNotNull(customerServices.getAllCust());
	}

	@Test
	void testModifyCustomerName() {
		assertTrue(customerServices.modifyCustomerName(customer.getCustomerId(), "abhi"));
	}

	@Test
	void testModifyCustomerStreet1() {
		assertTrue(customerServices.modifyCustomerStreet1(customer.getCustomerId(), "kabbur"));
	}

	@Test
	void testModifyCustomerStreet2() {
		assertTrue(customerServices.modifyCustomerStreet1(customer.getCustomerId(), "Chikkodi"));
	}

	@Test
	void testModifyCustomerTown() {
		assertTrue(customerServices.modifyCustomerTown(customer.getCustomerId(), "Belagavi"));
	}

	@Test
	void testModifyCustomerPostalCode() {
		assertTrue(customerServices.modifyCustomerPostalCode(customer.getCustomerId(), 591222));
	}

	@Test
	void testModifyCustomerEmail() {
		assertTrue(customerServices.modifyCustomerEmail(customer.getCustomerId(), "azad@g.com"));
	}

	@Test
	void testModifyCustomerTelephone() {
		assertTrue(customerServices.modifyCustomerTelephone(customer.getCustomerId(),963244870));
	}

}
