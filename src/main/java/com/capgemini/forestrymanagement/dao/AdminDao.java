package com.capgemini.forestrymanagement.dao;

import com.capgemini.forestrymanagement.dto.Admin;

public interface AdminDao {
	public boolean addAdmin(Admin admin);

	public boolean loginAdmin(Object adminId, String adminPassword);
	
	public boolean deleteAdmin(int adminId);
}
