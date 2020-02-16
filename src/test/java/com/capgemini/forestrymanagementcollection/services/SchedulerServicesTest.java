package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;

class SchedulerServicesTest {

	private SchedulerServices schedulerServices = new SchedulerServicesImpl();
	SchedulerBean schedulerBean = new SchedulerBean();
	
	@BeforeEach
	public void addScheduler( ) {
		schedulerBean.setSchedulerId(10);
		schedulerBean.setSchedulerEmail("khan@gmail.com");
		schedulerBean.setSchedulerName("khan");
		schedulerBean.setSchedulerPassword("kingKhan");
		schedulerServices.addScheduler(schedulerBean);
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
		boolean delete = schedulerServices.deleteScheduler(schedulerBean.getSchedulerId(), schedulerBean.getSchedulerPassword());
		assertTrue(delete);
	}

	@Test
	void testSearchScheduler() {
		List<SchedulerBean> search = schedulerServices.searchScheduler(schedulerBean.getSchedulerId());
		assertNotNull(search);
	}

	@Test
	void testLoginScheduler() {
		boolean login = schedulerServices.loginScheduler(schedulerBean.getSchedulerId(), schedulerBean.getSchedulerPassword());
		assertTrue(login);
	}

	@Test
	void testGetAllScheduler() {
		List<SchedulerBean> scheduler = schedulerServices.getAllScheduler();
		assertNotNull(scheduler);

	}

}
