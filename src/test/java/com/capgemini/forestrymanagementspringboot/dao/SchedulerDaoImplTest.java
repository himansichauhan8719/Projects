package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Scheduler;
import com.capgemini.forestrymanagementspringboot.exception.SchedulerExceptions;

@SpringBootTest
class SchedulerDaoImplTest {

		@Autowired
		private SchedulerDao schedao;
		private Scheduler bean = null; 
		 
		@Test
		void testAddScheduler() {
			bean = new Scheduler();
			bean.setSchedulerId(14);
			bean.setSchedulerName("akku");
			bean.setSchedulerPassword("root123");
			bean.setRole("scheduler");
		
			boolean flag = schedao.addScheduler(bean);
			try {
				assertEquals(flag,true);
				
			}catch(Exception e) {
				assertThrows(SchedulerExceptions.class, ()->{
					schedao.addScheduler(bean);
				});
			}
		}
		
		@Test
		void testAllScheduler() {
			try {
			List<Scheduler> bean = schedao.getAllScheduler();
			assertNotNull(bean);
			
		}catch(Exception e) {
			assertThrows(SchedulerExceptions.class, ()->{
				schedao.getAllScheduler();
			});
		}

	}
		
		@Test
		void testGetScheduler() {
			int schedulerId = 46;
			try {
				Scheduler cust = schedao.searchScheduler(schedulerId);
				assertNotNull(cust);
			}catch(Exception e) {
				assertThrows(SchedulerExceptions.class, ()->{
					schedao.searchScheduler(schedulerId);
					});
			}
		}
		
		@Test
		void testDeleteScheduler() {
			int schedulerId = 72;
			try {
				boolean check = schedao.deleteScheduler(schedulerId);
				assertEquals(check ,true);
			}catch(Exception e) {
				assertThrows(SchedulerExceptions.class, ()->{
					schedao.deleteScheduler(schedulerId);
					});
			}
		}

	}


