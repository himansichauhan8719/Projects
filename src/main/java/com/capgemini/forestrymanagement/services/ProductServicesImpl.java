package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dao.ProductDao;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.factory.Factory;

public class ProductServicesImpl implements ProductServices {

	ProductDao productDao = Factory.getProductDaoImpl();

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
