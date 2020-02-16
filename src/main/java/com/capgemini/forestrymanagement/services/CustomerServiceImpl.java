package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dao.CustomerDao;
import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.factory.Factory;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao = Factory.getCustomerDaoImpl();

	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public ArrayList<Customer> getAllCust() {
		return customerDao.getAllCust();
	}

	@Override
	public boolean modifyCustomer(int customerId, String customerName) {
		return customerDao.modifyCustomer(customerId, customerName);
	}

	@Override
	public boolean modifyCustomerAdd1(int customerId, String address1) {
		return customerDao.modifyCustomerAdd1(customerId, address1);
	}

	@Override
	public boolean modifyCustomerAdd2(int customerId, String address2) {
		return customerDao.modifyCustomerAdd2(customerId, address2);
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		return customerDao.modifyCustomerTown(customerId, town);
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String emailId) {
		return customerDao.modifyCustomerEmail(customerId, emailId);
	}

	@Override
	public boolean modifyCustomerPost(int customerId, int postCode) {
		return customerDao.modifyCustomerPost(customerId, postCode);
	}

	@Override
	public boolean modifyCustomerTel(int customerId, long telephone) {
		return customerDao.modifyCustomerTel(customerId, telephone);
	}

}
