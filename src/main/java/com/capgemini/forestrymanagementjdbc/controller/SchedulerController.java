package com.capgemini.forestrymanagementjdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.exception.SchedulerExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;
import com.capgemini.forestrymanagementjdbc.services.SchedulerServ;

public class SchedulerController {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void schedulerController() {
		SchedulerServ schedulerServices = Factory1.getScheduServ();
		SchedulerBean schedulerBean = Factory1.getSchedBean();

		int schedulerControllerChoice = 0;
		char schedulerLoop = 'a';
		while (schedulerLoop == 'a') {
			char schedulerLoopChoice = 'y';
			while (schedulerLoopChoice == 'y') {
				System.out.println(
						"Enter 1 : Create Scheduler\nEnter 2 : Delete Scheduler  \nEnter 3 : Get All Schedulers \nEnter 4 : Back\nEnter 5 : Home");
				String schedulerChoice = scanner.nextLine();
				if (Validation.isNumber1(schedulerChoice)) {
					schedulerControllerChoice = Integer.parseInt(schedulerChoice);
					schedulerLoopChoice = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (schedulerControllerChoice) {
			case 1:
				char schedulerIdLoopForAdd = 'y';
				int schedulerIdForadd = 0;
				while (schedulerIdLoopForAdd == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String schedulerId = scanner.nextLine();
					if (Validation.isNumber1(schedulerId)) {
						schedulerIdForadd = Integer.parseInt(schedulerId);
						schedulerIdLoopForAdd = 'n';
					} else if (schedulerId.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				schedulerBean.setScheId(schedulerIdForadd);

				char schedulerNameForAdd = 'y';
				while (schedulerNameForAdd == 'y') {
					System.out.println("Enter The Scheduler Name :");
					String schedulerNameValidation = scanner.nextLine();
					if (schedulerNameValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					}
					if (Validation.isStringOnlyAlphabet(schedulerNameValidation)) {
						schedulerNameForAdd = 'n';
						schedulerBean.setScheName(schedulerNameValidation);
					} else {
						System.err.println("Enter Only Charecters!!!!");
					}
				}

				char schedulerPasswordLoopForAdd = 'y';
				while (schedulerPasswordLoopForAdd == 'y') {
					System.out.println("Enter the Password:");
					String schedulerPasswordValidation = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(schedulerPasswordValidation);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						schedulerPasswordLoopForAdd = 'n';
						schedulerBean.setSchePassword(schedulerPasswordValidation);
					} else if (schedulerPasswordValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
										+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}
				String role = "scheduler";
				schedulerBean.setRole(role);

				try {
					if (schedulerServices.addScheduler(schedulerBean)) {
						System.out.println("Added Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				char scheulerIdForDeleteLoop = 'y';
				int schedulerIdForDelete = 0;
				while (scheulerIdForDeleteLoop == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String schedulerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(schedulerIdValidation)) {
						schedulerIdForDelete = Integer.parseInt(schedulerIdValidation);
						scheulerIdForDeleteLoop = 'n';
					} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				schedulerBean.setScheId(schedulerIdForDelete);

				System.out.println("Enter The Password :");
				schedulerBean.setSchePassword(scanner.nextLine());

				try {
					if (schedulerServices.deleteScheduler(schedulerBean.getScheId(), schedulerBean.getSchePassword())) {
						System.out.println("Deleted  Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				try {
					List<SchedulerBean> allSchedulerList = schedulerServices.getAllScheduler();
					for (SchedulerBean schedulerBean03 : allSchedulerList) {
						if (allSchedulerList != null) {
							System.out.println("Scheduler Id :" + schedulerBean03.getScheId());
							System.out.println("Schedular Name :" + schedulerBean03.getScheName());
							System.out.println("------------------------");
						}
					}
				} catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				return;
			case 5:
				HomeForestry.mainHomeForestry();
				break;

			default:
				System.err.println("Invalid Choice :");
				break;
			}
		}
	}

	public static void loginScheduler() {
		SchedulerServ schedulerService = Factory1.getScheduServ();
		SchedulerBean schedulerBean = Factory1.getSchedBean();

		while (true) {
			char schedulerLoginLoop = 'y';
			int schedulerLoginChoice = 0;
			while (schedulerLoginLoop == 'y') {
				System.out.println("----PLEASE LOGIN----");
				System.out.println("Enter The Scheduler Id :");
				String v1 = scanner.nextLine();
				if (Validation.isNumber1(v1)) {
					schedulerLoginChoice = Integer.parseInt(v1);
					schedulerLoginLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			schedulerBean.setScheId(schedulerLoginChoice);

			System.out.println("Enter The Password :");
			schedulerBean.setSchePassword(scanner.nextLine());
			if (schedulerBean.getSchePassword().equalsIgnoreCase("exit")) {
				SchedulerController.schedulerController();
			}

			try {
				if (schedulerService.loginScheduler(schedulerBean.getScheId(), schedulerBean.getSchePassword())) {
					System.out.println("Login  Successfully");
					Schedular.mainSchedular();
				}
			} catch (SchedulerExceptions e) {
				System.err.println(e.getMessage());
			}

		}
	}
}
