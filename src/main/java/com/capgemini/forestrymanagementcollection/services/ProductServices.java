package com.capgemini.forestrymanagementcollection.services;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;

public interface ProductServices {
	public boolean addProduct(ProductBean bean);

	public boolean deleteProduct(int productId);

	public boolean modifyProduct(int productId, String productName);

	public ProductBean getProduct(int productId);
}
