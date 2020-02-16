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

import com.capgemini.forestrymanagementspringboot.dto.Customer;
import com.capgemini.forestrymanagementspringboot.dto.CustomerResponse;
import com.capgemini.forestrymanagementspringboot.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/add-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse addCustomer(@RequestBody Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		if (customerService.addCustomer(customer)) {
			customerResponse.setStatusCode(201);
			customerResponse.setMessage("Success");
			customerResponse.setDescription("Customer Added Successfully");
		}
		return customerResponse;
	}

	@DeleteMapping(path = "/delete-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse deleteCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse customerResponse = new CustomerResponse();
		if (customerService.deleteCustomer(customerId)) {
			customerResponse.setStatusCode(201);
			customerResponse.setMessage("Success");
			customerResponse.setDescription("Customer Deleted Successfully");
		}
		return customerResponse;
	}

	@GetMapping(path = "/get-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse searchCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse customerResponse = new CustomerResponse();
		Customer customer = customerService.getCustomer(customerId);
		if (customer != null) {
			customerResponse.setStatusCode(201);
			customerResponse.setMessage("Success");
			customerResponse.setDescription("Customer Found Successfully");
			customerResponse.setCustomerResponse(Arrays.asList(customer));
		}
		return customerResponse;
	}
	
	@GetMapping(path = "/get-all-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse searchAllCustomer() {
		CustomerResponse customerResponse = new CustomerResponse();
		List<Customer> list = customerService.getAllCust();
		if (list.size()!=0) {
			customerResponse.setStatusCode(201);
			customerResponse.setMessage("Success");
			customerResponse.setDescription("Customer Found Successfully");
			customerResponse.setCustomerResponse(list);
			return customerResponse;
		}
		return customerResponse;
	}

	@PutMapping(path = "/modify-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse modifyCustomer(@RequestBody Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		if (customerService.modifyCustomer(customer)) {
			customerResponse.setStatusCode(201);
			customerResponse.setMessage("Success");
			customerResponse.setDescription("Customer Name Modified Successfully");
		}
		return customerResponse;
	}

	 
}
