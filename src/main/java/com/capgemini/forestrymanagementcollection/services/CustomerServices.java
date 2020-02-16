package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;

public interface CustomerServices {
	public boolean addCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerId);

	public boolean modifyCustomerName(int customerId, String name);

	public boolean modifyCustomerAdd(int customerId, String add);

	public boolean modifyCustomerEmail(int customerId, String email);

	public boolean modifyCustomerPost(int customerId, int post);

	public boolean modifyCustomerTelephone(int customerId, int telephone);

	public boolean modifyCustomerTown(int customerId, String town);

	public List<CustomerBean> showAllCustomer(CustomerBean bean);

	public List<CustomerBean> searchCustomer(int customerId);
}
