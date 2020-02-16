package com.capgemini.forestrymanagementspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementspringboot.dto.Client;
import com.capgemini.forestrymanagementspringboot.dto.ClientResponse;
import com.capgemini.forestrymanagementspringboot.service.ClientServices;

@RestController
public class ClientController {

	@Autowired
	private ClientServices clientServices;
	
	@PostMapping(path = "/add-client", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse addClient(@RequestBody Client client) {
		ClientResponse clientResponse = new ClientResponse();
		client.setRole("client");
		if (clientServices.addClient(client)) {
			clientResponse.setStatusCode(201);
			clientResponse.setMessage("Success");
			clientResponse.setDescription("Client Added Successfully");
		}
		return clientResponse;
	}
	
	@DeleteMapping(path = "/delete-client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse deleteClient(@RequestBody Client client) {
		ClientResponse clientResponse = new ClientResponse();
		if (clientServices.deleteClient(client.getClientId())) {
			clientResponse.setStatusCode(201);
			clientResponse.setMessage("Success");
			clientResponse.setDescription("Client Deleted Successfully");
		}
		return clientResponse;
	}
	
	@GetMapping(path = "/get-client/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse searchClientId(@PathVariable("clientId") int clientId) {
		ClientResponse clientResponse = new ClientResponse();
		List<Client> client = clientServices.searchClient(clientId);
		if (client != null) {
			clientResponse.setStatusCode(201);
			clientResponse.setMessage("Success");
			clientResponse.setDescription("Client Found Successfully");
			clientResponse.setClientResponse(client);
		}
		return clientResponse;
	}
	
	@GetMapping(path = "/get-all-client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse searchAllClient() {
		ClientResponse clientResponse = new ClientResponse();
		List<Client> list = clientServices.getAllClient();
		if (list.size()!=0) {
			clientResponse.setStatusCode(201);
			clientResponse.setMessage("Success");
			clientResponse.setDescription("Scheduler Details found Successfully");
			clientResponse.setClientResponse(list);
		}
		return clientResponse;
	}
	
	
}
