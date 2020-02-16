package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Admin;

class AdminDaoTest {

	private static AdminDao adminDao = new AdminDaoImpl();
	private static Admin admin = new Admin();
	
	@BeforeAll
	static void addAdmin() {
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("azad");
		admin.setRole("admin");
		adminDao.addAdmin(admin);
	}
	
	@AfterAll
	static void delete() {
		adminDao.deleteAdmin(admin.getAdminId());
	}
	
	
	
	@Test
	void testAddAdmin() {
		Admin admin1 = new Admin();
		admin1.setAdminId(789);
		admin1.setAdminName("khan");
		admin1.setAdminPassword("azad");
		admin1.setRole("admin");
		assertTrue(adminDao.addAdmin(admin1));
		adminDao.deleteAdmin(admin1.getAdminId());
		
	}

	@Test
	void testLoginAdmin() {
		assertTrue(adminDao.loginAdmin(admin.getAdminId(), admin.getAdminPassword()));
	}
	
	@Test
	void testDeleteAdmin() {
		Admin admin1 = new Admin();
		admin1.setAdminId(789);
		admin1.setAdminName("khan");
		admin1.setAdminPassword("azad");
		admin1.setRole("admin");
		adminDao.addAdmin(admin1);
		assertTrue(adminDao.deleteAdmin(admin1.getAdminId()));
	}


}
