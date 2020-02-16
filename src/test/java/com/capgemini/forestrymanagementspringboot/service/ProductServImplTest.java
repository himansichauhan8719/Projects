package com.capgemini.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Product;
import com.capgemini.forestrymanagementspringboot.exception.ProductExceptions;


@SpringBootTest
class ProductServImplTest {

	@Autowired
	private ProductServices products;
	private Product bean = null; 
	 
	@Test
	void testAddProduct() {
		bean = new Product();
		bean.setProductId(111);
		bean.setProductName("silk");
	
		boolean flag = products.addProduct(bean);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				products.addProduct(bean);
			});
		}
	}
	
	@Test
	void testAllProduct() {
		try {
		List<Product> bean = products.getAllProduct();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ProductExceptions.class, ()->{
			products.getAllProduct();
		});
	}

}
	
	@Test
	void testGetProduct() {
		int productId = 43;
		try {
			Product cust = products.getProduct(productId);
			assertNotNull(cust);
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				products.getProduct(3);
				});
		}
	}
	
	@Test
	void testDeleteProduct() {
		int productId = 92;
		try {
			boolean check = products.deleteProduct(productId);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				products.deleteProduct(productId);
				});
		}
	}

}
