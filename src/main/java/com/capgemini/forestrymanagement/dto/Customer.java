package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_info")
public class Customer {

	@Id
	@Column(name = "customerid")
	private int customerId;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "streetadd1")
	private String streetAdd1;

	@Column(name = "streetadd2")
	private String streetAdd2;

	@Column
	private String town;

	@Column(name = "postalcode")
	private int postalCode;

	@Column
	private long telephone;

	@Column
	private String email;

	// @OneToMany

}
