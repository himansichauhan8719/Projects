package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;

class AdminServicesTest {

	private AdminServices adminServices = new AdminServicesImpl();
	AdminBean adminBean = new AdminBean();
	
	@BeforeEach
	public void addAdmin( ) {
		adminBean.setAdminId(10);
		adminBean.setAdminName("azad");
		adminBean.setAdminPassword("khan"); 
		adminBean.setEmail("suraj@gmail");
		adminServices.addAdmin(adminBean);
	}
	
	
	@Test
	void testLoginAdmin() {
		assertTrue(adminServices.loginAdmin(adminBean.getAdminId(), adminBean.getAdminPassword()));
	}
}
