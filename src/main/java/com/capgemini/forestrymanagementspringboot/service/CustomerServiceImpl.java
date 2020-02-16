package com.capgemini.forestrymanagementspringboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.CustomerDao;
import com.capgemini.forestrymanagementspringboot.dto.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao ; 

	@Override
	public boolean addCustomer(Customer c) {
		return customerDao.addCustomer(c);
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
	public boolean modifyCustomer(Customer customer) {
		return customerDao.modifyCustomer(customer);
	}

	 
}
