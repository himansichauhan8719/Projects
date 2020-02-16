package com.capgemini.forestrymanagementspringboot.dto;

import java.util.List;

public class ContractsResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Contracts> contractsResponse;

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

	public List<Contracts> getContractsResponse() {
		return contractsResponse;
	}

	public void setContractsResponse(List<Contracts> contractsResponse) {
		this.contractsResponse = contractsResponse;
	}

}
