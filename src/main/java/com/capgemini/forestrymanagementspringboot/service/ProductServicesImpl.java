package com.capgemini.forestrymanagementspringboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.ProductDao;
import com.capgemini.forestrymanagementspringboot.dto.Product;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public boolean modifyProduct(int productId, String productName) {
		return productDao.modifyProduct(productId, productName);
	}

	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

}
