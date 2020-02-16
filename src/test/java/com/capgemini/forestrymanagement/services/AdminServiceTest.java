package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Admin;

class AdminServiceTest {

	private static AdminService adminServices = new AdminServiceImpl();
	private static Admin admin = new Admin();
	
	@BeforeAll
	static void addAdmin() {
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("azad");
		admin.setRole("admin");
		adminServices.addAdmin(admin);
	}
	
	@AfterAll
	static void delete() {
		adminServices.deleteAdmin(admin.getAdminId());
	}
	
	
	
	@Test
	void testAddAdmin() {
		Admin admin1 = new Admin();
		admin1.setAdminId(789);
		admin1.setAdminName("khan");
		admin1.setAdminPassword("azad");
		admin1.setRole("admin");
		assertTrue(adminServices.addAdmin(admin1));
		adminServices.deleteAdmin(admin1.getAdminId());
		
	}

	@Test
	void testLoginAdmin() {
		assertTrue(adminServices.loginAdmin(admin.getAdminId(), admin.getAdminPassword()));
	}
	
	@Test
	void testDeleteAdmin() {
		Admin admin1 = new Admin();
		admin1.setAdminId(789);
		admin1.setAdminName("khan");
		admin1.setAdminPassword("azad");
		admin1.setRole("admin");
		adminServices.addAdmin(admin1);
		assertTrue(adminServices.deleteAdmin(admin1.getAdminId()));
	}

}
