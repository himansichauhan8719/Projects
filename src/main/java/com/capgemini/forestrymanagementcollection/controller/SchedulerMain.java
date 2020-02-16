package com.capgemini.forestrymanagementcollection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.SchedulerBean;
import com.capgemini.forestrymanagementcollection.exception.SchedulerExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.SchedulerServices;

public class SchedulerMain {
	public static SchedulerServices schedulerServices = Factory.getSchedulerServices();
	static Scanner scanner = new Scanner(System.in);

	public static void mainScheduler() {

		while (true) {
			int schedulerChoice = 0;
			char schedulerChoiceLoop = 'y';
			while (schedulerChoiceLoop == 'y') {
				System.out.println("-----------------------------");
				System.out.println("---------- SCHEDULER --------");
				System.out.println("-----------------------------");
				System.out.println("Enter 1 : Create Scheduler \nEnter 2 : Delete Scheduler \n"
						+ "Enter 3 : Show All Scheduler \nEnter 4 : Search Scheduler \nEnter 5 : Update Scheduler \nEnter 6 : Back ");
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
				SchedulerBean schedulerBean = new SchedulerBean();

				char schedulerIdLoop = 'y';
				int scheulerIdForAdd = 0;
				while (schedulerIdLoop == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String schedulerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(schedulerIdValidation)) {
						scheulerIdForAdd = Integer.parseInt(schedulerIdValidation);
						schedulerIdLoop = 'n';
					} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				schedulerBean.setSchedulerId(scheulerIdForAdd);

				char schedulerNameForAddLoop = 'y';
				while (schedulerNameForAddLoop == 'y') {
					System.out.println("Enter The Scheduler Name :");
					String schedulerNameValidation = scanner.nextLine();
					if (schedulerNameValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					}
					if (Validation.isStringOnlyAlphabet(schedulerNameValidation)) {
						schedulerNameForAddLoop = 'n';
						schedulerBean.setSchedulerName(schedulerNameValidation);
					} else {
						System.err.println("Enter Only Charecters!!!!");
					}
				}

				char schedulerEmailLoop = 'y';
				while (schedulerEmailLoop == 'y') {
					System.out.println("enter the Email: ");
					String schedulerEmailValidation = scanner.nextLine();
					if (Validation.isValid(schedulerEmailValidation)) {
						schedulerEmailLoop = 'n';
						schedulerBean.setSchedulerEmail(schedulerEmailValidation);
					} else if (schedulerEmailValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					} else {
						System.err.println("Enter valid Email Format!!!!");
					}
				}

				char schedulerPasswordAddLoop = 'y';
				while (schedulerPasswordAddLoop == 'y') {
					System.out.println("Enter the Password:");
					String passwordForValidation = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(passwordForValidation);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						schedulerPasswordAddLoop = 'n';
						schedulerBean.setSchedulerPassword(passwordForValidation);
					} else if (passwordForValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
										+ "1Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				try {
					if (schedulerServices.addScheduler(schedulerBean)) {
						System.out.println("Added Successfully :)");

					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				SchedulerBean schedulerBean02 = new SchedulerBean();

				char schedulerIdForLoopDelete = 'y';
				int schedulerIdForDelete = 0;
				while (schedulerIdForLoopDelete == 'y') {
					System.out.println("Enter The Scheduler Id :");
					System.out.println("===========================");
					String schedulerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(schedulerIdValidation)) {
						schedulerIdForDelete = Integer.parseInt(schedulerIdValidation);
						schedulerIdForLoopDelete = 'n';
					} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				schedulerBean02.setSchedulerId(schedulerIdForDelete);

				System.out.println("Enter The Scheduler Password :");
				schedulerBean02.setSchedulerPassword(scanner.nextLine());
				try {
					if (schedulerServices.deleteScheduler(schedulerBean02.getSchedulerId(),
							schedulerBean02.getSchedulerPassword())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				List<SchedulerBean> schedulerList = new ArrayList<SchedulerBean>();
				try {
					schedulerList = schedulerServices.getAllScheduler();
					for (SchedulerBean schedulerBean1 : schedulerList) {

						if (schedulerList != null) {
							System.out.println("Scheduler Id 		:" + schedulerBean1.getSchedulerId());
							System.out.println("Scheduler Name		:" + schedulerBean1.getSchedulerName());
							System.out.println("Scheduler Email Id	:" + schedulerBean1.getSchedulerEmail());
							System.out.println("------------------------------------");
						}
					}
				} catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				SchedulerBean schedulerBean03 = new SchedulerBean();
				char schedulerIdForSearchLoop = 'y';
				int schedulerIdForSearch = 0;
				while (schedulerIdForSearchLoop == 'y') {
					System.out.println("Enter The Scheduler Id :");
					System.out.println("============================");
					String schedulerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(schedulerIdValidation)) {
						schedulerIdForSearch = Integer.parseInt(schedulerIdValidation);
						schedulerIdForSearchLoop = 'n';
					} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
						SchedulerMain.mainScheduler();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				schedulerBean03.setSchedulerId(schedulerIdForSearch);

				List<SchedulerBean> schedulerAllList = new ArrayList<SchedulerBean>();
				try {
					schedulerAllList = schedulerServices.searchScheduler(schedulerBean03.getSchedulerId());
					for (SchedulerBean schedulerBean2 : schedulerAllList) {

						if (schedulerAllList != null) {
							System.out.println("Scheduler Id 		:" + schedulerBean2.getSchedulerId());
							System.out.println("Scheduler Name		:" + schedulerBean2.getSchedulerName());
							System.out.println("Scheduler Email Id	:" + schedulerBean2.getSchedulerEmail());
							System.out.println("------------------------------------");
						}
					}
				} catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());
				}

				break;
			case 5:
				break;

			case 6:
				return;
			case 7:
				MainHome.mainHome();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}

	public static void loginScheduler() {
		SchedulerBean schedulerBean = new SchedulerBean();
		System.out.println("----LOGIN PAGE----");

		char schedulerIdForLoginLoop = 'y';
		int schedulerIdforLogin = 0;
		while (schedulerIdForLoginLoop == 'y') {
			System.out.println("Enter The Scheduler Id :");
			String schedulerIdValidation = scanner.nextLine();
			if (Validation.isNumber1(schedulerIdValidation)) {
				schedulerIdforLogin = Integer.parseInt(schedulerIdValidation);
				schedulerIdForLoginLoop = 'n';
			} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}

		System.out.println("Enter The Password :");
		schedulerBean.setSchedulerPassword(scanner.nextLine());
		try {
			if (schedulerServices.loginScheduler(schedulerIdforLogin, schedulerBean.getSchedulerPassword())) {
				System.out.println(" Successfully logged in");

				char schedulerLoginLoop = 'a';
				while (schedulerLoginLoop == 'a') {

					int schedulerLoggedChoices = 0;
					char schedulerLoggedChoicesLoop = 'y';

					while (schedulerLoggedChoicesLoop == 'y') {
						System.out.println(
								"Enter 1 : Contracts \nEnter 2 : Customer \nEnter 3 : Products \nEnter 4 : Land  \nEnter 5 : Back ");
						String loginChoicesValidation = scanner.nextLine();
						if (Validation.isNumber1(loginChoicesValidation)) {
							schedulerLoggedChoices = Integer.parseInt(loginChoicesValidation);
							schedulerLoggedChoicesLoop = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (schedulerLoggedChoices) {
					case 1:
						Scheduling.schedulingMain();
						break;

					case 2:
						char customerSearchLoop = 'a';
						while (customerSearchLoop == 'a') {

							int customerChoices = 0;
							char customerChoicesLoop = 'y';
							while (customerChoicesLoop == 'y') {
								System.out.println(
										"Enter 1 : Search Customer \nEnter 2 : Get All Customers \nEnter 3 : Back ");
								String choiceValidation = scanner.nextLine();
								if (Validation.isNumber1(choiceValidation)) {
									customerChoices = Integer.parseInt(choiceValidation);
									customerChoicesLoop = 'n';
								} else {
									System.out.println("Enter only integers:");
								}
							}
							switch (customerChoices) {
							case 1:
								CustomerMain.searchCustomer();
								break;

							case 2:
								CustomerMain.showAllCustomer();
								break;

							case 3:
								return;

							default:
								System.out.println("Invalid Choice :(");
								break;
							}
						}
						break;

					case 3:
						System.out.println("----PRODUCT DETAILS---");
						ProductMain.getProducts();
						break;

					case 4:
						char landChoicesLoop = 'a';
						while (landChoicesLoop == 'a') {

							int landChoices = 0;
							char landSearchLoop = 'y';
							while (landSearchLoop == 'y') {
								System.out.println("----LAND PAGE----");
								System.out.println(
										"Enter 1 : Search Land \nEnter 2 : Get All Land Details\nEnter 3 : Back ");
								String landChoiceLoop = scanner.nextLine();
								if (Validation.isNumber1(landChoiceLoop)) {
									landChoices = Integer.parseInt(landChoiceLoop);
									landSearchLoop = 'n';
								} else {
									System.out.println("Enter only integers:");
								}
							}
							switch (landChoices) {
							case 1:
								LandMain.searchLand();
								break;

							case 2:
								LandMain.getAllLand();
								break;

							case 3:
								return;
							case 4:
								MainHome.mainHome();
								break;

							default:
								System.err.println("Invalid Choice :(");
								break;
							}
						}
						return;

					case 5:
						schedulerLoginLoop = 'b';
						break;

					default:
						System.err.println("Invalid Choice :(");
						break;
					}
				}
			}

		} catch (SchedulerExceptions e) {
			System.err.println(e.getMessage());
		}
	}
}
