package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Contracts;
import com.capgemini.forestrymanagementspringboot.exception.ContractsExceptions;
@SpringBootTest
class ContractDaoImplTest {

	@Autowired
	private ContractDao contractdao;
	private Contracts bean = null; 
	 
	@Test
	void testAddContract() {
		bean = new Contracts();
		bean.setContractNo(75);
		bean.setCustomerId(899);
		bean.setDeliveryDate("12/02/2020");
		bean.setQuantity("100");
		bean.setStatus("transpot");
		boolean flag = contractdao.addContract(bean);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contractdao.addContract(bean);
			});
		}
	}
	
	@Test
	void testAllContract() {
		try {
		List<Contracts> bean = contractdao.getAllContract();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ContractsExceptions.class, ()->{
			contractdao.getAllContract();
		});
	}

}
	@Test
	void testGetContract() {
		int contractNo = 43;
		try {
			Contracts contract = contractdao.getContract(contractNo);
			assertNotNull(contract);
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contractdao.getContract(3);
				});
		}
	}
	
	@Test
	void testDeleteContract() {
		int contractNo = 92;
		try {
			boolean check = contractdao.deleteContract(contractNo);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contractdao.deleteContract(contractNo);
				});
		}
	}
}