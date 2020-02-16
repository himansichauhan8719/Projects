package com.capgemini.forestrymanagementcollection.exception;

public class LandExceptions extends RuntimeException {
	String msg;

	public LandExceptions(String msg) {
		super();
		this.msg = msg;
	}

}
