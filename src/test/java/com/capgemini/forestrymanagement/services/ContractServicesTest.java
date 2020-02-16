package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Contracts;

class ContractServicesTest {

	private static ContractServices contractServices = new ContractServicesImpl();
	private static Contracts contract = new Contracts();
	
	@BeforeAll
	static void addContracts() {
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		contractServices.addContract(contract);
	}
	
	@AfterAll
	static void delete() {
		contractServices.deleteContract(contract.getContractNo());
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
		assertTrue(contractServices.addContract(contract1));
		contractServices.deleteContract(contract1.getContractNo());
		
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
		contractServices.addContract(contract1);
		contractServices.deleteContract(contract1.getContractNo());
	}

	@Test
	void testGetContract() {
		assertNotNull(contractServices.getContract(contract.getContractNo()));
	}

	@Test
	void testGetAllContract() {
		assertNotNull(contractServices.getAllContract());
	}

	@Test
	void testScheduleContracts() {
		assertTrue(contractServices.scheduleContracts(contract.getContractNo(), "22/02/2020", "100U", "Approve"));
	}

}
