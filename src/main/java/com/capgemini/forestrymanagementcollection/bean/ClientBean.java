package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClientBean implements Serializable {
	private int clientId;
	private String clientName;
	private String clientPassword;

}
