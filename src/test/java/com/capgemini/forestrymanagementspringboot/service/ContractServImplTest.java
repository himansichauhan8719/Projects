package com.capgemini.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Contracts;
import com.capgemini.forestrymanagementspringboot.exception.ContractsExceptions;
@SpringBootTest
class ContractServImplTest {

	@Autowired
	private ContractServices contracts;
	private Contracts bean = null; 
	 
	@Test
	void testAddContract() {
		bean = new Contracts();
		bean.setContractNo(98);
		bean.setCustomerId(43);
		bean.setProdId(76);
		bean.setDeliveryDate("12/02/2020");
		bean.setQuantity("100");
		bean.setStatus("transpot");
		boolean flag = contracts.addContract(bean);
		try {
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contracts.addContract(bean);
			});
		}
	}
	
	@Test
	void testAllContract() {
		try {
		List<Contracts> bean = contracts.getAllContract();
		assertNotNull(bean);
		
	}catch(Exception e) {
		assertThrows(ContractsExceptions.class, ()->{
			contracts.getAllContract();
		});
	}

}
	@Test
	void testGetContract() {
		int contractNo = 43;
		try {
			Contracts contract = contracts.getContract(contractNo);
			assertNotNull(contract);
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contracts.getContract(3);
				});
		}
	}
	
	@Test
	void testDeleteContract() {
		int contractNo = 92;
		try {
			boolean check = contracts.deleteContract(contractNo);
			assertEquals(check ,true);
		}catch(Exception e) {
			assertThrows(ContractsExceptions.class, ()->{
				contracts.deleteContract(contractNo);
				});
		}
	}
}