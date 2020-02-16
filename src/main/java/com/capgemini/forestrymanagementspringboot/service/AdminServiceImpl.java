package com.capgemini.forestrymanagementspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.AdminDao;
import com.capgemini.forestrymanagementspringboot.dto.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao ;
	
//	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public boolean addAdmin(Admin admin) {
//		String encodePassword = encoder.encode(admin.getAdminPassword());
//		admin.setAdminPassword(encodePassword);
		return adminDao.addAdmin(admin);
	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

	

	

}
