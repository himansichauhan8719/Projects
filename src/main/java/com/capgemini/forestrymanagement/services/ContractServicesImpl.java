package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dao.ContractDao;
import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.factory.Factory;

public class ContractServicesImpl implements ContractServices {

	ContractDao contractDao = Factory.getContractDaoImpl();

	@Override
	public boolean addContract(Contracts contract) {
		return contractDao.addContract(contract);
	}

	@Override
	public boolean deleteContract(int contractId) {
		return contractDao.deleteContract(contractId);
	}

	@Override
	public Contracts getContract(int contractNo) {
		return contractDao.getContract(contractNo);
	}

	@Override
	public ArrayList<Contracts> getAllContract() {
		return contractDao.getAllContract();
	}

	@Override
	public boolean scheduleContracts(int contractId, String date, String qty, String status) {
		return contractDao.scheduleContracts(contractId, date, qty, status);
	}

}
