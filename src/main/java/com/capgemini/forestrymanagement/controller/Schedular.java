package com.capgemini.forestrymanagement.controller;

import java.util.Scanner;

public class Schedular {

	private static Scanner scanner = new Scanner(System.in);

	public static void mainSchedular() {

		char schedulerLoop = 'y';
		while (schedulerLoop == 'y') {
			int schedulerChoice = 0;
			char schedulerChoiceLoop = 'y';
			while (schedulerChoiceLoop == 'y') {
				System.out.println("-------WELCOME SCHEDULER-------");
				System.out.println(
						"Enter 1 : Contracts\nEnter 2 : Products\nEnter 3 : Customers\nEnter 4 : Land\nEnter 5 : Back\nEnter 6 : Logout");
				String schudulerChoiceValidation = scanner.nextLine();
				if (Validation.isNumber1(schudulerChoiceValidation)) {
					schedulerChoice = Integer.parseInt(schudulerChoiceValidation);
					schedulerChoiceLoop = 'n';
				} else if (schudulerChoiceValidation.equalsIgnoreCase("exit")) {
					Schedular.mainSchedular();
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (schedulerChoice) {
			case 1:
				Scheduling.schedulingController();
				break;

			case 2:
				char productLoop = 'y';
				while (productLoop == 'y') {
					int productChoice = 0;
					char productChoiceLoop = 'y';
					while (productChoiceLoop == 'y') {
						System.out.println("------PRODUCTS------");
						System.out.println(
								"Enter 1 : Get All Products\nEnter 2 : Search Products\nEnter 3 : Back\nEnter 4 : Home");
						String choiceValidation = scanner.nextLine();
						if (Validation.isNumber1(choiceValidation)) {
							productChoice = Integer.parseInt(choiceValidation);
							productChoiceLoop = 'n';
						} else {
							System.err.println("Enter only integers:");
						}
					}
					switch (productChoice) {
					case 1:
						ProductController.getAllProduct();
						break;

					case 2:
						ProductController.searchProduct();
						break;

					case 3:
						productLoop = 'n';
						break;
					case 4:
						HomeForestry.mainHomeForestry();

					default:
						System.err.println("Invalid choice :");
						break;
					}
				}
				break;

			case 3:
				char customerLoop = 's';
				while (customerLoop == 's') {
					int customerChoices = 0;
					char customerChoicesLoop = 'y';
					while (customerChoicesLoop == 'y') {
						System.out.println("------CUSTOMERS-----");
						System.out.println(
								"Enter 1 : Get All Customers\nEnter 2 : Search Customers\nEnter 3 : Back\nEnter 4 : Home");
						String choiceValidation = scanner.nextLine();
						if (Validation.isNumber(choiceValidation)) {
							customerChoices = Integer.parseInt(choiceValidation);
							customerChoicesLoop = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (customerChoices) {
					case 1:
						CustomerController.getAllCustomer();
						break;

					case 2:
						CustomerController.searchCustomer();
						break;

					case 3:
						customerLoop = 'k';
						break;

					case 4:
						HomeForestry.mainHomeForestry();
					default:

						System.err.println("Invalid Choice :(");
						break;
					}
				}
				break;

			case 4:
				char landLoop = 's';
				while (landLoop == 's') {

					int landChoice = 0;
					char landLoopChoice = 'y';
					while (landLoopChoice == 'y') {
						System.out.println("------LAND-----");
						System.out.println(
								"Enter 1 : Get All Land Details\nEnter 2 : Search Land Details\nEnter 3 : Back\nEnter 4 : Home");
						String landChoiceValidation = scanner.nextLine();
						if (Validation.isNumber(landChoiceValidation)) {
							landChoice = Integer.parseInt(landChoiceValidation);
							landLoopChoice = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}
					switch (landChoice) {
					case 1:
						LandController.getAllLands();
						break;

					case 2:
						LandController.searchLand();
						break;

					case 3:
						landLoop = 'a';
						break;

					case 4:
						HomeForestry.mainHomeForestry();
						break;

					default:
						System.err.println("Invalid Choice :(");
						break;
					}
				}
				break;

			case 5:
				schedulerLoop = 'n';
				break;

			case 6:
				HomeForestry.mainHomeForestry();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}
}
