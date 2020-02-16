package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.factory.Validation;

public class AdminLogged {
	static Scanner scanner = new Scanner(System.in);

	public static void adminLogged() {
		int adminSwitch = 0;
		while (true) {
			char adminChoiceLoop = 'y';
			while (adminChoiceLoop == 'y') {
				System.out.println(
						"Enter 1 : Contractor \nEnter 2 : Customer \nEnter 3 : Product\nEnter 4 : Client \nEnter 5 : Scheduler \nEnter 6 : Land \nEnter 7 : Logout");
				String isNumber = scanner.nextLine();

				if (Validation.isNumber1(isNumber)) {
					adminSwitch = Integer.parseInt(isNumber);
					adminChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (adminSwitch) {
			case 1:
				ContractMain.contractMain();
				break;
			case 2:
				CustomerMain.customerMain();
				break;

			case 3:
				ProductMain.productMain();
				break;

			case 4:
				ClientSection.clientSection();
				break;

			case 5:
				SchedulerMain.mainScheduler();
				break;

			case 6:
				LandMain.mainLand();
				break;

			case 7:
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(\n");
				break;
			}

		}
	}
}
