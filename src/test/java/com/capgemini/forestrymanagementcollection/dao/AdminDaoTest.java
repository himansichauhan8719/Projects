package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;
import com.capgemini.forestrymanagementcollection.bean.ClientBean;

class AdminDaoTest {
	
	private AdminDao adminDao = new AdminDaoImpl();
	AdminBean adminBean = new AdminBean();
	
	@BeforeEach
	public void addAdmin( ) {
		adminBean.setAdminId(10);
		adminBean.setAdminName("azad");
		adminBean.setAdminPassword("khan"); 
		adminBean.setEmail("suraj@gmail");
		adminDao.addAdmin(adminBean);
	}
	
	
	@Test
	void testLoginAdmin() {
		assertTrue(adminDao.loginAdmin(adminBean.getAdminId(), adminBean.getAdminPassword()));
	}

}
