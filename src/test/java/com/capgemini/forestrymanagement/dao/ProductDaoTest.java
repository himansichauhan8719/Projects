package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Product;


class ProductDaoTest {

	private ProductDao productDao = new ProductDaoImpl();
	Product product = new Product();
	
	@Test
	void testAddProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		assertTrue(productDao.addProduct(product));
		productDao.deleteProduct(product.getProductId());
		
	}

	@Test
	void testDeleteProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productDao.addProduct(product);
		
		assertTrue(productDao.deleteProduct(product.getProductId()));


	}

	@Test
	void testModifyProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productDao.addProduct(product);
		assertTrue(productDao.modifyProduct(product.getProductId(), "Stones"));
		productDao.deleteProduct(product.getProductId());
	}



	@Test
	void testGetAllProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productDao.addProduct(product);
		assertNotNull(productDao.getAllProduct());
		productDao.deleteProduct(product.getProductId());
	}

}
