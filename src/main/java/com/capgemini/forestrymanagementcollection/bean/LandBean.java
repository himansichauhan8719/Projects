package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class LandBean implements Serializable {
	private int landId;
	private String location;
	private int value;
	private String ownerName;
}
