package com.capgemini.forestrymanagement.factory;

import com.capgemini.forestrymanagement.dao.AdminDao;
import com.capgemini.forestrymanagement.dao.AdminDaoImpl;
import com.capgemini.forestrymanagement.dao.ClientDao;
import com.capgemini.forestrymanagement.dao.ClientDaoImpl;
import com.capgemini.forestrymanagement.dao.ContractDao;
import com.capgemini.forestrymanagement.dao.ContractDaoImpl;
import com.capgemini.forestrymanagement.dao.CustomerDao;
import com.capgemini.forestrymanagement.dao.CustomerDaoImpl;
import com.capgemini.forestrymanagement.dao.LandDao;
import com.capgemini.forestrymanagement.dao.LandDaoImpl;
import com.capgemini.forestrymanagement.dao.ProductDao;
import com.capgemini.forestrymanagement.dao.ProductDaoImpl;
import com.capgemini.forestrymanagement.dao.SchedulerDao;
import com.capgemini.forestrymanagement.dao.SchedulerDaoImpl;
import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.services.AdminService;
import com.capgemini.forestrymanagement.services.AdminServiceImpl;
import com.capgemini.forestrymanagement.services.ClientServices;
import com.capgemini.forestrymanagement.services.ClientServicesImpl;
import com.capgemini.forestrymanagement.services.ContractServices;
import com.capgemini.forestrymanagement.services.ContractServicesImpl;
import com.capgemini.forestrymanagement.services.CustomerService;
import com.capgemini.forestrymanagement.services.CustomerServiceImpl;
import com.capgemini.forestrymanagement.services.LandServices;
import com.capgemini.forestrymanagement.services.LandServicesImpl;
import com.capgemini.forestrymanagement.services.ProductServices;
import com.capgemini.forestrymanagement.services.ProductServicesImpl;
import com.capgemini.forestrymanagement.services.SchedulerServ;
import com.capgemini.forestrymanagement.services.SchedulerServImpl;

public class Factory {
	private Factory() {

	}

	// Contracts
	public static ContractServices getContractServImpl() {
		return new ContractServicesImpl();
	}

	public static ContractDao getContractDaoImpl() {
		return new ContractDaoImpl();
	}

	public static Contracts getContracts() {
		return new Contracts();
	}

	// Customer
	public static CustomerService getCustomerServImpl() {
		return new CustomerServiceImpl();
	}

	public static CustomerDao getCustomerDaoImpl() {
		return new CustomerDaoImpl();
	}

	public static Customer getCustomer() {
		return new Customer();
	}

	// Products
	public static ProductServices getProductServImpl() {
		return new ProductServicesImpl();
	}

	public static ProductDao getProductDaoImpl() {
		return new ProductDaoImpl();
	}

	public static Product getProduct() {
		return new Product();
	}

	// Client
	public static Client getClient() {
		return new Client();
	}

	public static ClientServices getClientService() {
		return (ClientServices) new ClientServicesImpl();
	}

	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}

	// Admin
	public static AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	public static AdminDao getAdminDao() {
		return new AdminDaoImpl();
	}

	public static Admin getAdmin() {
		Admin admin = new Admin();
		return admin;
	}

	// Scheduler
	public static Scheduler getScheduler() {
		return new Scheduler();
	}

	public static SchedulerServ getSchedulerService() {
		return new SchedulerServImpl();
	}

	public static SchedulerDao getSchedulerDao() {
		return new SchedulerDaoImpl();
	}

	// Land
	public static LandDao landDaoImpl() {
		return new LandDaoImpl();
	}

	public static Land getLand() {
		return new Land();
	}

	public static LandServices getLandService() {
		return new LandServicesImpl();
	}

}
