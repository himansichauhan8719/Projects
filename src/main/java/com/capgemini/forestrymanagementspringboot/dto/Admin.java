package com.capgemini.forestrymanagementspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
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
