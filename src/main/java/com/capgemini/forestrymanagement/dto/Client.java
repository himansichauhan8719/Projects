package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account_info")
public class Client {

	@Id
	@Column(name = "id")
	private int clientId;

	@Column(name = "name")
	private String clientName;

	@Column(name = "password")
	private String clientPassword;

	@Column(name = "roles")
	private String role;

}
