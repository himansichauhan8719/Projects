package com.capgemini.forestrymanagementspringboot.exception;

public class CustomerExceptions extends RuntimeException {
	String msg;

	public CustomerExceptions(String msg) {
		this.msg = msg;

	}

	@Override
	public String getMessage() {
		return msg;
	}

}
