package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.factory.Validation;

public class SchedulerSection {
	static Scanner scanner = new Scanner(System.in);

	public static void schedulerSection() {
		char scheulerSectionLoop = 'a';
		while (scheulerSectionLoop == 'a') {

			int schedulerChoice = 0;
			char schedulerChoiceLoop = 'y';
			while (schedulerChoiceLoop == 'y') {
				System.out.println("Enter 1 : Login Scheduler \nEnter 2 : Back \nEnter 3 : Home \n");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					schedulerChoice = Integer.parseInt(choiceValidation);
					schedulerChoiceLoop = 'n';
				} else {
					System.out.println("Enter only integers:");
				}
			}

			switch (schedulerChoice) {
			case 1:
				SchedulerMain.loginScheduler();
				break;

			case 2:
				scheulerSectionLoop = 'b';
				return;

			case 3:
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}

}
