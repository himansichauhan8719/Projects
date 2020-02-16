package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Contracts;

class ContractDaoTest {

	private static ContractDao contractDao = new ContractDaoImpl();
	private static Contracts contract = new Contracts();
	
	@BeforeAll
	static void addContracts() {
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		contractDao.addContract(contract);
	}
	
	@AfterAll
	static void delete() {
		contractDao.deleteContract(contract.getContractNo());
	}
	
	@Test
	void testAddContract() {
		Contracts contract1 = new Contracts();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProdId(30);
		contract1.setQuantity("10");
		contract1.setDeliveryDate("Not Scheduled");
		contract1.setStatus("pending");
		assertTrue(contractDao.addContract(contract1));
		contractDao.deleteContract(contract1.getContractNo());
		
	}

	@Test
	void testDeleteContract() {
		Contracts contract1 = new Contracts();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProdId(30);
		contract1.setQuantity("10");
		contract1.setDeliveryDate("Not Scheduled");
		contract1.setStatus("pending");
		contractDao.addContract(contract1);
		contractDao.deleteContract(contract1.getContractNo());
	}

	@Test
	void testGetContract() {
		assertNotNull(contractDao.getContract(contract.getContractNo()));
	}

	@Test
	void testGetAllContract() {
		assertNotNull(contractDao.getAllContract());
	}

	@Test
	void testScheduleContracts() {
		assertTrue(contractDao.scheduleContracts(contract.getContractNo(), "22/02/2020", "100U", "Approve"));
	}

}
