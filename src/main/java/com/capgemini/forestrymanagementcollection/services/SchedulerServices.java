package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;

public interface SchedulerServices {
	public boolean addScheduler(SchedulerBean sbean);

	public boolean deleteScheduler(int schedulerId, String schedulerPassword);

	public boolean updateScheduler(int schedulerId, String schedulerPassword);

	public List<SchedulerBean> searchScheduler(int schedulerId);

	public boolean loginScheduler(Object schedulerId, String schedulerPassword);

	public List<SchedulerBean> getAllScheduler();

}
