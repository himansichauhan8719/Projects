package com.capgemini.forestrymanagementjdbc.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;

public interface CustomerServices {
	public boolean addCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerId);

	public ArrayList<CustomerBean> getCustomer(int customerId);

	public ArrayList<CustomerBean> getAllCust();

	public boolean modifyCustomerName(int customerId, String customerName);

	public boolean modifyCustomerStreet1(int customerId, String streetAdd1);

	public boolean modifyCustomerStreet2(int customerId, String streetAdd2);

	public boolean modifyCustomerTown(int customerId, String town);

	public boolean modifyCustomerPostalCode(int customerId, int postalCode);

	public boolean modifyCustomerEmail(int customerId, String email);

	public boolean modifyCustomerTelephone(int customerId, long telephone);
}
