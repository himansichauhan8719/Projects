package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.factory.Validation;

public class MainHome {
	static Scanner scanner = new Scanner(System.in);
	public static void mainHome() {
		System.out.println("-----WELCOME------");

		while(true) {

			int choices=0;
			char mainHomeChoicesLoop = 'y';
			while( mainHomeChoicesLoop == 'y') {
				System.out.println("Enter 1 : Admin \nEnter 2 : Client \nEnter 3 : Scheduler \n");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					choices = Integer.parseInt(choiceValidation);
					mainHomeChoicesLoop ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			switch(choices) {
			case 1:
				AdminMain.adminMain();
				break;

			case 2:
				ClientMain.clientMain();
				break;
			case 3:
				SchedulerSection.schedulerSection();
				break;
			case 4:
				MainHome.mainHome();
				break;

			default:
				System.err.println("Invalid Choice :(\n");
				break;
			}
		}
	}

}
