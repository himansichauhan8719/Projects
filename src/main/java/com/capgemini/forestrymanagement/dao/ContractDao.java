package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Contracts;

public interface ContractDao {
	public boolean addContract(Contracts c);

	public boolean deleteContract(int contractNo);

	public Contracts getContract(int contractNo);

	public ArrayList<Contracts> getAllContract();

	public boolean scheduleContracts(int contractId, String date, String qty, String status);
}
