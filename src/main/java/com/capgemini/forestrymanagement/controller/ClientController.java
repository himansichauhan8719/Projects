package com.capgemini.forestrymanagement.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.exception.ClientExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ClientServices;

public class ClientController {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void mainClientController() {

		Client client = Factory.getClient();
		ClientServices serv = Factory.getClientService();

		System.out.println("-----Login client -----");
		char clientIdLoopForLogin = 'y';
		while (clientIdLoopForLogin == 'y') {
			System.out.println("Enter the Client id: ");
			String clientIdValidation = scanner.nextLine();
			if (Validation.isNumber(clientIdValidation)) {
				int clientId = Integer.parseInt(clientIdValidation);
				client.setClientId(clientId);
				clientIdLoopForLogin = 'n';

			} else if (clientIdValidation.equalsIgnoreCase("exit")) {
				HomeForestry.mainHomeForestry();

			} else {
				System.err.println("Enter only integers:");
			}
		}

		System.out.println("Enter The Password");
		client.setClientPassword(scanner.nextLine());
		if (client.getClientPassword().equalsIgnoreCase("exit")) {
			HomeForestry.mainHomeForestry();
		}

		try {

			if (serv.loginClient(client.getClientId(), client.getClientPassword())) {
				System.out.println("Login Successfully\n");

				int clientChoice = 0;
				char clinetLoggedInLoop = 'y';
				while (clinetLoggedInLoop == 'y') {
					System.out.println("----Welcome you Client----");
					System.out.println("Enter 1 : Contracts\nEnter 2 : Products\nEnter 3 : Customer\nEnter 4 : Logout");
					String choiceValidation = scanner.nextLine();
					if (Validation.isNumber(choiceValidation)) {
						clientChoice = Integer.parseInt(choiceValidation);
						clientIdLoopForLogin = 'n';
					} else {
						System.out.println("Enter only integers:");
					}

					switch (clientChoice) {

					case 1:
						ContractorController.contractorContr();
						break;

					case 2:
						ProductController.productController();
						break;

					case 3:
						CustomerController.custControl();
						break;

					case 4:
						HomeForestry.mainHomeForestry();

					default:
						System.err.println("Invalid choice :");
						break;
					}

				}
			}
		} catch (ClientExceptions e) {
			System.err.println(e.getMessage());
		}

	}

}
