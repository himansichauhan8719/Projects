package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account_info")
public class Scheduler {
	@Id
	@Column(name = "id")
	private int schedulerId;

	@Column(name = "name")
	private String schedulerName;

	@Column(name = "password")
	private String schedulerPassword;

	@Column(name = "roles")
	private String role;

}
