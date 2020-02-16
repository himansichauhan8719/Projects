package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;
import com.capgemini.forestrymanagementcollection.dao.ContractDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class ContractServicesImpl implements ContractServices {
	private ContractDao contractDao = Factory.objDao();

	@Override
	public boolean addContract(ContractBean contract) {
		return contractDao.addContract(contract);
	}

	@Override
	public boolean deleteContract(int contractNo) {
		return contractDao.deleteContract(contractNo);
	}

	@Override
	public List<ContractBean> showContract(int contactNo) {
		return contractDao.showContract(contactNo);
	}

	@Override
	public List<ContractBean> showAllContract() {
		return contractDao.showAllContract();
	}

	@Override
	public boolean sheduleContract(int contractNo, String deliveryDate, String status) {
		return contractDao.sheduleContract(contractNo, deliveryDate, status);
	}

}
