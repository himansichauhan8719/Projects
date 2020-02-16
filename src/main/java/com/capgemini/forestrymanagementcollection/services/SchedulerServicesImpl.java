package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;
import com.capgemini.forestrymanagementcollection.dao.SchedulerDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class SchedulerServicesImpl implements SchedulerServices {
	private SchedulerDao schedulerDao = Factory.getSchedulerDaoImpl();

	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		return schedulerDao.addScheduler(sbean);
	}

	@Override
	public boolean deleteScheduler(int schedulerId, String schedulerPassword) {
		return schedulerDao.deleteScheduler(schedulerId, schedulerPassword);
	}

	@Override
	public boolean updateScheduler(int schedulerId, String schedulerPassword) {
		return schedulerDao.updateScheduler(schedulerId, schedulerPassword);
	}

	@Override
	public List<SchedulerBean> searchScheduler(int schedulerId) {
		return schedulerDao.searchScheduler(schedulerId);
	}

	@Override
	public boolean loginScheduler(Object schedulerId, String schedulerPassword) {
		return schedulerDao.loginScheduler(schedulerId, schedulerPassword);
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		return schedulerDao.getAllScheduler();
	}

}
