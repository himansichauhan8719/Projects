package com.capgemini.forestrymanagementspringboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.ContractDao;
import com.capgemini.forestrymanagementspringboot.dao.CustomerDao;
import com.capgemini.forestrymanagementspringboot.dao.ProductDao;
import com.capgemini.forestrymanagementspringboot.dto.Contracts;

@Service
public class ContractServicesImpl implements ContractServices {
	@Autowired
	private ContractDao contractDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ProductDao ProductDao;
	
	@Override
	public boolean addContract(Contracts contracts) {
		contracts.setDeliveryDate("Not Scheduled");
		contracts.setStatus("pending");
		
		if (ProductDao.getProduct(contracts.getProdId()) == null || 
				customerDao.getCustomer(contracts.getCustomerId()) == null) {
			
		}
		return contractDao.addContract(contracts);
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
	public boolean scheduleContracts(Contracts contract) {
		
		return contractDao.scheduleContracts(contract);
	}

}
