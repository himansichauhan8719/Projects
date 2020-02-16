package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Contracts;

public interface ContractServices {

	public boolean addContract(Contracts contract);

	public boolean deleteContract(int contractId);

	public Contracts getContract(int contractNo);

	public ArrayList<Contracts> getAllContract();

	public boolean scheduleContracts(int contractId, String date, String quantity, String status);

}
