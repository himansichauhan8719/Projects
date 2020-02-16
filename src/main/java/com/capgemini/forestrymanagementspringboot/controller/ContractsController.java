package com.capgemini.forestrymanagementspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementspringboot.dto.Contracts;
import com.capgemini.forestrymanagementspringboot.dto.ContractsResponse;
import com.capgemini.forestrymanagementspringboot.service.ContractServices;

@RestController
public class ContractsController {
	@Autowired
	private ContractServices contractServices ;
	
	
	@PostMapping(path = "/add-contracts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractsResponse addContracts(@RequestBody Contracts contracts) {
		ContractsResponse contractsResponse = new ContractsResponse();
		if (contractServices.addContract(contracts)) {
			contractsResponse.setStatusCode(201);
			contractsResponse.setMessage("Success");
			contractsResponse.setDescription("Contracts Added Successfully");
		}
		return contractsResponse;
	}
	
	@DeleteMapping(path = "/delete-contracts/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractsResponse deleteContracts(@PathVariable("contractNo") int contractNo) {
		ContractsResponse contractsResponse = new ContractsResponse();
		if (contractServices.deleteContract(contractNo)) {
			contractsResponse.setStatusCode(201);
			contractsResponse.setMessage("Success");
			contractsResponse.setDescription("Contract Deleted Successfully");
		}
		return contractsResponse;
	}
	
	@GetMapping(path = "/get-contracts/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractsResponse searchContracts(@PathVariable("contractNo") int contractNo) {
		ContractsResponse contractsResponse = new ContractsResponse();
		Contracts contracts = contractServices.getContract(contractNo);
		if (contracts != null) {
			contractsResponse.setStatusCode(201);
			contractsResponse.setMessage("Success");
			contractsResponse.setDescription("Contracts Found Successfully");
			contractsResponse.setContractsResponse(Arrays.asList(contracts));
		}
		return contractsResponse;
	}
	
	@GetMapping(path = "/get-all-contracts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractsResponse getAllContracts() {
		ContractsResponse contractsResponse = new ContractsResponse();
		List<Contracts> list = contractServices.getAllContract();
		if (list.size()!=0) {
			contractsResponse.setStatusCode(201);
			contractsResponse.setMessage("Success");
			contractsResponse.setDescription("All Contacts Details found ");
			contractsResponse.setContractsResponse(list);
		}
		return contractsResponse;
	}
	
	@PutMapping(path = "/modify-contracts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractsResponse modifyContracts(@RequestBody Contracts contract ) {
		ContractsResponse contractsResponse = new ContractsResponse();
		if (contractServices.scheduleContracts(contract)) {
			contractsResponse.setStatusCode(201);
			contractsResponse.setMessage("Success");
			contractsResponse.setDescription("Successfully scheduled  ");
		}
		return contractsResponse;
	}


}
