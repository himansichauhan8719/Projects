package com.capgemini.forestrymanagementjdbc.dao;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;

public interface AdminDao {
	public boolean addAdmin(AdminBean bean);

	public boolean loginAdmin(int adminid, String password);
	
	public boolean deleteAdmin(int adminId);
}
