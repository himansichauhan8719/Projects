package com.capgemini.forestrymanagementjdbc.services;

import java.util.List;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDao;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;

public class SchedulerServImpl implements SchedulerServ {
	SchedulerDao schedulerDao = Factory1.getSchedDao();

	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		return schedulerDao.addScheduler(sbean);
	}

	@Override
	public boolean deleteScheduler(int schedulerId, String password) {
		return schedulerDao.deleteScheduler(schedulerId, password);
	}

	@Override
	public boolean loginScheduler(int schedulerId, String password) {
		return schedulerDao.loginScheduler(schedulerId, password);
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		return schedulerDao.getAllScheduler();
	}

}
