package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.dao.AdminDao;
import com.capgemini.forestrymanagementjdbc.dao.AdminDaoImpl;

class AdminServiceTest {

	private static AdminService adminServices = new AdminServiceImpl();
	private static AdminBean admin = new AdminBean();
	
	@BeforeAll
	static void addAdmin() {
		admin.setAdminId(786);
		admin.setAdminName("khan");
		admin.setPassword("suraj");
		admin.setRole("admin");
		adminServices.addAdmin(admin);
	}
	
	@AfterAll
	static void delete() {
		adminServices.deleteAdmin(admin.getAdminId());
	}
	
	@Test
	void testAddAdmin() {
		AdminBean admin1 = new AdminBean();
		admin1.setAdminId(7861);
		admin1.setAdminName("khan");
		admin1.setPassword("suraj");
		admin1.setRole("admin");
		assertTrue(adminServices.addAdmin(admin1));
		adminServices.deleteAdmin(admin1.getAdminId());
	}

	@Test
	void testLoginAdmin() {
		assertTrue(adminServices.loginAdmin(admin.getAdminId(), admin.getPassword()));
		
	}

	@Test
	void testDeleteAdmin() {
		AdminBean admin1 = new AdminBean();
		admin1.setAdminId(7861);
		admin1.setAdminName("khan");
		admin1.setPassword("suraj");
		admin1.setRole("admin");
		adminServices.addAdmin(admin1);
		assertTrue(adminServices.deleteAdmin(admin1.getAdminId()));
	}

}
