package com.capgemini.forestrymanagementspringboot.dao;

import com.capgemini.forestrymanagementspringboot.dto.Admin;

public interface AdminDao {
	public boolean addAdmin(Admin admin);

	public Admin login(Admin admin);
}
