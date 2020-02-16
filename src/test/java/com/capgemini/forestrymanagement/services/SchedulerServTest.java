package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Scheduler;

class SchedulerServTest {

	private static SchedulerServ schedulerServices = new SchedulerServImpl();
	private static Scheduler scheduler = new Scheduler();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setSchedulerName("azad");
		scheduler.setSchedulerId(786);
		scheduler.setSchedulerPassword("asdf");
		scheduler.setRole("scheduler");
		schedulerServices.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerServices.deleteScheduler(scheduler.getSchedulerId());
	}
	
	
	@Test
	void testAddScheduler() {
		Scheduler scheduler1 = new Scheduler();
		scheduler1.setSchedulerName("azad");
		scheduler1.setSchedulerId(7860);
		scheduler1.setSchedulerPassword("asdf");
		scheduler1.setRole("scheduler");
		assertTrue(schedulerServices.addScheduler(scheduler1));
		schedulerServices.deleteScheduler(scheduler1.getSchedulerId());
	}

	@Test
	void testDeleteScheduler() {
		Scheduler scheduler1 = new Scheduler();
		scheduler1.setSchedulerName("azad");
		scheduler1.setSchedulerId(7860);
		scheduler1.setSchedulerPassword("asdf");
		scheduler1.setRole("scheduler");
		schedulerServices.addScheduler(scheduler1);
		assertTrue(schedulerServices.deleteScheduler(scheduler1.getSchedulerId()));
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerServices.loginScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerServices.getAllScheduler());
	}


	@Test
	void testModifyScheduler() {
		assertTrue(schedulerServices.modifyScheduler(scheduler.getSchedulerId(), "azzad"));
	}

	@Test
	void testModifySchedulerPass() {
		assertTrue(schedulerServices.modifySchedulerPass(scheduler.getSchedulerId(), "khan"));
	}

}
