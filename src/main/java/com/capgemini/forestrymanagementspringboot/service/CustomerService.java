package com.capgemini.forestrymanagementspringboot.service;

import java.util.ArrayList;

import com.capgemini.forestrymanagementspringboot.dto.Customer;

public interface CustomerService {

	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);

	public Customer getCustomer(int customerId);

	public ArrayList<Customer> getAllCust();

	public boolean modifyCustomer(Customer customer);


}
