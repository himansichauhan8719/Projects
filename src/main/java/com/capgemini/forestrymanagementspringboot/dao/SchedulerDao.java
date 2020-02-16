package com.capgemini.forestrymanagementspringboot.dao;

import java.util.List;

import com.capgemini.forestrymanagementspringboot.dto.Scheduler;

public interface SchedulerDao {
	public boolean addScheduler(Scheduler scheduler);

	public boolean deleteScheduler(int schedulerId);

	public boolean loginScheduler(int schedulerId, String schedulerPassword);

	public List<Scheduler> getAllScheduler();

	public Scheduler searchScheduler(int schedulerId);

	public boolean modifyScheduler(int schedulerId, String schedulerName);

	public boolean modifySchedulerPass(int schedulerId, String SchedulerPassword);

}
