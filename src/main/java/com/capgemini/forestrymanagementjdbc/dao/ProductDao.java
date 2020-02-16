package com.capgemini.forestrymanagementjdbc.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.ProductBean;

public interface ProductDao {

	public boolean addProduct(ProductBean bean);

	public boolean deleteProduct(int productid);

	public boolean modifyProduct(int productid, String productname);

	public ArrayList<ProductBean> getProduct(int productid);

	public ArrayList<ProductBean> getAllProduct();
}
