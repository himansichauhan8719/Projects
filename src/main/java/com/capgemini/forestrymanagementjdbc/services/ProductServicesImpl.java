package com.capgemini.forestrymanagementjdbc.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.dao.ProductDao;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class ProductServicesImpl implements ProductServices {

	ProductDao productDao = Factory.getProdDao();

	@Override
	public boolean addProduct(ProductBean bean) {
		return productDao.addProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productid) {
		return productDao.deleteProduct(productid);
	}

	@Override
	public boolean modifyProduct(int productid, String productname) {
		// TODO Auto-generated method stub
		return productDao.modifyProduct(productid, productname);
	}

	@Override
	public ArrayList<ProductBean> getProduct(int productid) {

		return productDao.getProduct(productid);
	}

	@Override
	public ArrayList<ProductBean> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

}
