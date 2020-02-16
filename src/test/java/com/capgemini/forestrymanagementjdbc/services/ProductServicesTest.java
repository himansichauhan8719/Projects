package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ProductBean;

class ProductServicesTest {

	private static ProductServices productServices = new ProductServicesImpl();
	static ProductBean  productBean = new ProductBean();

		
	@BeforeAll
	static void addProducts( ) {
		productBean.setProductId(55);
		productBean.setProductName("Wood");
		productServices.addProduct(productBean);
	}
	
	@BeforeAll
	static void deleteProduct() {
		productServices.deleteProduct(productBean.getProductId());
		
	}
	@Test
	void testAddProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(44);
		productBean1.setProductName("Wood");
		assertTrue(productServices.addProduct(productBean1));
		productServices.deleteProduct(productBean1.getProductId());

	
	}

	@Test
	void testDeleteProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(55);
		productBean1.setProductName("Wood");
		productServices.addProduct(productBean1);
		assertTrue(productServices.deleteProduct(productBean1.getProductId()));
	}

	@Test
	void testModifyProduct() {
		ProductBean productBean1 =  new ProductBean();
		productBean1.setProductId(60);
		productBean1.setProductName("Wood");
		productServices.addProduct(productBean1);
		assertTrue(productServices.modifyProduct(productBean1.getProductId(), "stone"));
		productServices.deleteProduct(productBean1.getProductId());
		
	}


	@Test
	void testGetAllProduct() {
		assertNotNull(productServices.getAllProduct());
	}

}
