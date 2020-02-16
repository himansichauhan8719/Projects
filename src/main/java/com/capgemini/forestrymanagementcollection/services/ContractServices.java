package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;

public interface ContractServices {

	public boolean addContract(ContractBean contract);

	public boolean deleteContract(int contractNo);

	public List<ContractBean> showContract(int contactNo);

	public List<ContractBean> showAllContract();

	public boolean sheduleContract(int contractNo, String deliveryDate, String status);

}
