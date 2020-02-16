package com.capgemini.forestrymanagementcollection.factory;

import com.capgemini.forestrymanagementcollection.bean.AdminBean;
import com.capgemini.forestrymanagementcollection.bean.ClientBean;
import com.capgemini.forestrymanagementcollection.dao.AdminDao;
import com.capgemini.forestrymanagementcollection.dao.AdminDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.ClientDao;
import com.capgemini.forestrymanagementcollection.dao.ClientDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.ContractDao;
import com.capgemini.forestrymanagementcollection.dao.ContractDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.CustomerDao;
import com.capgemini.forestrymanagementcollection.dao.CustomerDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.LandDao;
import com.capgemini.forestrymanagementcollection.dao.LandDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.ProductDao;
import com.capgemini.forestrymanagementcollection.dao.ProductDaoImpl;
import com.capgemini.forestrymanagementcollection.dao.SchedulerDao;
import com.capgemini.forestrymanagementcollection.dao.SchedulerDaoImpl;
import com.capgemini.forestrymanagementcollection.services.AdminServices;
import com.capgemini.forestrymanagementcollection.services.AdminServicesImpl;
import com.capgemini.forestrymanagementcollection.services.ClientServices;
import com.capgemini.forestrymanagementcollection.services.ClientServicesImpl;
import com.capgemini.forestrymanagementcollection.services.ContractServices;
import com.capgemini.forestrymanagementcollection.services.ContractServicesImpl;
import com.capgemini.forestrymanagementcollection.services.CustomerServices;
import com.capgemini.forestrymanagementcollection.services.CustomerServicesImpl;
import com.capgemini.forestrymanagementcollection.services.LandServices;
import com.capgemini.forestrymanagementcollection.services.LandServicesImpl;
import com.capgemini.forestrymanagementcollection.services.ProductServices;
import com.capgemini.forestrymanagementcollection.services.ProductServicesImpl;
import com.capgemini.forestrymanagementcollection.services.SchedulerServices;
import com.capgemini.forestrymanagementcollection.services.SchedulerServicesImpl;

public class Factory {
	private Factory() {

	}

	public static ContractDao objDao() {
		ContractDao dao = new ContractDaoImpl();
		return dao;
	}

	public static CustomerDao cstDao() {
		CustomerDao dao1 = new CustomerDaoImpl();
		return dao1;
	}

	public static ProductDao prodImpl() {
		ProductDao dao2 = new ProductDaoImpl();
		return dao2;
	}

	public static AdminDao adminImpl() {
		AdminDao dao = new AdminDaoImpl();
		return dao;
	}

	public static AdminBean adminBeanimp() {
		AdminBean bean = new AdminBean();
		return bean;

	}

	public static ClientDao clientIml() {
		return new ClientDaoImpl();
	}

	public static ClientBean clientBean() {
		return new ClientBean();
	}

	public static SchedulerDao getSchedulerDaoImpl() {
		return new SchedulerDaoImpl();

	}

	public static LandDao getLandDao() {
		LandDao dao = (LandDao) new LandDaoImpl();
		return dao;
	}

	// ------------Services------------
	public static AdminServices getAdminServices() {
		return new AdminServicesImpl();
	}

	public static ClientServices getClientServices() {
		return new ClientServicesImpl();
	}

	public static ContractServices getContractServices() {
		return new ContractServicesImpl();
	}

	public static CustomerServices getCustomerServices() {
		return new CustomerServicesImpl();
	}

	public static LandServices getLandServices() {
		return new LandServicesImpl();
	}

	public static ProductServices getProductService() {
		return (ProductServices) new ProductServicesImpl();
	}

	public static SchedulerServices getSchedulerServices() {
		return new SchedulerServicesImpl();
	}

}
