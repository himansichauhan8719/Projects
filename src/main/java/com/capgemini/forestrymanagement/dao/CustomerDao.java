package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);

	public Customer getCustomer(int customerId);

	public ArrayList<Customer> getAllCust();

	public boolean modifyCustomer(int customerId, String customerName);

	public boolean modifyCustomerAdd1(int customerId, String address1);

	public boolean modifyCustomerAdd2(int customerId, String address2);

	public boolean modifyCustomerTown(int customerId, String town);

	public boolean modifyCustomerEmail(int customerId, String emailId);

	public boolean modifyCustomerPost(int customerId, int postCode);

	public boolean modifyCustomerTel(int customerId, long telephone);

}
