package com.capgemini.forestrymanagementspringboot.service;

import com.capgemini.forestrymanagementspringboot.dto.Admin;

public interface AdminService {
	public boolean addAdmin(Admin admin);

	public Admin login(Admin admin);

}
