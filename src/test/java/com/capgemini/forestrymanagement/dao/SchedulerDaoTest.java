package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Scheduler;

class SchedulerDaoTest {

	private static SchedulerDao schedulerDao = new SchedulerDaoImpl();
	private static Scheduler scheduler = new Scheduler();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setSchedulerName("azad");
		scheduler.setSchedulerId(786);
		scheduler.setSchedulerPassword("asdf");
		scheduler.setRole("scheduler");
		schedulerDao.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerDao.deleteScheduler(scheduler.getSchedulerId());
	}
	
	
	@Test
	void testAddScheduler() {
		Scheduler scheduler1 = new Scheduler();
		scheduler1.setSchedulerName("azad");
		scheduler1.setSchedulerId(7860);
		scheduler1.setSchedulerPassword("asdf");
		scheduler1.setRole("scheduler");
		assertTrue(schedulerDao.addScheduler(scheduler1));
		schedulerDao.deleteScheduler(scheduler1.getSchedulerId());
	}

	@Test
	void testDeleteScheduler() {
		Scheduler scheduler1 = new Scheduler();
		scheduler1.setSchedulerName("azad");
		scheduler1.setSchedulerId(7860);
		scheduler1.setSchedulerPassword("asdf");
		scheduler1.setRole("scheduler");
		schedulerDao.addScheduler(scheduler1);
		assertTrue(schedulerDao.deleteScheduler(scheduler1.getSchedulerId()));
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerDao.loginScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerDao.getAllScheduler());
	}


	@Test
	void testModifyScheduler() {
		assertTrue(schedulerDao.modifyScheduler(scheduler.getSchedulerId(), "azzad"));
	}

	@Test
	void testModifySchedulerPass() {
		assertTrue(schedulerDao.modifySchedulerPass(scheduler.getSchedulerId(), "khan"));
	}

}
