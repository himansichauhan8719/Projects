package com.capgemini.forestrymanagementspringboot.dto;

import java.util.List;

public class ProductResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Product> productResponse;

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

	public List<Product> getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(List<Product> productResponse) {
		this.productResponse = productResponse;
	}

}
