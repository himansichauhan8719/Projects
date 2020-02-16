package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDao;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDaoImpl;

class SchedulerServTest {

	private static SchedulerServ schedulerServices = new SchedulerServImpl();
	private static SchedulerBean scheduler = new SchedulerBean();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setScheName("azad");
		scheduler.setScheId(786);
		scheduler.setSchePassword("asdf");
		scheduler.setRole("scheduler");
		schedulerServices.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerServices.deleteScheduler(scheduler.getScheId(), scheduler.getSchePassword());
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerServices.loginScheduler(scheduler.getScheId(), scheduler.getSchePassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerServices.getAllScheduler());
	}

	@Test
	void testAddScheduler() {
	}
	
	@Test
	void testDeleteScheduler() {
		
	}

}
