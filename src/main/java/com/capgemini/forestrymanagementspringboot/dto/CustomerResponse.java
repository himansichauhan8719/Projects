package com.capgemini.forestrymanagementspringboot.dto;

import java.util.List;

public class CustomerResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Customer> customerResponse;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Customer> getCustomerResponse() {
		return customerResponse;
	}

	public void setCustomerResponse(List<Customer> customerResponse) {
		this.customerResponse = customerResponse;
	}

}
