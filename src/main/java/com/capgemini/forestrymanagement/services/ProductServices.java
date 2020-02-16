package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Product;

public interface ProductServices {
	public boolean addProduct(Product product);

	public boolean deleteProduct(int productId);

	public boolean modifyProduct(int productId, String productName);

	public Product getProduct(int productId);

	public ArrayList<Product> getAllProduct();

}
