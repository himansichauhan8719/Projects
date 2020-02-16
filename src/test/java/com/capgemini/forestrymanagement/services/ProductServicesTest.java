package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Product;

class ProductServicesTest {

	private ProductServices productServices = new ProductServicesImpl();
	Product product = new Product();
	
	@Test
	void testAddProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		assertTrue(productServices.addProduct(product));
		productServices.deleteProduct(product.getProductId());
		
	}

	@Test
	void testDeleteProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productServices.addProduct(product);
		
		assertTrue(productServices.deleteProduct(product.getProductId()));


	}

	@Test
	void testModifyProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productServices.addProduct(product);
		assertTrue(productServices.modifyProduct(product.getProductId(), "Stones"));
		productServices.deleteProduct(product.getProductId());
	}



	@Test
	void testGetAllProduct() {
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productServices.addProduct(product);
		assertNotNull(productServices.getAllProduct());
		productServices.deleteProduct(product.getProductId());
	}


}
