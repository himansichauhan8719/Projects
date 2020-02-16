package com.capgemini.forestrymanagementjdbc.factory;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.dao.ClientDao;
import com.capgemini.forestrymanagementjdbc.dao.ClientDaoImpl;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDao;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDaoImpl;
import com.capgemini.forestrymanagementjdbc.services.ClientServicesImpl;
import com.capgemini.forestrymanagementjdbc.services.ClientSevices;
import com.capgemini.forestrymanagementjdbc.services.SchedulerServ;
import com.capgemini.forestrymanagementjdbc.services.SchedulerServImpl;

public class Factory1 {
	private Factory1() {

	}

	public static ClientBean getClBean() {
		ClientBean bean = new ClientBean();
		return bean;
	}

	public static ClientSevices getClServ() {
		ClientSevices serv = new ClientServicesImpl();
		return serv;

	}

	public static ClientDao getClDao() {
		ClientDao dao = new ClientDaoImpl();
		return dao;
	}

	public static SchedulerServ getScheduServ() {
		return (SchedulerServ) new SchedulerServImpl();
	}

	public static SchedulerDao getSchedDao() {
		return (SchedulerDao) new SchedulerDaoImpl();
	}

	public static SchedulerBean getSchedBean() {
		return new SchedulerBean();
	}

}
