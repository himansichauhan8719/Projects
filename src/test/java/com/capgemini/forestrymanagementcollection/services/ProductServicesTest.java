package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;

class ProductServicesTest {

	private ProductServices productServices = new ProductServicesImpl();
	ProductBean bean = new ProductBean();
	
	@BeforeEach
	public void addProducts( ) {
		bean.setProductId(10);
		bean.setProductName("Wood");
		productServices.addProduct(bean);
		
	}
	
	@Test
	void testAddProduct() {
		ProductBean bean1 = new ProductBean();
		bean1.setProductId(20);
		bean1.setProductName("asdasd");
		boolean added =  productServices.addProduct(bean1);
		assertTrue(added);
	}

	@Test
	void testDeleteProduct() {
		ProductBean bean = new ProductBean();
		bean.setProductId(20);
				
			boolean deleted;
			try {
				deleted = productServices.deleteProduct(bean.getProductId());
			} catch (Exception e) {
				deleted = false;
			}
			assertFalse(deleted);
	}

	@Test
	void testModifyProduct() {
		boolean modify = productServices.modifyProduct(bean.getProductId(), "Timber");
		assertTrue(modify);
	}

	@Test
	void testGetProduct() {
		ProductBean productBean;
		try {
			productBean = productServices.getProduct(20);
		} catch (Exception e) {
			productBean = null;
		}
		assertNull(productBean);

	}


}
