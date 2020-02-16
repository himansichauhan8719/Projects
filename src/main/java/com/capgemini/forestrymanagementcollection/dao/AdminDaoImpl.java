package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;
import com.capgemini.forestrymanagementcollection.exception.AdminExceptions;

public class AdminDaoImpl implements AdminDao {

	private List<AdminBean> adminList = new ArrayList<AdminBean>();
	AdminBean adminBean = new AdminBean();

	@Override
	public boolean addAdmin(AdminBean bean) {
		for (AdminBean adminBean : adminList) {
			if (adminBean.getAdminId() == bean.getAdminId()) {
				throw new AdminExceptions("Admin Cannot Be Added");
			}
		}
		adminList.add(bean);
		return true;
	}

	@Override
	public boolean loginAdmin(Object adminid, String password) {
		for (AdminBean adminBean : adminList) {
			if (adminid.equals(adminBean.getAdminId()) && password.equals(adminBean.getAdminPassword())) {
				return true;
			}
		}
		throw new AdminExceptions("Invalid Admin");
	}

}
