package com.capgemini.forestrymanagementjdbc.services;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;

public interface AdminService {
	public boolean addAdmin(AdminBean bean);

	public boolean loginAdmin(int adminid, String password);
	
	public boolean deleteAdmin(int adminId);

}
