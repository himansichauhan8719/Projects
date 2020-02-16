package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;
import com.capgemini.forestrymanagementcollection.exception.ContractsExceptions;

public class ContractDaoImpl implements ContractDao {

	private List<ContractBean> contractList = new ArrayList<ContractBean>();
	ContractBean contractBean = new ContractBean();

	@Override
	public boolean addContract(ContractBean contract) {
		for (ContractBean contractBean : contractList) {
			if (contractBean.getCustomerId() == contract.getCustomerId()) {
				throw new ContractsExceptions("Contract Id Already Existed");
			}
		}
		contractList.add(contract);
		return true;
	}

	@Override
	public boolean deleteContract(int contractNo) {
		for (ContractBean contractBean : contractList) {
			if (contractBean.getContractNo() == contractNo) {
				contractList.remove(contractBean);
				return true;
			}
		}
		throw new ContractsExceptions("Contract Cannot be Deleted");
	}

	@Override
	public List<ContractBean> showContract(int contractNo) {
		for (ContractBean contractBean : contractList) {
			System.err.println(contractBean.getContractNo());
			System.err.println(contractNo);
			if (contractBean.getContractNo() == contractNo) {
				return contractList;
			}
		}
		throw new ContractsExceptions("Contract Cannot be Found");
	}

	@Override
	public List<ContractBean> showAllContract() {
		for (ContractBean contractBean : contractList) {
			if (contractBean != null) {
				return contractList;
			}
		}
		throw new ContractsExceptions("No Contract Present");

	}

	@Override
	public boolean sheduleContract(int contractNo, String deliveryDate, String status) {
		for (ContractBean contractBean : contractList) {
			if (contractBean.getContractNo() == contractNo) {
				contractBean.setDeliveryDate(deliveryDate);
				contractBean.setStatus(status);
				return true;
			}
		}
		throw new ContractsExceptions("Contracts Cannot be Scheduled");
	}

}
