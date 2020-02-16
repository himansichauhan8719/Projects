package com.capgemini.forestrymanagementspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementspringboot.dto.Scheduler;
import com.capgemini.forestrymanagementspringboot.dto.SchedulerResponse;
import com.capgemini.forestrymanagementspringboot.service.SchedulerServ;

@RestController
public class SchedulerController {

	@Autowired
	private SchedulerServ schedulerService ;
	
	@PostMapping(path = "/add-scheduler", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse addScheduler(@RequestBody Scheduler scheduler) {
		SchedulerResponse schedulerResponse = new SchedulerResponse();
		scheduler.setRole("scheduler");
		if (schedulerService.addScheduler(scheduler)) {
			schedulerResponse.setStatusCode(201);
			schedulerResponse.setMessage("Success");
			schedulerResponse.setDescription("Scheduler Added Successfully");
		}
		return schedulerResponse;
	}
	
	@DeleteMapping(path = "/delete-scheduler", produces = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse deleteScheduler(@RequestBody Scheduler scheduler) {
		SchedulerResponse schedulerResponse = new SchedulerResponse();
		if (schedulerService.deleteScheduler(scheduler.getSchedulerId())) {
			schedulerResponse.setStatusCode(201);
			schedulerResponse.setMessage("Success");
			schedulerResponse.setDescription("Scheduler Deleted Successfully");
		}
		return schedulerResponse;
	}
	
	@GetMapping(path = "/get-scheduler/{schedulerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse searchScheduler(@PathVariable("schedulerId") int schedulerId) {
		SchedulerResponse schedulerResponse = new SchedulerResponse();
		Scheduler scheduler = schedulerService.searchScheduler(schedulerId);
		if (scheduler != null) {
			schedulerResponse.setStatusCode(201);
			schedulerResponse.setMessage("Success");
			schedulerResponse.setDescription("Scheduler Found Successfully");
			schedulerResponse.setSchedulerResponse(Arrays.asList(scheduler));
		}
		return schedulerResponse;
	}
	
	@GetMapping(path = "/get-all-scheduler", produces = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse searchAllScheduler() {
		SchedulerResponse schedulerResponse = new SchedulerResponse();
		List<Scheduler> list = schedulerService.getAllScheduler();
		if (list.size()!=0) {
			schedulerResponse.setStatusCode(201);
			schedulerResponse.setMessage("Success");
			schedulerResponse.setDescription("Scheduler Details found Successfully");
			schedulerResponse.setSchedulerResponse(list);
			return schedulerResponse;
		}
		return schedulerResponse;
	}
	
}
