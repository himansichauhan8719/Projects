package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementjdbc.exception.CustomerExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class CustomerDaoImpl implements CustomerDao {
	FileReader filerReader;
	Properties properties;
	CustomerBean customerBean = Factory.getCustBean();

	public CustomerDaoImpl() {
		try {
			filerReader = new FileReader("customer.properties");
			properties = new Properties();
			properties.load(filerReader);
			Class.forName(properties.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("driver not loaded");
		}
	}

	@Override
	public boolean addCustomer(CustomerBean bean1) {

		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("addquery"))) {
			pstmt.setInt(1, bean1.getCustomerId());
			pstmt.setString(2, bean1.getCustomerName());
			pstmt.setString(3, bean1.getStreetAdd1());
			pstmt.setString(4, bean1.getStreetAdd2());
			pstmt.setString(5, bean1.getTown());
			pstmt.setInt(6, bean1.getPostalCode());
			pstmt.setString(8, bean1.getEmail());
			pstmt.setLong(7, bean1.getTelephone());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions(" Customer Id Already Present \nCustomer Cannot be Added");

	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("delete"))) {

			pstmt.setInt(1, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Enter Valid Customer Id\nCustomer Cannot be Deleted ");
	}

	@Override
	public ArrayList<CustomerBean> getCustomer(int customerId) {
		ArrayList<CustomerBean> a = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query"))) {

			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerBean bean1 = new CustomerBean();
				bean1.setCustomerId(rs.getInt(1));
				bean1.setCustomerName(rs.getString(2));
				bean1.setStreetAdd1(rs.getString(3));
				bean1.setStreetAdd2(rs.getString(4));
				bean1.setTown(rs.getString(5));
				bean1.setPostalCode(rs.getInt(6));
				bean1.setTelephone(rs.getLong(7));
				bean1.setEmail(rs.getString(8));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Customer Cannot be Found\nEnter Valid Customer Id");
	}

	@Override
	public ArrayList<CustomerBean> getAllCust() {
		ArrayList<CustomerBean> a = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));

				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query1"))) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerBean bean1 = new CustomerBean();
				bean1.setCustomerId(rs.getInt(1));
				bean1.setCustomerName(rs.getString(2));
				bean1.setStreetAdd1(rs.getString(3));
				bean1.setStreetAdd2(rs.getString(4));
				bean1.setTown(rs.getString(5));
				bean1.setPostalCode(rs.getInt(6));
				bean1.setTelephone(rs.getLong(7));
				bean1.setEmail(rs.getString(8));
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Customer Not Present");
	}

	@Override
	public boolean modifyCustomerName(int customerId, String customerName) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("cust-modify"))) {

			pstmt.setString(1, customerName);    //bean.getCustomerName()
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Customer Name Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerStreet1(int customerId, String streetAdd1) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("add1-modify"))) {

			pstmt.setString(1, customerBean.getStreetAdd1());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Customer Name Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerStreet2(int customerId, String streetAdd2) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("add2-modify"))) {

			pstmt.setString(1, customerBean.getStreetAdd2());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Street address 2 Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("town-modify"))) {

			pstmt.setString(1, customerBean.getTown());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Town Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerPostalCode(int customerId, int postalCode) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("post-modify"))) {

			pstmt.setInt(1, customerBean.getPostalCode());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Postal Code Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String email) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("email-modify"))) {

			pstmt.setString(1, customerBean.getEmail());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Email id Cannot be Modified\nEnter Valid Customer Id");
	}

	@Override
	public boolean modifyCustomerTelephone(int customerId, long telephone) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("tel-modify"))) {

			pstmt.setLong(1, customerBean.getTelephone());
			pstmt.setInt(2, customerId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new CustomerExceptions("Telephone Cannot be Modified\nEnter Valid Customer Id");
	}

}
