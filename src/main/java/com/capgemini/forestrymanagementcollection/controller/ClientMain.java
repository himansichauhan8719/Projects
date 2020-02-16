package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.ClientServices;

public class ClientMain {

	public static ClientServices clientService = Factory.getClientServices();
	static Scanner scanner = new Scanner(System.in);

	public static void clientMain() {

		char clientMainLoop = 'a';
		while (clientMainLoop == 'a') {

			int clientSwitchChoice = 0;
			char clientChoiceLoop = 'y';
			while (clientChoiceLoop == 'y') {
				System.out.println("Enter 1 : Login \nEnter 2 : Back \nEnter 3 : Home \n");
				String caseChoice = scanner.nextLine();
				if (Validation.isNumber1(caseChoice)) {
					clientSwitchChoice = Integer.parseInt(caseChoice);
					clientChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (clientSwitchChoice) {
			case 1:
				ClientSection.loginClient();
				break;
			case 2:
				clientMainLoop = 'b';
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
