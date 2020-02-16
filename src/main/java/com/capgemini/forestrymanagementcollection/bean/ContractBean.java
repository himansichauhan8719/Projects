package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContractBean implements Serializable {
	private int contractNo;
	private int customerId;
	private int productId;
	private String deliveryDate;
	private int quantity;
	private String status;

}
