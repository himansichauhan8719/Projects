package com.capgemini.forestrymanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContractorBean implements Serializable {
	
	private int contractNo;
	private int customerId;
	private int productId;
	private String deliDate;
	private int quantity;
	private String status;

}
