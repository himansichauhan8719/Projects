package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "land_info")
public class Land {
	@Id
	@Column(name = "lid")
	private int landId;

	@Column
	private String location;

	@Column(name = "lvalue")
	private int value;

	@Column(name = "owner")
	private String ownerName;

	@Column
	private String date;

}
