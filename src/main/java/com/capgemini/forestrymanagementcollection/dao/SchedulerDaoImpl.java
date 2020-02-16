package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;
import com.capgemini.forestrymanagementcollection.exception.SchedulerExceptions;

public class SchedulerDaoImpl implements SchedulerDao {

	private List<SchedulerBean> list = new ArrayList<SchedulerBean>();
	SchedulerBean schedulerBean = new SchedulerBean();

	@Override
	public boolean addScheduler(SchedulerBean schedulerBean) {
		for (SchedulerBean schedulerBean01 : list) {
			if (schedulerBean01.getSchedulerId() == schedulerBean01.getSchedulerId()) {
				throw new SchedulerExceptions("Scheduler Id Already Existed");
			}
		}
		list.add(schedulerBean);
		return true;
	}

	@Override
	public boolean deleteScheduler(int schedid, String schedpassword) {
		for (SchedulerBean schedulerBean : list) {
			if ((schedulerBean.getSchedulerId()) == schedid || schedpassword == schedulerBean.getSchedulerPassword()) {
				list.remove(schedulerBean);
				return true;
			}
		}
		throw new SchedulerExceptions("Scheduler Cannot be Added");
	}

	@Override
	public boolean updateScheduler(int schedid, String schedpassword) {
		return false;
	}

	@Override
	public List<SchedulerBean> searchScheduler(int Schedid) {
		for (SchedulerBean schedulerBean : list) {
			if (schedulerBean.getSchedulerId() == Schedid) {
				return list;
			}
		}
		throw new SchedulerExceptions("Scheduler Cannot be Found");
	}

	@Override
	public boolean loginScheduler(Object schedid, String schedpassword) {
		for (SchedulerBean schedulerBean : list) {
			System.out.println(schedulerBean.getSchedulerId());
			if (schedid.equals(schedulerBean.getSchedulerId()) && schedpassword.equals(schedulerBean.getSchedulerPassword())) {
				return true;
			}
		}
		throw new SchedulerExceptions("Login Failed");
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		if (list != null) {
			return list;
		}
		throw new SchedulerExceptions("No Scheduler Present");
	}

}
