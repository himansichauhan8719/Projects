package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account_info")
public class Admin {

	@Id
	@Column(name = "id")
	private int adminId;

	@Column(name = "name")
	private String adminName;

	@Column(name = "password")
	private String adminPassword;

	@Column(name = "roles")
	private String role;
}
