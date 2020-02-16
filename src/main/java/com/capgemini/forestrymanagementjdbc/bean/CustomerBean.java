package com.capgemini.forestrymanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerBean implements Serializable {
	private int customerId;
	private String customerName;
	private String streetAdd1;
	private String streetAdd2;
	private String town;
	private int postalCode;
	private String email;
	private long telephone;

}
