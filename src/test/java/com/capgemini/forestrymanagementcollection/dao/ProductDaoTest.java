package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;
import com.capgemini.forestrymanagementcollection.dao.ProductDao;
import com.capgemini.forestrymanagementcollection.dao.ProductDaoImpl;

class ProductDaoTest {

	private ProductDao productDao = new ProductDaoImpl();
	ProductBean bean = new ProductBean();
	
	@BeforeEach
	public void addProducts( ) {
		bean.setProductId(10);
		bean.setProductName("Wood");
		productDao.addProduct(bean);
		
	}
	
	@Test
	void testAddProduct() {
		ProductBean bean1 = new ProductBean();
		bean1.setProductId(20);
		bean1.setProductName("asdasd");
		boolean added =  productDao.addProduct(bean1);
		assertTrue(added);
	}

	@Test
	void testDeleteProduct() {
		ProductBean bean = new ProductBean();
		bean.setProductId(20);
				
			boolean deleted;
			try {
				deleted = productDao.deleteProduct(bean.getProductId());
			} catch (Exception e) {
				deleted = false;
			}
			assertFalse(deleted);
	}

	@Test
	void testModifyProduct() {
		boolean modify = productDao.modifyProduct(bean.getProductId(), "Timber");
		assertTrue(modify);
	}

	@Test
	void testGetProduct() {
		ProductBean productBean;
		try {
			productBean = productDao.getProduct(20);
		} catch (Exception e) {
			productBean = null;
		}
		assertNull(productBean);

	}

}
