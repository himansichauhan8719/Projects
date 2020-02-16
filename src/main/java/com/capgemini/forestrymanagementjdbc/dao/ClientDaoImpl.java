package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.exception.ClientExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;

public class ClientDaoImpl implements ClientDao {
	FileReader filerReader;
	Properties properties;
	ClientBean clientBean = Factory1.getClBean();

	public ClientDaoImpl() {
		try {
			filerReader = new FileReader("client.properties");
			properties = new Properties();
			properties.load(filerReader);
			Class.forName(properties.getProperty("driverClass"));
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	@Override
	public boolean addClient(ClientBean bean) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("insertquery"))) {
			pstmt.setInt(1, bean.getClientId());
			pstmt.setString(2, bean.getClientName());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getRole());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new ClientExceptions("Client Account Cannot be Added\nClient Id Already Existed");
	}

	@Override
	public boolean loginClient(int clientid, String clientpass) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("loginquery"))) {
			pstmt.setInt(1, clientid);
			pstmt.setString(2, clientpass);
			pstmt.setString(3, "client");
			ResultSet rs = pstmt.executeQuery();
			ClientBean user1 = new ClientBean();
			while (rs.next()) {
				user1.setClientId(rs.getInt(1));
				user1.setPassword(rs.getString(3));

				if (user1.getClientId() == clientid || user1.getPassword() == clientpass) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		throw new ClientExceptions("Login Failed\nInvalid Credentials");
	}

	@Override
	public List<ClientBean> searchClient(int clientid) {
		List<ClientBean> a = new ArrayList<ClientBean>();

		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query"))) {
			pstmt.setInt(1, clientid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ClientBean bean1 = new ClientBean();
				bean1.setClientId(rs.getInt(1));
				bean1.setClientName(rs.getString(2));
				a.add(bean1);

			}
			return a;

		} catch (Exception e) {
		}
		throw new ClientExceptions("Enter Valid Client Id\nClient Cannot be Found");

	}

	@Override
	public List<ClientBean> getAllClient() {
		ArrayList<ClientBean> a = new ArrayList<ClientBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));

				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query1"))) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ClientBean bean1 = new ClientBean();
				bean1.setClientId(rs.getInt(1));
				bean1.setClientName(rs.getString(2));
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
		}
		throw new ClientExceptions("No Client Account Present");

	}

	@Override
	public boolean deleteClient(int clientid, String clientpass) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("delete"))) {

			pstmt.setInt(1, clientid);
			pstmt.setString(2, clientpass);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new ClientExceptions("Client Cannot be Deleted");
	}

}
