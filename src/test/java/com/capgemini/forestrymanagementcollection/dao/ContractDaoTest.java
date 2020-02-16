package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;

class ContractDaoTest {
	private ContractDao contractDao = new ContractDaoImpl();
	private ContractBean contractBean = new ContractBean();
	
	@BeforeEach
	void addContract() {
		contractBean.setContractNo(10);
		contractBean.setCustomerId(20);
		contractBean.setProductId(30);
		contractBean.setQuantity(10);
		contractBean.setDeliveryDate("Not Scheduled");
		contractBean.setStatus("pending");
		contractDao.addContract(contractBean);
		
	}
	
	@Test
	void testAddContract() {
		ContractBean contractBean1 = new ContractBean();
		contractBean1.setContractNo(22);
		contractBean1.setCustomerId(22);
		contractBean1.setProductId(32);
		contractBean1.setQuantity(12);
		contractBean1.setDeliveryDate("Not Scheduled");
		contractBean1.setStatus("pending");
		boolean addContract = contractDao.addContract(contractBean1);
		assertTrue(addContract);
	}

	@Test
	void testDeleteContract() {
		boolean deleteContract = contractDao.deleteContract(contractBean.getContractNo());
		assertTrue(deleteContract);
	}

	@Test
	void testShowContract() {
		List<ContractBean> contract = contractDao.showContract(contractBean.getContractNo());
		assertNotNull(contract);
	}	

	@Test
	void testShowAllContract() {
		List<ContractBean> contract = contractDao.showAllContract();
		assertNotNull(contract);
	}

	@Test
	void testSheduleContract() {
		boolean scheduleContract = contractDao.sheduleContract(contractBean.getContractNo(), 
									"20/03/2020", "approved");
		assertTrue(scheduleContract);
	}

}
