package com.capgemini.forestrymanagementcollection.dao;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;

public interface SchedulerDao {
	public boolean addScheduler(SchedulerBean sbean);

	public boolean deleteScheduler(int schedid, String schedpassword);

	public boolean updateScheduler(int schedid, String schedpassword);

	public List<SchedulerBean> searchScheduler(int Schedid);

	public boolean loginScheduler(Object schedid, String schedpassword);

	public List<SchedulerBean> getAllScheduler();

}
