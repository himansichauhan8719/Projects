package com.capgemini.forestrymanagement.services;

import com.capgemini.forestrymanagement.dto.Admin;

public interface AdminService {
	public boolean addAdmin(Admin admin);

	public boolean loginAdmin(int adminId, String adminPassword);
	
	public boolean deleteAdmin(int adminId);

}
