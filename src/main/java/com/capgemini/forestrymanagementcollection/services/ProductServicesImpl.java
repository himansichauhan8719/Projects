package com.capgemini.forestrymanagementcollection.services;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;
import com.capgemini.forestrymanagementcollection.dao.ProductDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class ProductServicesImpl implements ProductServices {
	private ProductDao productDao = Factory.prodImpl();

	@Override
	public boolean addProduct(ProductBean bean) {
		return productDao.addProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public boolean modifyProduct(int productId, String prodName) {
		return productDao.modifyProduct(productId, prodName);
	}

	@Override
	public ProductBean getProduct(int productId) {
		return productDao.getProduct(productId);
	}

}
