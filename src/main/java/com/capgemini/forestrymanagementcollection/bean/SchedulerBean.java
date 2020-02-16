package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SchedulerBean implements Serializable {
	private int schedulerId;
	private String schedulerName;
	private String schedulerEmail;
	private String schedulerPassword;

}
