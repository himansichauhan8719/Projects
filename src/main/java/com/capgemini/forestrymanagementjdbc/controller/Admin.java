package com.capgemini.forestrymanagementjdbc.controller;

import java.util.Scanner;

public class Admin {
	public static void mainAdmin() {

		Scanner scanner = new Scanner(System.in);
		while (true) {

			char adminMainLoop = 'a';
			while (adminMainLoop == 'a') {
				char adminMainChoiceLoop = 'y';
				int adminChoice = 0;
				while (adminMainChoiceLoop == 'y') {
					System.out.println("Welcome you Admin");
					System.out.println("Enter 1 : Contractor\nEnter 2 : Products\nEnter 3 : Customers\n"
							+ "Enter 4 : Client\nEnter 5 : Scheduler\nEnter 6 : Logouts");
					String choiceValidation = scanner.next();
					if (Validation.isNumber1(choiceValidation)) {
						adminChoice = Integer.parseInt(choiceValidation);
						adminMainChoiceLoop = 'n';
					} else {
						System.err.println("Enter only integers:");
					}
				}

				switch (adminChoice) {

				case 1:
					ContractorController.contractorContr();
					break;

				case 2:
					System.out.println("----PRODUCTS----");
					ProductController.productContr();
					break;

				case 3:
					System.out.println("----CUSTOMER----");
					CustomerController.custControl();
					break;

				case 4:
					ClientSection.clientSection();
					break;

				case 5:
					SchedulerController.schedulerController();
					break;

				case 6:
					HomeForestry.mainHomeForestry();
					break;

				default:
					System.err.println("Invalid  Choice :( ");
					break;
				}
			}
			scanner.close();
		}
	}
}
