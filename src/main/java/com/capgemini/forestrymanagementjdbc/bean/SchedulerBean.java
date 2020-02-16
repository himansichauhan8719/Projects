package com.capgemini.forestrymanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SchedulerBean implements Serializable {
	private int scheId;
	private String scheName;
	private String schePassword;
	private String role;
	

}
