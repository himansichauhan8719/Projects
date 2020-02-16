package com.capgemini.forestrymanagementjdbc.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;
import com.capgemini.forestrymanagementjdbc.exception.AdminExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;
import com.capgemini.forestrymanagementjdbc.services.AdminService;

public class AdminController {

	private static Scanner scanner = new Scanner(System.in);
	public static void adminController() {

		AdminService adminServices = Factory.getAdminServ();
		AdminBean adminBean = Factory.getAdminBean();

		char adminControllerLoop = 'y';
		while (adminControllerLoop == 'y') {
			int adminControllerChoice = 0;
			char adminControllerChoiceLoop = 'y';
			while (adminControllerChoiceLoop == 'y') {
				System.out.println("Enter 1 : Sign Up Admin\nEnter 2 : Login Admin\nEnter 3 : Home");
				String choiceValidation = scanner.nextLine();

				if (Validation.isNumber1(choiceValidation)) {
					adminControllerChoice = Integer.parseInt(choiceValidation);
					adminControllerChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (adminControllerChoice) {
			case 1:
				char adminIdForSignUpLoop = 'y';
				while (adminIdForSignUpLoop == 'y') {
					System.out.println("Enter the Admin id: ");
					String adminIdForValidation = scanner.nextLine();
					if (Validation.isNumber(adminIdForValidation)) {
						int adminId = Integer.parseInt(adminIdForValidation);
						adminBean.setAdminId(adminId);
						adminIdForSignUpLoop = 'n';
					} else if (adminIdForValidation.equalsIgnoreCase("exit")) {
						AdminController.adminController();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				char adminNameForSignUpLoop = 'y';
				while (adminNameForSignUpLoop == 'y') {
					System.out.println("Enter the Admin name");
					String adminNameValidation = scanner.nextLine();
					if (adminNameValidation.equalsIgnoreCase("exit")) {
						AdminController.adminController();
					}
					if (Validation.isStringOnlyAlphabet(adminNameValidation)) {
						adminNameForSignUpLoop = 'n';
						adminBean.setAdminName(adminNameValidation);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char adminPasswordForSignUpLoop = 'y';
				while (adminPasswordForSignUpLoop == 'y') {
					System.out.println("Enter the Password:");
					String adminPasswordValidation = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(adminPasswordValidation);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						adminPasswordForSignUpLoop = 'n';
						adminBean.setPassword(adminPasswordValidation);
					} else if (adminPasswordValidation.equalsIgnoreCase("exit")) {
						AdminController.adminController();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 10 digits  "
										+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				String role = "admin";
				adminBean.setRole(role);

				try {
					if (adminServices.addAdmin(adminBean)) {
						System.out.println("Admin Added Successfully...");
					}
				} catch (AdminExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				char adminIdForLoginLoop = 'y';
				while (adminIdForLoginLoop == 'y') {
					System.out.println("Enter the Admin id: ");
					String adminIdValidation = scanner.nextLine();
					if (Validation.isNumber(adminIdValidation)) {
						int adminId = Integer.parseInt(adminIdValidation);
						adminBean.setAdminId(adminId);
						adminIdForLoginLoop = 'n';
					} else if (adminIdValidation.equalsIgnoreCase("exit")) {
						AdminController.adminController();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				System.out.println("Enter The Password");
				adminBean.setPassword(scanner.nextLine());
				if (adminBean.getPassword().equalsIgnoreCase("exit")) {
					AdminController.adminController();
				}
				try {
					if (adminServices.loginAdmin(adminBean.getAdminId(), adminBean.getPassword())) {
						System.out.println("Successfully Logged in ");
						Admin.mainAdmin();
					}
				} catch (AdminExceptions e) {
					System.err.println(e.getMessage());
				}

			case 3:
				adminControllerLoop = 'n';
				HomeForestry.mainHomeForestry();
				break;
			default:
				System.err.println("Invalic Choice :( ");
				break;
			}

		}
	}

}
