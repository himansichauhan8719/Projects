package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;
import com.capgemini.forestrymanagementcollection.dao.CustomerDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class CustomerServicesImpl implements CustomerServices {
	private CustomerDao customerDao = Factory.cstDao();

	@Override
	public boolean addCustomer(CustomerBean bean) {
		return customerDao.addCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public List<CustomerBean> showAllCustomer(CustomerBean bean) {
		return customerDao.showAllCustomer(bean);
	}

	@Override
	public List<CustomerBean> searchCustomer(int customerId) {
		return customerDao.searchCustomer(customerId);
	}

	@Override
	public boolean modifyCustomerName(int customerId, String name) {
		return customerDao.modifyCustomerName(customerId, name);
	}

	@Override
	public boolean modifyCustomerAdd(int customerId, String add) {
		return customerDao.modifyCustomerAdd(customerId, add);
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String email) {
		return customerDao.modifyCustomerEmail(customerId, email);
	}

	@Override
	public boolean modifyCustomerPost(int customerId, int post) {
		return customerDao.modifyCustomerPost(customerId, post);
	}

	@Override
	public boolean modifyCustomerTelephone(int customerId, int telephone) {
		return customerDao.modifyCustomerTelephone(customerId, telephone);
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		return customerDao.modifyCustomerTown(customerId, town);
	}

}
