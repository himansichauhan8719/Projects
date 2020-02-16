package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Customer;

class CustomerDaoTest {

	private static CustomerDao customerDao = new CustomerDaoImpl();
	private static Customer customer = new Customer();
	
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
		customerDao.addCustomer(customer);
	}
	
	@AfterAll
	static void delete() {
		customerDao.deleteCustomer(customer.getCustomerId());
	}
	
	@Test
	void testAddCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerName("khan");
		customer1.setCustomerId(20);
		customer1.setEmail("skhan@gmail.com");
		customer1.setPostalCode(591222);
		customer1.setStreetAdd1("raibag Road");
		customer1.setStreetAdd2("Raibag Road2");
		customer1.setTelephone(735318171);
		customer1.setTown("kabbur");
		assertTrue(customerDao.addCustomer(customer1));
		customerDao.deleteCustomer(customer1.getCustomerId());
	}

	@Test
	void testDeleteCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerName("khan");
		customer1.setCustomerId(20);
		customer1.setEmail("skhan@gmail.com");
		customer1.setPostalCode(591222);
		customer1.setStreetAdd1("raibag Road");
		customer1.setStreetAdd2("Raibag Road2");
		customer1.setTelephone(735318171);
		customer1.setTown("kabbur");
		customerDao.addCustomer(customer1);
		assertTrue(customerDao.deleteCustomer(customer1.getCustomerId()));
	}

	@Test
	void testGetCustomer() {
		assertNotNull(customerDao.getCustomer(customer.getCustomerId()));
	}

	@Test
	void testGetAllCust() {
		assertNotNull(customerDao.getAllCust());
	}

	@Test
	void testModifyCustomer() {
		assertTrue(customerDao.modifyCustomer(customer.getCustomerId(), "abhi"));
	}

	@Test
	void testModifyCustomerAdd1() {
		assertTrue(customerDao.modifyCustomerAdd1(customer.getCustomerId(), "kabbur"));
	}

	@Test
	void testModifyCustomerAdd2() {
		assertTrue(customerDao.modifyCustomerAdd2(customer.getCustomerId(), "kabbur"));
	}

	@Test
	void testModifyCustomerTown() {
		assertTrue(customerDao.modifyCustomerTown(customer.getCustomerId(), "chikkodi"));
	}

	@Test
	void testModifyCustomerEmail() {
		assertTrue(customerDao.modifyCustomerEmail(customer.getCustomerId(), "azad@g.com"));
	}

	@Test
	void testModifyCustomerPost() {
		assertTrue(customerDao.modifyCustomerPost(customer.getCustomerId(), 591222));
	}

	@Test
	void testModifyCustomerTel() {
		assertTrue(customerDao.modifyCustomerTel(customer.getCustomerId(),963244870));
	}

}
