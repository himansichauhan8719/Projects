package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ProductBean;

class ProductDaoTest {

	private static ProductDao productDao = new ProductDaoImpl();
	static ProductBean  productBean = new ProductBean();

		
	@BeforeAll
	static void addProducts( ) {
		productBean.setProductId(55);
		productBean.setProductName("Wood");
		productDao.addProduct(productBean);
	}
	
	@BeforeAll
	static void deleteProduct() {
		productDao.deleteProduct(productBean.getProductId());
		
	}
	@Test
	void testAddProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(44);
		productBean1.setProductName("Wood");
		assertTrue(productDao.addProduct(productBean1));
		productDao.deleteProduct(productBean1.getProductId());

	
	}

	@Test
	void testDeleteProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(55);
		productBean1.setProductName("Wood");
		productDao.addProduct(productBean1);
		assertTrue(productDao.deleteProduct(productBean1.getProductId()));
	}

	@Test
	void testModifyProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(60);
		productBean1.setProductName("Wood");
		productDao.addProduct(productBean1);
		assertTrue(productDao.modifyProduct(productBean1.getProductId(), "stone"));
		productDao.deleteProduct(productBean1.getProductId());
		
	}


	@Test
	void testGetAllProduct() {
		assertNotNull(productDao.getAllProduct());
	}

}
