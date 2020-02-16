package com.capgemini.forestrymanagementspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "contract_info")
@Data
public class Contracts {

	@Id
	@Column(name = "contractno")
	private int contractNo;

	@Column(name = "customerid")
	private int customerId;

	@Column(name = "prodid")
	private int prodId;

	@Column(name = "deliverydate")
	private String deliveryDate;

	@Column
	private String quantity;

	@Column
	private String status;

}
