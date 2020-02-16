package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;

class SchedulerDaoTest {

	private static SchedulerDao schedulerDao = new SchedulerDaoImpl();
	private static SchedulerBean scheduler = new SchedulerBean();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setScheName("azad");
		scheduler.setScheId(786);
		scheduler.setSchePassword("asdf");
		scheduler.setRole("scheduler");
		schedulerDao.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerDao.deleteScheduler(scheduler.getScheId(), scheduler.getSchePassword());
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerDao.loginScheduler(scheduler.getScheId(), scheduler.getSchePassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerDao.getAllScheduler());
	}

	@Test
	void testAddScheduler() {
	}
	
	@Test
	void testDeleteScheduler() {
		
	}
	
}
