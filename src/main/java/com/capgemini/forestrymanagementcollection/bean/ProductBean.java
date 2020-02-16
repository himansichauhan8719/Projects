package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductBean implements Serializable {
	private int productId;
	private String productName;

}
