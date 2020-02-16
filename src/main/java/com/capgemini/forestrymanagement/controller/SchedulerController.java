package com.capgemini.forestrymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.exception.SchedulerExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.SchedulerServ;

public class SchedulerController {
	private static Scanner scanner = new Scanner(System.in);
	private static SchedulerServ schedulerService = Factory.getSchedulerService();
	private static Scheduler scheduler = Factory.getScheduler();

	public static void schedulerController() {

		int schedulerChoice = 0;
		char schedulerLoop = 'a';
		while (schedulerLoop == 'a') {
			char schedulerChoiceLoop = 'y';
			while (schedulerChoiceLoop == 'y') {
				System.out.println(
						"Enter 1 : Create Scheduler \nEnter 2 : Delete Scheduler  \nEnter 3 : Get All Schedulers \nEnter 4 : Back");
				String choiceValidation = scanner.nextLine();

				if (Validation.isNumber1(choiceValidation)) {
					schedulerChoice = Integer.parseInt(choiceValidation);
					schedulerChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (schedulerChoice) {
			case 1:
				char schedulerLoopForChoice = 'y';
				int schedulerIdForAdd = 0;
				while (schedulerLoopForChoice == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						schedulerIdForAdd = Integer.parseInt(v1);
						schedulerLoopForChoice = 'n';
					} else if (v1.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				scheduler.setSchedulerId(schedulerIdForAdd);

				char schedulerNameLoopForAdd = 'y';
				while (schedulerNameLoopForAdd == 'y') {
					System.out.println("Enter The Scheduler Name :");
					String nameValidation = scanner.nextLine();
					if (nameValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					}
					if (Validation.isStringOnlyAlphabet(nameValidation)) {
						schedulerNameLoopForAdd = 'n';
						scheduler.setSchedulerName(nameValidation);
					} else {
						System.err.println("Enter Only Charecters!!!!");
					}
				}

				char passwordForAddLoop = 'y';
				while (passwordForAddLoop == 'y') {
					System.out.println("Enter the Password:");
					String passwordValidation = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(passwordValidation);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						passwordForAddLoop = 'n';
						scheduler.setSchedulerPassword(passwordValidation);
					} else if (passwordValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
										+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				String role = "scheduler";
				scheduler.setRole(role);

				try {
					if (schedulerService.addScheduler(scheduler)) {
						System.out.println("Added Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				char schedulerIdForLoop = 'y';
				int schedulerIdForDelete = 0;
				while (schedulerIdForLoop == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String schedulerIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(schedulerIdForValidation)) {
						schedulerIdForDelete = Integer.parseInt(schedulerIdForValidation);
						schedulerIdForLoop = 'n';
					} else if (schedulerIdForValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				scheduler.setSchedulerId(schedulerIdForDelete);


				try {
					if (schedulerService.deleteScheduler(scheduler.getSchedulerId())) {
						System.out.println("Deleted  Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				try {
					List<Scheduler> allScheduler = schedulerService.getAllScheduler();
					for (Scheduler scheduler : allScheduler) {
						if (allScheduler != null) {
							System.out.println("Scheduler Id :" + scheduler.getSchedulerId());
							System.out.println("Schedular Name :" + scheduler.getSchedulerName());
							System.out.println("Role :" + scheduler.getRole());
							System.out.println("------------------------");
						}
					}
				} catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());

				}
				break;

			case 4:
				char schedulerModificationLoop = 'y';
				int schedulerUpdateChoice = 0;
				while (schedulerModificationLoop == 'y') {
					System.out.println("----MODIFICATION----");
					System.out.println("Enter 1 : Scheduler Name\nEnter 2 : Scheduler Password\n"
							+ "Enter 3 : Back\nEnter 4 : Home");
					String choicesValidation = scanner.nextLine();
					if (Validation.isNumber1(choicesValidation)) {
						schedulerUpdateChoice = Integer.parseInt(choicesValidation);
						schedulerModificationLoop = 'n';
					} else if (choicesValidation.equalsIgnoreCase("exit")) {
						SchedulerController.schedulerController();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				switch (schedulerUpdateChoice) {
				case 1:
					char schedulerIdForUpdateNameLoop = 'y';
					int schedulerIdForNameUpdate = 0;
					while (schedulerIdForUpdateNameLoop == 'y') {
						System.out.println("Enter The Scheduler Id :");
						String schedulerIdValidation = scanner.nextLine();
						if (Validation.isNumber1(schedulerIdValidation)) {
							schedulerIdForNameUpdate = Integer.parseInt(schedulerIdValidation);
							schedulerIdForUpdateNameLoop = 'n';
						} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
							SchedulerController.schedulerController();
						} else {
							System.err.println("Enter only integers:");
						}
					}
					scheduler.setSchedulerId(schedulerIdForNameUpdate);

					char schedulerNameLoopForUpdate = 'y';
					while (schedulerNameLoopForUpdate == 'y') {
						System.out.println("Enter The Scheduler Name :");
						String schedulerNameValidation = scanner.nextLine();
						if (schedulerNameValidation.equalsIgnoreCase("exit")) {
							SchedulerController.schedulerController();
						}
						if (Validation.isStringOnlyAlphabet(schedulerNameValidation)) {
							schedulerNameLoopForUpdate = 'n';
							scheduler.setSchedulerName(schedulerNameValidation);
						} else {
							System.err.println("Enter Only Charecters!!!!");
						}
					}
					try {
						if (schedulerService.modifyScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerName())) {
							System.out.println("Successfully updated");
						}
					} catch (SchedulerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;

				case 2:
					char schedulerIdLoopForPasswordUpdate = 'y';
					int schedulerIdForPassword = 0;
					while (schedulerIdLoopForPasswordUpdate == 'y') {
						System.out.println("Enter The Scheduler Id :");
						String schedulerIdValidation = scanner.nextLine();
						if (Validation.isNumber1(schedulerIdValidation)) {
							schedulerIdForPassword = Integer.parseInt(schedulerIdValidation);
							schedulerIdLoopForPasswordUpdate = 'n';
						} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
							SchedulerController.schedulerController();
						} else {
							System.err.println("Enter only integers:");
						}
					}
					scheduler.setSchedulerId(schedulerIdForPassword);

					char passwordUpdateloop = 'y';
					while (passwordUpdateloop == 'y') {
						System.out.println("Enter the Password:");
						String passwordValidation = scanner.nextLine();
						int strength = Validation.calculatePasswordStrength(passwordValidation);
						System.out.println("Your Password Strength is :" + strength);
						if (strength == 8) {
							passwordUpdateloop = 'n';
							scheduler.setSchedulerPassword(passwordValidation);
						} else if (passwordValidation.equalsIgnoreCase("exit")) {
							SchedulerController.schedulerController();
						} else {
							System.err.println(
									"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
											+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
						}
					}
					try {
						if (schedulerService.modifySchedulerPass(scheduler.getSchedulerId(),
								scheduler.getSchedulerPassword())) {
							System.out.println("Successfully updated");
						}
					} catch (SchedulerExceptions e) {
						System.err.println(e.getMessage());
					}

				}
				return;

			default:
				System.err.println("Invalid Choice :");
				break;

			}
		}
	}

	public static void loginScheduler() {

		while (true) {
			char loginSchedulerLoop = 'y';
			int schedulerId = 0;
			while (loginSchedulerLoop == 'y') {
				System.out.println("----PLEASE LOGIN----");
				System.out.println("Enter The Scheduler Id :");
				String schedulerIdValidation = scanner.nextLine();
				if (Validation.isNumber1(schedulerIdValidation)) {
					schedulerId = Integer.parseInt(schedulerIdValidation);
					loginSchedulerLoop = 'n';
				} else if (schedulerIdValidation.equalsIgnoreCase("exit")) {
					HomeForestry.mainHomeForestry();

				} else {
					System.err.println("Enter only integers:");
				}
			}
			scheduler.setSchedulerId(schedulerId);

			System.out.println("Enter The Password :");
			scheduler.setSchedulerPassword(scanner.nextLine());
			if (scheduler.getSchedulerPassword().equalsIgnoreCase("exit")) {
				HomeForestry.mainHomeForestry();
			}

			try {
				if (schedulerService.loginScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword())) {
					System.out.println("Login  Successfully");
					Schedular.mainSchedular();
				}
			} catch (SchedulerExceptions e) {
				System.err.println(e.getMessage());
			}

		}
	}
}
