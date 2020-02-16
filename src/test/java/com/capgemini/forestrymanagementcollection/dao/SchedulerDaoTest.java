package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;

class SchedulerDaoTest {
	private SchedulerDao schedulerDao = new SchedulerDaoImpl();
	SchedulerBean schedulerBean = new SchedulerBean();
	
	@BeforeEach
	public void addScheduler( ) {
		schedulerBean.setSchedulerId(10);
		schedulerBean.setSchedulerEmail("khan@gmail.com");
		schedulerBean.setSchedulerName("khan");
		schedulerBean.setSchedulerPassword("kingKhan");
		schedulerDao.addScheduler(schedulerBean);
	}
	
//	@Test
//	void testAddScheduler() {
//		
//		schedulerBean.setSchedulerId(15);
//		schedulerBean.setSchedulerEmail("azad@g.com");
//		schedulerBean.setSchedulerName("azad");
//		schedulerBean.setSchedulerPassword("suraj123");
//		boolean added = schedulerServices.addScheduler(schedulerBean);
//		assertTrue(added);
//		
//	}

	@Test
	void testDeleteScheduler() {
		boolean delete = schedulerDao.deleteScheduler(schedulerBean.getSchedulerId(), schedulerBean.getSchedulerPassword());
		assertTrue(delete);
	}

	@Test
	void testSearchScheduler() {
		List<SchedulerBean> search = schedulerDao.searchScheduler(schedulerBean.getSchedulerId());
		assertNotNull(search);
	}

	@Test
	void testLoginScheduler() {
		boolean login = schedulerDao.loginScheduler(schedulerBean.getSchedulerId(), schedulerBean.getSchedulerPassword());
		assertTrue(login);
	}

	@Test
	void testGetAllScheduler() {
		List<SchedulerBean> scheduler = schedulerDao.getAllScheduler();
		assertNotNull(scheduler);

	}

}
