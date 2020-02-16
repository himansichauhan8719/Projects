package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;
import com.capgemini.forestrymanagementcollection.exception.CustomerExceptions;

public class CustomerDaoImpl implements CustomerDao {
	private List<CustomerBean> customerList = new ArrayList<CustomerBean>();
	CustomerBean customerBean = new CustomerBean();

	@Override
	public boolean addCustomer(CustomerBean bean) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getTelephone() == bean.getTelephone()) {
				throw new CustomerExceptions("Customer Id Already Existed");
			}
		}
		customerList.add(bean);
		return true;

	}

	@Override
	public boolean deleteCustomer(int customerId) {
		for (CustomerBean customerBean : customerList) {
			if (((customerBean.getCustomerId()) == customerId)) {
				customerList.remove(customerBean);
				return true;
			}
		}
		throw new CustomerExceptions("Customer Account Cannot be Deleted");
	}

	@Override
	public List<CustomerBean> showAllCustomer(CustomerBean customerBeans) {
			if (customerList != null) {
				return customerList;
			}
		throw new CustomerExceptions("Customer Not Present");
	}

	@Override
	public List<CustomerBean> searchCustomer(int customerId) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == customerId) {
				return customerList;
			}
		}
		throw new CustomerExceptions("Customer Cannot be Found");
	}

	@Override
	public boolean modifyCustomerName(int customerId, String name) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == customerId) {
				customerBean.setCustomerName(name);
				return true;
			}
		}
		throw new CustomerExceptions("Customer name Cannot be Modified ");
	}

	@Override
	public boolean modifyCustomerAdd(int custId, String add) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == custId) {
				customerBean.setStreetAdd1(add);
				return true;
			}
		}
		throw new CustomerExceptions("Customer Address Cannot be Modified");
	}

	@Override
	public boolean modifyCustomerEmail(int custId, String email) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == custId) {
				customerBean.setEmail(email);
				return true;
			}
		}
		throw new CustomerExceptions("Customer email Cannot be Modified");
	}

	@Override
	public boolean modifyCustomerPost(int custId, int post) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == custId) {
				customerBean.setPostalCode(post);
				return true;
			}
		}
		throw new CustomerExceptions("Customer Postal Code Cannot be Modified");
	}

	@Override
	public boolean modifyCustomerTelephone(int custId, int telephone) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == custId) {
				customerBean.setTelephone(telephone);
				return true;
			}
		}
		throw new CustomerExceptions("Customer Telephone Cannot be Modified");
	}

	@Override
	public boolean modifyCustomerTown(int custId, String town) {
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getCustomerId() == custId) {
				customerBean.setTown(town);
				return true;
			}
		}
		throw new CustomerExceptions("Customer town Cannot be Modified");
	}

}
