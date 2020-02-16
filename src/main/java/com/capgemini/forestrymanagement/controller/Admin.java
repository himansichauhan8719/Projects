package com.capgemini.forestrymanagement.controller;

import java.util.Scanner;

public class Admin {
	private static Scanner scanner = new Scanner(System.in);

	public static void mainAdmin() {

		while (true) {

			char adminMainLoop = 'a';
			while (adminMainLoop == 'a') {
				char adminMainChoiceLoop = 'y';
				int adminChoice = 0;
				while (adminMainChoiceLoop == 'y') {
					System.out.println("Welcome you Admin");
					System.out.println("Enter 1 : Contractor\nEnter 2 : Products\nEnter 3 : Customers\n"
							+ "Enter 4 : Client\nEnter 5 : Scheduler\nEnter 6 : Land \nEnter 7: Logouts");
					String choiceValidation = scanner.nextLine();
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
					ProductController.productController();
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
					LandController.landController();
					break;
					
				case 7:
					HomeForestry.mainHomeForestry();
					break;

				default:
					System.err.println("Invalid  Choice :( ");
					break;
				}
			}
		}
	}
}
