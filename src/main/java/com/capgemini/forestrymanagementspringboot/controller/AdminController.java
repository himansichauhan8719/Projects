package com.capgemini.forestrymanagementspringboot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementspringboot.dto.Admin;
import com.capgemini.forestrymanagementspringboot.dto.AdminResponse;
import com.capgemini.forestrymanagementspringboot.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminServices;

	@PostMapping(path = "/login-admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse login(@RequestBody Admin admin) {
		AdminResponse adminResponse = new AdminResponse();
		Admin adminAccount = adminServices.login(admin);
		if (adminAccount != null) {
			adminResponse.setStatusCode(201);
			adminResponse.setDescription("Success");
			adminResponse.setMessage("Logged in");
			adminResponse.setAdminResponse(Arrays.asList(adminAccount));
		} 
		return adminResponse;
	}
	
	@PostMapping(path = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse addAdmin(@RequestBody Admin admin) {
		AdminResponse adminResponse = new AdminResponse();
		if (adminServices.addAdmin(admin)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("Success");
			adminResponse.setDescription("Admin Sign Up Successfully");
		} 
		return adminResponse;
	}

}
