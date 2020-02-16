package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Product;
import com.capgemini.forestrymanagementspringboot.exception.ProductExceptions;


@SpringBootTest
class ProductDaoImplTest {

	@Autowired
	private ProductDao productdao;
	private Product bean = null; 
	 
	@Test
	void testAddProduct() {
		bean = new Product();
		bean.setProductId(111);
		bean.setProductName("silk");
	
		boolean flag = productdao.addProduct(bean);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				productdao.addProduct(bean);
			});
		}
	}
	
	@Test
	void testAllProduct() {
		try {
		List<Product> bean = productdao.getAllProduct();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ProductExceptions.class, ()->{
			productdao.getAllProduct();
		});
	}

}
	
	@Test
	void testGetProduct() {
		int productId = 43;
		try {
			Product cust = productdao.getProduct(productId);
			assertNotNull(cust);
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				productdao.getProduct(3);
				});
		}
	}
	
	@Test
	void testDeleteProduct() {
		int productId = 92;
		try {
			boolean check = productdao.deleteProduct(productId);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ProductExceptions.class, ()->{
				productdao.deleteProduct(productId);
				});
		}
	}

}
