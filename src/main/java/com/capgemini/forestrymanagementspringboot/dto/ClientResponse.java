package com.capgemini.forestrymanagementspringboot.dto;

import java.util.List;

public class ClientResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Client> clientResponse;

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

	public List<Client> getClientResponse() {
		return clientResponse;
	}

	public void setClientResponse(List<Client> clientResponse) {
		this.clientResponse = clientResponse;
	}

}
