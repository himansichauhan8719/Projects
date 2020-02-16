package com.capgemini.forestrymanagementjdbc.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;

public interface ContractorServices {

	public boolean addContractor(ContractorBean contractor);

	public boolean deleteContractor(int contractid);

	public ArrayList<ContractorBean> getContractor(int contractno);

	public ArrayList<ContractorBean> getAllContractor();

	public boolean sheduleContract(int contractNo, String deliveryDate, String status);

}
