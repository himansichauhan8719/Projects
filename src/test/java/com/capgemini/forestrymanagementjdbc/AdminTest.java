package com.capgemini.forestrymanagementjdbc;

import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.controller.Admin;
import com.capgemini.forestrymanagementjdbc.dao.AdminDao;
import com.capgemini.forestrymanagementjdbc.dao.AdminDaoImpl;

public class AdminTest {
	
	AdminBean adminBean = null;
	AdminDao adminDao = null;
	
	@BeforeEach
	void loadDriver() {
		FileReader reader;
		Properties properties;
		
		try {
			reader = new FileReader("admin.properties");
			properties = new Properties();
			properties.load(reader);
			Class.forName(properties.getProperty("driver"));
		} catch (Exception e) {
			System.err.println("Driver Cannot Be Loadeds");
		}
		adminDao = new AdminDaoImpl();
	}
	
//	@Test
//	void addAdmin() {
//		adminBean = new AdminBean();
//		adminBean.setAdminId(250);
//		adminBean.setPassword("");
//		adminBean.setPassword("avengers@123");
//		boolean flag = adminDao.addAdmin(bean)
//	}
	
	
	
	

}
