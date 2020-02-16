package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.exception.AdminExceptions;
import com.capgemini.forestrymanagementjdbc.exception.CustomerExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class AdminDaoImpl implements AdminDao {
	FileReader reader;
	Properties prop;
	AdminBean bean = Factory.getAdminBean();

	public AdminDaoImpl() {
		try {
			reader = new FileReader("admin.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("driver Canoot");
		}
	}

	@Override
	public boolean addAdmin(AdminBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertquery"))) {
			pstmt.setInt(1, bean.getAdminId());
			pstmt.setString(2, bean.getAdminName());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getRole());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Admin Cannot be Added");
			throw new AdminExceptions("Admin Id Already Existed");

		}
		return false;
	}

	@Override
	public boolean loginAdmin(int adminid, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginquery"))) {
			pstmt.setInt(1, adminid);
			pstmt.setString(2, password);
			pstmt.setString(3, "admin");
			ResultSet rs = pstmt.executeQuery();
			AdminBean user1 = new AdminBean();
			while (rs.next()) {
				user1.setAdminId(rs.getInt(1));
				user1.setPassword(rs.getString(4));
			}
			if (user1.getAdminId() == adminid || user1.getPassword() == password) {
				return true;
			}

		} catch (Exception e) {
		}

		throw new AdminExceptions("login Failed\nEnter Valid Admin Credentials");
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, adminId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new AdminExceptions("Enter Valid admin Id\nCustomer Cannot be Deleted ");
	}

}
