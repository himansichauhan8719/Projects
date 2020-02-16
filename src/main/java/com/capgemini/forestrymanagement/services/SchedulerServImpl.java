package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.SchedulerDao;
import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.factory.Factory;

public class SchedulerServImpl implements SchedulerServ {
	SchedulerDao schedulerDao = Factory.getSchedulerDao();

	@Override
	public boolean addScheduler(Scheduler scheduler) {
		return schedulerDao.addScheduler(scheduler);
	}

	@Override
	public boolean deleteScheduler(int schedulerId) {
		return schedulerDao.deleteScheduler(schedulerId);
	}

	@Override
	public boolean loginScheduler(int schedulerId, String schedulerPassword) {
		return schedulerDao.loginScheduler(schedulerId, schedulerPassword);
	}

	@Override
	public List<Scheduler> getAllScheduler() {
		return schedulerDao.getAllScheduler();
	}

	@Override
	public Scheduler searchScheduler(int schedulerId) {
		return schedulerDao.searchScheduler(schedulerId);
	}

	@Override
	public boolean modifyScheduler(int schedulerId, String schedulerName) {
		return schedulerDao.modifyScheduler(schedulerId, schedulerName);
	}

	@Override
	public boolean modifySchedulerPass(int schedulerId, String SchedulerPassword) {
		// TODO Auto-generated method stub
		return schedulerDao.modifySchedulerPass(schedulerId, SchedulerPassword);
	}

}
