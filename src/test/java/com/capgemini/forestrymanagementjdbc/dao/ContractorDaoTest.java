package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;

class ContractorDaoTest {

	private static ContractorDao contractDao = new ContractorDaoImpl();
	private static ContractorBean contract = new ContractorBean();
	
	@BeforeAll
	static void addContracts() {
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProductId(30);
		contract.setDeliDate("Not Scheduled");
		contract.setStatus("pending");
		contractDao.addContractor(contract);
	}
	
	@AfterAll
	static void delete() {
		contractDao.deleteContractor(contract.getContractNo());
	}
	
	@Test
	void testAddContractor() {
		ContractorBean contract1 = new ContractorBean();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProductId(30);
		contract1.setDeliDate("Not Scheduled");
		contract1.setStatus("pending");
		assertTrue(contractDao.addContractor(contract1));
		contractDao.deleteContractor(contract1.getContractNo());
	}

	@Test
	void testDeleteContractor() {
		ContractorBean contract1 = new ContractorBean();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProductId(30);
		contract1.setDeliDate("Not Scheduled");
		contract1.setStatus("pending");
		contractDao.addContractor(contract1);
		contractDao.deleteContractor(contract1.getContractNo());
	}

	@Test
	void testGetContractor() {
		assertNotNull(contractDao.getContractor(contract.getContractNo()));
	}

	@Test
	void testGetAllContractor() {
		assertNotNull(contractDao.getAllContractor());
	}

	@Test
	void testSheduleContract() {
		assertTrue(contractDao.sheduleContract(contract.getContractNo(), "as", "approved"));
	}

}
