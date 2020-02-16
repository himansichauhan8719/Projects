package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.exception.ContractsExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class ContractorDaoImpl implements ContractorDao {
	FileReader filerReader;
	Properties properties;
	static ContractorBean contractBean = Factory.getContrBean();

	public ContractorDaoImpl() {
		try {
			filerReader = new FileReader("contractor.properties");
			properties = new Properties();
			properties.load(filerReader);
			Class.forName(properties.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("Driver Cannot be Loaded");
		}
	}

	@Override
	public boolean addContractor(ContractorBean contractor) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("addquery"))) {
			pstmt.setInt(1, contractor.getContractNo());
			pstmt.setInt(2, contractor.getCustomerId());
			pstmt.setInt(3, contractor.getProductId());
			pstmt.setString(4, contractor.getDeliDate());
			pstmt.setInt(5, contractor.getQuantity());
			pstmt.setString(6, contractor.getStatus());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			throw new ContractsExceptions("Contract cannot be Added");
		}
		return false;
	}

	@Override
	public boolean deleteContractor(int contractid) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("delete"))) {

			pstmt.setInt(1, contractid);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new ContractsExceptions("Contract Cannot be Deleted");
	}

	@Override
	public ArrayList<ContractorBean> getContractor(int contractno) {
		ArrayList<ContractorBean> a = new ArrayList<ContractorBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query"))) {

			pstmt.setInt(1, contractno);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contractBean = new ContractorBean();
				contractBean.setContractNo(rs.getInt(1));
				contractBean.setCustomerId(rs.getInt(2));
				contractBean.setProductId(rs.getInt(3));
				contractBean.setDeliDate(rs.getString(4));
				contractBean.setQuantity(rs.getInt(5));
				contractBean.setStatus(rs.getString(6));
				a.add(contractBean);
				return a;
			}

		} catch (Exception e) {
		}
		throw new ContractsExceptions("Contract Cannot be Found\nEnter Valid Contractor Id");
	}

	@Override
	public ArrayList<ContractorBean> getAllContractor() {
		ArrayList<ContractorBean> a = new ArrayList<ContractorBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query1"))) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contractBean = new ContractorBean();
				contractBean.setContractNo(rs.getInt(1));
				contractBean.setCustomerId(rs.getInt(2));
				contractBean.setProductId(rs.getInt(3));
				contractBean.setDeliDate(rs.getString(4));
				contractBean.setQuantity(rs.getInt(5));
				contractBean.setStatus(rs.getString(6));
				a.add(contractBean);
			}
			return a;

		} catch (Exception e) {
		}
		throw new ContractsExceptions("No Contracts Present");
	}

	@Override
	public boolean sheduleContract(int contractNo, String deliveryDate, String status) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("schedule-contr"))) {

			pstmt.setString(1, deliveryDate);
			pstmt.setString(2, status);
			pstmt.setInt(3, contractNo);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
		}
		throw new ContractsExceptions("Contract Cannot be Scheduled");
	}
}
