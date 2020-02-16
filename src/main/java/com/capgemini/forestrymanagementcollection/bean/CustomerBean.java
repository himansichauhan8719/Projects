package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerBean implements Serializable {

	private String customerName;
	private int customerId;
	private String streetAdd1;
	private String streetAdd2;
	private String town;
	private int postalCode;
	private String email;
	private long telephone;

}
