package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Product;

public interface ProductDao {
	public boolean addProduct(Product p);

	public boolean deleteProduct(int productId);

	public boolean modifyProduct(int productId, String productName);

	public Product getProduct(int productId);

	public ArrayList<Product> getAllProduct();

}
