package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "productid")
	private int productId;
	@Column(name = "productname")
	private String productName;
	@Column
	private String quantity;
}
