package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;

class CustomerServicesTest {

	private CustomerServices customerServices = new CustomerServicesImpl();
	private CustomerBean customerBean = new CustomerBean();
	
	@BeforeEach
	void addCustomer() {
		customerBean.setCustomerName("khan");
		customerBean.setCustomerId(20);
		customerBean.setEmail("skhan@gmail.com");
		customerBean.setPostalCode(591222);
		customerBean.setStreetAdd1("raibag Road");
		customerBean.setStreetAdd2("Raibag Road2");
		customerBean.setTelephone(735318171);
		customerBean.setTown("kabbur");
		customerServices.addCustomer(customerBean);
		
	}
	
	@Test
	void testAddCustomer() {
		CustomerBean customerBean1 = new CustomerBean();
		customerBean1.setCustomerId(50);
		customerBean1.setCustomerName("suraj");
		customerBean1.setEmail("skhan@gmaila");
		customerBean1.setPostalCode(1451);
		customerBean1.setStreetAdd1("raibag Road");
		customerBean1.setStreetAdd2("Raibag Road2");
		customerBean1.setTown("kabbur");
		customerBean1.setTelephone(963244870);
		boolean addCustomer = customerServices.addCustomer(customerBean1);
		assertTrue(addCustomer);
	}

	@Test
	void testDeleteCustomer() {
		boolean deleteCustomer = customerServices.deleteCustomer(customerBean.getCustomerId());
		assertTrue(deleteCustomer);
	}

	@Test
	void testModifyCustomerName() {
		boolean modifyCustomerName = customerServices.modifyCustomerName(customerBean.getCustomerId(), "azad");
		assertTrue(modifyCustomerName);
	}

	@Test
	void testModifyCustomerAdd() {
		boolean modifyCustomerAddress = customerServices.modifyCustomerAdd(customerBean.getCustomerId(), "Chikkodi");
		assertTrue(modifyCustomerAddress);
	}

	@Test
	void testModifyCustomerEmail() {
		boolean modifyCustomerEmail = customerServices.modifyCustomerEmail(customerBean.getCustomerId(), "azad@Gmail.com");
		assertTrue(modifyCustomerEmail);
	}

	@Test
	void testModifyCustomerPost() {
		boolean modifyCustomerPost = customerServices.modifyCustomerPost(customerBean.getCustomerId(), 591223);
		assertTrue(modifyCustomerPost);
	}

	@Test
	void testModifyCustomerTelephone() {
		boolean modifyCustomerTelephone = customerServices.modifyCustomerTelephone(customerBean.getCustomerId(), 767659120);
		assertTrue(modifyCustomerTelephone);
	}

	@Test
	void testModifyCustomerTown() {
		boolean modifyCustomerTown = customerServices.modifyCustomerTown(customerBean.getCustomerId(), "Chikkodi");
		assertTrue(modifyCustomerTown);
	}

	@Test
	void testShowAllCustomer() {
		List<CustomerBean> allCustomer = customerServices.showAllCustomer(customerBean);
		assertNotNull(allCustomer);
	}

	@Test
	void testSearchCustomer() {
		List<CustomerBean> searchCustomer = customerServices.searchCustomer(customerBean.getCustomerId());
		assertNotNull(searchCustomer);
	}

}
