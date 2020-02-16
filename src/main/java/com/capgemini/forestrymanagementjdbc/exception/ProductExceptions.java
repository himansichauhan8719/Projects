package com.capgemini.forestrymanagementjdbc.exception;

public class ProductExceptions extends RuntimeException {
	String msg;

	public ProductExceptions(String msg) {
		this.msg = msg;

	}

	@Override
	public String getMessage() {
		return msg;
	}

}
