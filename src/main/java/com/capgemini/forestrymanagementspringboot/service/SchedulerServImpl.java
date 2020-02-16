package com.capgemini.forestrymanagementspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringboot.dao.SchedulerDao;
import com.capgemini.forestrymanagementspringboot.dto.Scheduler;

@Service
public class SchedulerServImpl implements SchedulerServ {
	@Autowired
	SchedulerDao schedulerDao;

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
