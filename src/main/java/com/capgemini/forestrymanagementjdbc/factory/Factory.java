package com.capgemini.forestrymanagementjdbc.factory;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.dao.AdminDao;
import com.capgemini.forestrymanagementjdbc.dao.AdminDaoImpl;
import com.capgemini.forestrymanagementjdbc.dao.ClientDao;
import com.capgemini.forestrymanagementjdbc.dao.ClientDaoImpl;
import com.capgemini.forestrymanagementjdbc.dao.ContractorDao;
import com.capgemini.forestrymanagementjdbc.dao.ContractorDaoImpl;
import com.capgemini.forestrymanagementjdbc.dao.CustomerDao;
import com.capgemini.forestrymanagementjdbc.dao.CustomerDaoImpl;
import com.capgemini.forestrymanagementjdbc.dao.ProductDao;
import com.capgemini.forestrymanagementjdbc.dao.ProductDaoImpl;
import com.capgemini.forestrymanagementjdbc.services.AdminService;
import com.capgemini.forestrymanagementjdbc.services.AdminServiceImpl;
import com.capgemini.forestrymanagementjdbc.services.ClientServicesImpl;
import com.capgemini.forestrymanagementjdbc.services.ClientSevices;
import com.capgemini.forestrymanagementjdbc.services.ContractorServiceImpl;
import com.capgemini.forestrymanagementjdbc.services.ContractorServices;
import com.capgemini.forestrymanagementjdbc.services.CustomerServices;
import com.capgemini.forestrymanagementjdbc.services.CustomerServicesImpl;
import com.capgemini.forestrymanagementjdbc.services.ProductServices;
import com.capgemini.forestrymanagementjdbc.services.ProductServicesImpl;

public class Factory {
	private Factory() {

	}

	/* Products Factory */
	public static ProductDao getProdDao() {
		ProductDao dao = new ProductDaoImpl();
		return dao;
	}

	public static ProductServices getProdServ() {
		ProductServices serv = new ProductServicesImpl();
		return serv;
	}

	public static ProductBean getProdBean() {
		ProductBean bean = new ProductBean();
		return bean;
	}

	/* Contractor Factory */
	public static ContractorDao getContrDao() {
		ContractorDao dao = new ContractorDaoImpl();
		return dao;
	}

	public static ContractorServices getContrServ() {
		ContractorServices serv = new ContractorServiceImpl();
		return serv;
	}

	public static ContractorBean getContrBean() {
		ContractorBean bean = new ContractorBean();
		return bean;
	}

	/* Customer Factory */
	public static CustomerServices getCustServ() {
		CustomerServices serv = new CustomerServicesImpl();
		return serv;
	}

	public static CustomerDao getCustDao() {
		CustomerDao dao = new CustomerDaoImpl();
		return dao;
	}

	public static CustomerBean getCustBean() {
		CustomerBean bean = new CustomerBean();
		return bean;
	}

	/* Admin Factory */
	public static AdminBean getAdminBean() {
		return new AdminBean();
	}

	public static AdminService getAdminServ() {
		return (AdminService) new AdminServiceImpl();
	}

	public static AdminDao getAdminDao() {
		return new AdminDaoImpl();
	}

	// Clients
	public static ClientSevices getClientServ() {
		return new ClientServicesImpl();
	}

	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}

	public static ClientBean getClientBean() {
		return new ClientBean();
	}

}
