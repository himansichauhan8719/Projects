package com.capgemini.forestrymanagement.controller;

import java.util.Scanner;

public class HomeForestry {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void mainHomeForestry() {
		System.out.println("---------WelCome To Home Page------");
		int HomeForestryChoice = 0;
		char forestryLoop = 'y';
		while( forestryLoop == 'y') {
		System.out.println("Enter 1 : Admin\nEnter 2 : Client\nEnter 3 : Schedular");
		String choiceValidation = scanner.nextLine();
		if (Validation.isNumber(choiceValidation)) {
			 HomeForestryChoice = Integer.parseInt(choiceValidation);
			forestryLoop ='n';
		}else {
			System.err.println("Enter only integers:");
		}
		}
		
		
		switch (HomeForestryChoice) {
		case 1:
			AdminController.adminController();		
			break;
		case 2:
			ClientController.mainClientController();
			break;
		
		case 3 :
			SchedulerController.loginScheduler();
			break;
		default:
			System.err.println("Invalid Choice:");
			break;
		}
	}

}
