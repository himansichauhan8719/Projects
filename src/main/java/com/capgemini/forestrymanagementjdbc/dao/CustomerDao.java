package com.capgemini.forestrymanagementjdbc.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;

public interface CustomerDao {
	public boolean addCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerid);

	public ArrayList<CustomerBean> getCustomer(int customerid);

	public ArrayList<CustomerBean> getAllCust();

	public boolean modifyCustomerName(int customerId, String customerName);

	public boolean modifyCustomerStreet1(int customerId, String streetAdd1);

	public boolean modifyCustomerStreet2(int customerId, String streetAdd2);

	public boolean modifyCustomerTown(int customerId, String town);

	public boolean modifyCustomerPostalCode(int customerId, int postalCode);

	public boolean modifyCustomerEmail(int customerId, String email);


	boolean modifyCustomerTelephone(int customerId, long telephone);


}
