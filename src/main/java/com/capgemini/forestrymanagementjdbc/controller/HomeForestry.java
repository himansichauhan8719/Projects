package com.capgemini.forestrymanagementjdbc.controller;

import java.util.Scanner;

public class HomeForestry {
	private static Scanner scanner = new Scanner(System.in);
	public static void mainHomeForestry() {
		System.out.println("---------WelCome To Home Page------");
		int homeForestryChoice = 0;
		char homeForestryMainLoop = 'y';
		while (homeForestryMainLoop == 'y') {
			System.out.println("Enter 1 : Admin\nEnter 2 : Client\nEnter 3 : Schedular");
			String homeForestryChoiceValidation = scanner.nextLine();
			if (Validation.isNumber(homeForestryChoiceValidation)) {
				homeForestryChoice = Integer.parseInt(homeForestryChoiceValidation);
				homeForestryMainLoop = 'n';
			} else {
				System.err.println("Enter only integers:");
			}
		}

		switch (homeForestryChoice) {
		case 1:
			AdminController.adminController();
			break;
		case 2:
			ClientController.mainClientController();
			break;

		case 3:
			SchedulerController.loginScheduler();
			break;
		default:
			System.err.println("Invalid Choice:");
			break;
		}
		
	}

}
