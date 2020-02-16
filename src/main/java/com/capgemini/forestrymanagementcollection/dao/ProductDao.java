package com.capgemini.forestrymanagementcollection.dao;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean bean);

	public boolean deleteProduct(int prodid);

	public boolean modifyProduct(int prodId, String prodName);

	public ProductBean getProduct(int prodid);
}
