package com.capgemini.forestrymanagementjdbc.services;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.dao.AdminDaoImpl;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class AdminServiceImpl implements AdminService {
	AdminDaoImpl adminDao = (AdminDaoImpl) Factory.getAdminDao();

	@Override
	public boolean addAdmin(AdminBean bean) {
		return adminDao.addAdmin(bean);
	}

	@Override
	public boolean loginAdmin(int adminid, String password) {
		return adminDao.loginAdmin(adminid, password);
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		return adminDao.deleteAdmin(adminId);
	}

}
