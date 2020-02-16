package com.capgemini.forestrymanagementjdbc.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementjdbc.dao.CustomerDao;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDao customerDao = Factory.getCustDao();

	@Override
	public boolean addCustomer(CustomerBean bean) {
		return customerDao.addCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerid) {
		return customerDao.deleteCustomer(customerid);
	}

	@Override
	public ArrayList<CustomerBean> getCustomer(int customerid) {
		return customerDao.getCustomer(customerid);
	}

	@Override
	public ArrayList<CustomerBean> getAllCust() {
		return customerDao.getAllCust();
	}

	@Override
	public boolean modifyCustomerName(int customerId, String customerName) {
		return customerDao.modifyCustomerName(customerId, customerName);
	}

	@Override
	public boolean modifyCustomerStreet1(int customerId, String streetAdd1) {
		return customerDao.modifyCustomerStreet1(customerId, streetAdd1);
	}

	@Override
	public boolean modifyCustomerStreet2(int customerId, String streetAdd2) {
		return customerDao.modifyCustomerStreet2(customerId, streetAdd2);
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		return customerDao.modifyCustomerTown(customerId, town);
	}

	@Override
	public boolean modifyCustomerPostalCode(int customerId, int postalCode) {
		return customerDao.modifyCustomerPostalCode(customerId, postalCode);
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String email) {
		return customerDao.modifyCustomerEmail(customerId, email);
	}

	@Override
	public boolean modifyCustomerTelephone(int customerId, long telephone) {
		return customerDao.modifyCustomerTelephone(customerId, telephone);
	}

}
