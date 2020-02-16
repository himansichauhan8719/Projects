package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;

class CustomerDaoTest {

	private CustomerDao customerDao = new CustomerDaoImpl();
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
		customerDao.addCustomer(customerBean);
		
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
		boolean addCustomer = customerDao.addCustomer(customerBean1);
		assertTrue(addCustomer);
	}

	@Test
	void testDeleteCustomer() {
		boolean deleteCustomer = customerDao.deleteCustomer(customerBean.getCustomerId());
		assertTrue(deleteCustomer);
	}

	@Test
	void testModifyCustomerName() {
		boolean modifyCustomerName = customerDao.modifyCustomerName(customerBean.getCustomerId(), "azad");
		assertTrue(modifyCustomerName);
	}

	@Test
	void testModifyCustomerAdd() {
		boolean modifyCustomerAddress = customerDao.modifyCustomerAdd(customerBean.getCustomerId(), "Chikkodi");
		assertTrue(modifyCustomerAddress);
	}

	@Test
	void testModifyCustomerEmail() {
		boolean modifyCustomerEmail = customerDao.modifyCustomerEmail(customerBean.getCustomerId(), "azad@Gmail.com");
		assertTrue(modifyCustomerEmail);
	}

	@Test
	void testModifyCustomerPost() {
		boolean modifyCustomerPost = customerDao.modifyCustomerPost(customerBean.getCustomerId(), 591223);
		assertTrue(modifyCustomerPost);
	}

	@Test
	void testModifyCustomerTelephone() {
		boolean modifyCustomerTelephone = customerDao.modifyCustomerTelephone(customerBean.getCustomerId(), 767659120);
		assertTrue(modifyCustomerTelephone);
	}

	@Test
	void testModifyCustomerTown() {
		boolean modifyCustomerTown = customerDao.modifyCustomerTown(customerBean.getCustomerId(), "Chikkodi");
		assertTrue(modifyCustomerTown);
	}

	@Test
	void testShowAllCustomer() {
		List<CustomerBean> allCustomer = customerDao.showAllCustomer(customerBean);
		assertNotNull(allCustomer);
	}

	@Test
	void testSearchCustomer() {
		List<CustomerBean> searchCustomer = customerDao.searchCustomer(customerBean.getCustomerId());
		assertNotNull(searchCustomer);
	}

}
