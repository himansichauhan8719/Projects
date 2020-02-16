package com.capgemini.forestrymanagementcollection.dao;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;

public interface AdminDao {
	public boolean addAdmin(AdminBean bean);

	public boolean loginAdmin(Object adminid, String password);

}
