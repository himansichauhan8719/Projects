package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.factory.Validation;

public class AdminMain {
	static Scanner scanner = new Scanner(System.in);
	public static void adminMain() {
		char adminMainLoop = 'a';
		while (adminMainLoop == 'a') {

			int adminSwitchChoice = 0;
			char adminChoiceLoop = 'y';
			while (adminChoiceLoop == 'y') {
				System.out.println("---------------------------");
				System.out.println("------- ADMIN PAGE --------");
				System.out.println("---------------------------");
				System.out.println("Enter 1 : Admin Login \nEnter 2 : Back ");
				String v1 = scanner.nextLine();
				if (Validation.isNumber1(v1)) {
					adminSwitchChoice = Integer.parseInt(v1);
					adminChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}

				switch (adminSwitchChoice) {
				case 1:

					String name = "root";
					String password = "root123";
					String adminName = null;
					char adminNameLoop = 'y';
					while (adminNameLoop == 'y') {
						System.out.println("Enter the Admin name");
						adminName = scanner.nextLine();
						if (adminName.equalsIgnoreCase("exit")) {
							return;
						}
						if (Validation.isStringOnlyAlphabet(adminName)) {
							adminNameLoop = 'n';
						} else {
							System.err.println("Enter only Alphabets!!!!");
						}
					}

					System.out.println("Enter Admin Password");
					String adminPassword = scanner.nextLine();
					if (adminPassword.equalsIgnoreCase("exit")) {
						return;
					}

					if (adminName.equals(name) && adminPassword.equals(password)) {
						System.out.println("login Successfully");
						AdminLogged.adminLogged();
					} else {
						System.err.println("Invalid Admin");
					}
					break;

				case 2:
					return;

				default:
					System.err.println("Invalid Choice ");
					break;

				}

			}

		}
	}
}