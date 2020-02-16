package com.capgemini.forestrymanagementjdbc.dao;

import java.util.List;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;

public interface SchedulerDao {
	public boolean addScheduler(SchedulerBean sbean);

	public boolean deleteScheduler(int schedulerId, String password);

	public boolean loginScheduler(int schedulerId, String password);

	public List<SchedulerBean> getAllScheduler();

}
