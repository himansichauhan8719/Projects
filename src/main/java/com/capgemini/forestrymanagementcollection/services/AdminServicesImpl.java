package com.capgemini.forestrymanagementcollection.services;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;
import com.capgemini.forestrymanagementcollection.dao.AdminDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class AdminServicesImpl implements AdminServices {
	private AdminDao adminDao = Factory.adminImpl();

	@Override
	public boolean addAdmin(AdminBean bean) {
		return adminDao.addAdmin(bean);
	}

	@Override
	public boolean loginAdmin(Object adminId, String password) {
		return adminDao.loginAdmin(adminId, password);
	}

}
