package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;
import com.capgemini.forestrymanagementcollection.exception.ProductExceptions;

public class ProductDaoImpl implements ProductDao {
	List<ProductBean> list = new ArrayList<ProductBean>();
	ProductBean productBean = new ProductBean();
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean addProduct(ProductBean bean) {
		for (ProductBean productBean : list) {
			if (productBean.getProductId() == bean.getProductId()) {
				throw new ProductExceptions("Product Id Already Existed");
			}
		}
		list.add(bean);
		return true;
	}

	@Override
	public boolean deleteProduct(int prodId) {
		for (ProductBean productBean : list) {
			if (productBean.getProductId() == prodId) {
				list.remove(productBean);
				return true;
			}
		}
		throw new ProductExceptions("Product Cannot be deleted");
	}

	@Override
	public boolean modifyProduct(int prodid, String productName) {
		for (ProductBean productBean : list) {
			if (productBean.getProductId() == prodid) {
				productBean.setProductName(productName);
				return true;
			}
		}
		throw new ProductExceptions("Product Cannot be Modified");
	}

	@Override
	public ProductBean getProduct(int prodId) {
		for (ProductBean productBean : list) {
			if (productBean.getProductId() == prodId) {
				return productBean;
			}
		}
		throw new ProductExceptions("Product Cannot be Found");
	}

}
