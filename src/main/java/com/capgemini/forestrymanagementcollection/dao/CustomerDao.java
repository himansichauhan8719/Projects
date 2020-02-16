package com.capgemini.forestrymanagementcollection.dao;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;

public interface CustomerDao {
	public boolean addCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerId);

	public boolean modifyCustomerName(int customerId, String name);

	public boolean modifyCustomerAdd(int customerId, String customerAddress);

	public boolean modifyCustomerEmail(int customerId, String email);

	public boolean modifyCustomerPost(int customerId, int post);

	public boolean modifyCustomerTelephone(int customerId, int telephone);

	public boolean modifyCustomerTown(int customerId, String town);

	public List<CustomerBean> showAllCustomer(CustomerBean customerBean);

	public List<CustomerBean> searchCustomer(int customerId);
}
