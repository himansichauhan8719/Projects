package com.capgemini.forestrymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.exception.ClientExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ClientServices;

public class ClientSection {
	public static Scanner scanner = new Scanner(System.in);
	public static ClientServices clientService = Factory.getClientService();
	
	public static void clientSection() {
		Client client = Factory.getClient();

		char clientSectionLoop = 'a';
		while (clientSectionLoop == 'a') {

			int clientSectionChoice = 0;
			char clientSectionLoopForChoice = 'y';
			while (clientSectionLoopForChoice == 'y') {
				System.out.println(
						"Enter 1 : Add Client \nEnter 2 : Delete Client \nEnter 3 : Search Client \nEnter 4 : Get All Client\n"
								+ "Enter 5 : Back");
				String v1 = scanner.nextLine();
				if (Validation.isNumber1(v1)) {
					clientSectionChoice = Integer.parseInt(v1);
					clientSectionLoopForChoice = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (clientSectionChoice) {
			case 1:
				int clientIdForAdd = 0;
				char clientIdLoopForAdd = 'y';
				while (clientIdLoopForAdd == 'y') {
					System.out.println("Enter The Client id");
					String clientIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(clientIdForValidation)) {
						clientIdForAdd = Integer.parseInt(clientIdForValidation);
						clientIdLoopForAdd = 'n';
					} else if (clientIdForValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				client.setClientId(clientIdForAdd);

				char clientNameForAdd = 'y';
				while (clientNameForAdd == 'y') {
					System.out.println("Enter The Client Name :");
					String clientNameForValidation = scanner.nextLine();
					if (clientNameForValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					}
					if (Validation.isStringOnlyAlphabet(clientNameForValidation)) {
						clientNameForAdd = 'n';
						client.setClientName(clientNameForValidation);
					}
					if (clientNameForValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char clientPasswordLoopForAdd = 'y';
				while (clientPasswordLoopForAdd == 'y') {
					System.out.println("Enter the Password:");
					String clientPasswordValidation = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(clientPasswordValidation);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						clientPasswordLoopForAdd = 'n';
						client.setClientPassword(clientPasswordValidation);
					} else if (clientPasswordValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 10 digits  "
										+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				String role = "client";
				client.setRole(role);

				try {
					if (clientService.addClient(client)) {
						System.out.println("Client Added Successfully");
					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				int clientIdForDelete = 0;
				char clientIdLoopForDelete = 'y';
				while (clientIdLoopForDelete == 'y') {
					System.out.println("Enter The Client Id :");
					String clientIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(clientIdForValidation)) {
						clientIdForDelete = Integer.parseInt(clientIdForValidation);
						clientIdLoopForDelete = 'n';
					} else if (clientIdForValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				client.setClientId(clientIdForDelete);

				System.out.println("Enter The Client Password  :");
				client.setClientPassword(scanner.nextLine());
				if (client.getClientPassword().equalsIgnoreCase("exit")) {
					ClientSection.clientSection();
				}

				try {
					if (clientService.deleteClient(client.getClientId())) {
						System.out.println("Deleted Successfully");

					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				int clientIdForSearch = 0;
				char clientIdLoopForSearch = 'y';
				while (clientIdLoopForSearch == 'y') {
					System.out.println("Enter The Client Id to Search");
					String clientIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(clientIdForValidation)) {
						clientIdForSearch = Integer.parseInt(clientIdForValidation);
						clientIdLoopForSearch = 'n';
					} else if (clientIdForValidation.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				client.setClientId(clientIdForSearch);

				try {
					List<Client> searchedClient = clientService.searchClient(client.getClientId());
					for (Client clientBean0 : searchedClient) {

						if (searchedClient != null) {
							System.out.println("Client Id :" + clientBean0.getClientId());
							System.out.println("CLient Name :" + clientBean0.getClientName());
							System.out.println("----------------------");

						} else {
							System.err.println("Client Not Found ");
						}
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:

				try {
					List<Client> getAllClient = clientService.getAllClient();
					for (Client clientBean1 : getAllClient) {
						if (getAllClient != null) {
							System.out.println("Client Id :" + clientBean1.getClientId());
							System.out.println("CLient Name :" + clientBean1.getClientName());
							System.out.println("----------------------");
						}
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				return;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}

	
}
