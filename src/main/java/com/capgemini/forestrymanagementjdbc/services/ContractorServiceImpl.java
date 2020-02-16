package com.capgemini.forestrymanagementjdbc.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.dao.ContractorDao;
import com.capgemini.forestrymanagementjdbc.factory.Factory;

public class ContractorServiceImpl implements ContractorServices {

	ContractorDao contractDaao = Factory.getContrDao();

	@Override
	public boolean addContractor(ContractorBean contractor) {
		return contractDaao.addContractor(contractor);
	}

	@Override
	public boolean deleteContractor(int contractid) {
		// TODO Auto-generated method stub
		return contractDaao.deleteContractor(contractid);
	}

	@Override
	public ArrayList<ContractorBean> getContractor(int contractno) {
		return contractDaao.getContractor(contractno);
	}

	@Override
	public ArrayList<ContractorBean> getAllContractor() {
		// TODO Auto-generated method stub
		return contractDaao.getAllContractor();
	}

	@Override
	public boolean sheduleContract(int contractNo, String deliveryDate, String status) {
		return contractDaao.sheduleContract(contractNo, deliveryDate, status);
	}

}
