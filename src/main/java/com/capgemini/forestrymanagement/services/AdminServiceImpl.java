package com.capgemini.forestrymanagement.services;

import com.capgemini.forestrymanagement.dao.AdminDao;
import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.factory.Factory;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = Factory.getAdminDao();

	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public boolean loginAdmin(int adminId, String adminPassword) {
		return adminDao.loginAdmin(adminId, adminPassword);
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		return adminDao.deleteAdmin(adminId);
	}

}
