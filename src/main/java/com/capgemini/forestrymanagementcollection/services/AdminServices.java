package com.capgemini.forestrymanagementcollection.services;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;

public interface AdminServices {
	public boolean addAdmin(AdminBean bean);

	public boolean loginAdmin(Object adminid, String password);

}
