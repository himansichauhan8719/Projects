package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.exception.ProductExceptions;

public class ProductDaoImpl implements ProductDao {

	FileReader fileReader;
	Properties properties;
	ProductBean productBean;

	public ProductDaoImpl() {
		try {
			fileReader = new FileReader("product.properties");
			properties = new Properties();
			properties.load(fileReader);
			Class.forName(properties.getProperty("driverClass"));

		} catch (Exception e) {
			System.err.println("Driver Not Loaded");
		}
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("addquery"))) {
			pstmt.setString(1, bean.getProductName());
			pstmt.setInt(2, bean.getProductId());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			throw new ProductExceptions("Product Cannot be Added\nProduct Id Already Existed");
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productid) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("delete"))) {

			pstmt.setInt(1, productid);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new ProductExceptions("Product Cannot be Deleted\nEnter Valid Product Id");
	}

	@Override
	public boolean modifyProduct(int productid, String productname) {

		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("modify"))) {
			pstmt.setString(1, productname);
			pstmt.setInt(2, productid);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new ProductExceptions("Modification Failed\nEnter Valid Product Id");
		}
		return false;
	}

	@Override
	public ArrayList<ProductBean> getProduct(int productid) {
		ArrayList<ProductBean> a = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query"))) {

			pstmt.setInt(1, productid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productBean = new ProductBean();
				productBean.setProductName(rs.getString(1));
				productBean.setProductId(rs.getInt(2));
				a.add(productBean);
				return a;
			}

		} catch (Exception e) {
		}
		throw new ProductExceptions("Product Cannot be Found\nEnter Valid Product Id");
	}

	@Override
	public ArrayList<ProductBean> getAllProduct() {
		ArrayList<ProductBean> a = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query1"))) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productBean = new ProductBean();
				productBean.setProductName(rs.getString(1));
				productBean.setProductId(rs.getInt(2));
				a.add(productBean);
			}
			return a;

		} catch (Exception e) {
		}
		throw new ProductExceptions("No Products Present");
	}

}
