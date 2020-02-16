package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.dao.ContractorDao;
import com.capgemini.forestrymanagementjdbc.dao.ContractorDaoImpl;

class ContractorServicesTest {

	private static ContractorServices contractServices = new ContractorServiceImpl();
	private static ContractorBean contract = new ContractorBean();
	
	@BeforeAll
	static void addContracts() {
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProductId(30);
		contract.setDeliDate("Not Scheduled");
		contract.setStatus("pending");
		contractServices.addContractor(contract);
	}
	
	@AfterAll
	static void delete() {
		contractServices.deleteContractor(contract.getContractNo());
	}
	
	@Test
	void testAddContractor() {
		ContractorBean contract1 = new ContractorBean();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProductId(30);
		contract1.setDeliDate("Not Scheduled");
		contract1.setStatus("pending");
		assertTrue(contractServices.addContractor(contract1));
		contractServices.deleteContractor(contract1.getContractNo());
	}

	@Test
	void testDeleteContractor() {
		ContractorBean contract1 = new ContractorBean();
		contract1.setContractNo(7860);
		contract1.setCustomerId(20);
		contract1.setProductId(30);
		contract1.setDeliDate("Not Scheduled");
		contract1.setStatus("pending");
		contractServices.addContractor(contract1);
		contractServices.deleteContractor(contract1.getContractNo());
	}

	@Test
	void testGetContractor() {
		assertNotNull(contractServices.getContractor(contract.getContractNo()));
	}

	@Test
	void testGetAllContractor() {
		assertNotNull(contractServices.getAllContractor());
	}

	@Test
	void testSheduleContract() {
		assertTrue(contractServices.sheduleContract(contract.getContractNo(), "as", "approved"));
	}

}
