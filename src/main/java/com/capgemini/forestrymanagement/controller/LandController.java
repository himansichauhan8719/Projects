package com.capgemini.forestrymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.exception.LandExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.LandServices;

public class LandController {

	private static Land land = Factory.getLand();
	private static Scanner scanner = new Scanner(System.in);
	private static LandServices landServices = Factory.getLandService();

	public static void landController() {
		int landChoice = 0;
		while (true) {
			char landChoiceLoop = 'y';
			while (landChoiceLoop == 'y') {
				System.out.println("----LAND PAGE----");
				System.out.println(
						"Enter 1 : Add Land Details \nEnter 2 : Delete Land details\nEnter 3 : Modify Land Details\n"
								+ "Enter 4 : Search Land Details\nEnter 5 : All Land Details\nEnter 6 : Back");
				String landChoiceValidation = scanner.nextLine();

				if (Validation.isNumber1(landChoiceValidation)) {
					landChoice = Integer.parseInt(landChoiceValidation);
					landChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (landChoice) {
			case 1:
				char landIdForAddLoop = 'y';
				int landIdForAdd = 0;
				while (landIdForAddLoop == 'y') {
					System.out.println("Enter The Land Id :");
					String landIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(landIdForValidation)) {
						landIdForAdd = Integer.parseInt(landIdForValidation);
						landIdForAddLoop = 'n';
					} else if (landIdForValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				land.setLandId(landIdForAdd);

				char landLocationForAdd = 'y';
				while (landLocationForAdd == 'y') {
					System.out.println("Enter the Land Location :");
					String landLocationValidation = scanner.nextLine();
					if (landLocationValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					}
					if (Validation.isStringOnlyAlphabet(landLocationValidation)) {
						landLocationForAdd = 'n';
						land.setLocation(landLocationValidation);
					} else {
						System.out.println("Enter Only Alphabates !!!!");
					}
				}

				char landValueForLoop = 'y';
				int landValueForAdd = 0;
				while (landValueForLoop == 'y') {
					System.out.println("Enter the Land Value In Rs/- :");
					String landValueLoop = scanner.nextLine();
					if (Validation.isNumber1(landValueLoop)) {
						landValueForAdd = Integer.parseInt(landValueLoop);
						landValueForLoop = 'n';
					} else if (landValueLoop.equalsIgnoreCase("exit")) {
						LandController.landController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				land.setValue(landValueForAdd);

				char landOwnerNameLoop = 'y';
				while (landOwnerNameLoop == 'y') {
					System.out.println("Enter The Land Owner Name :");
					String landOwnerNameValidation = scanner.nextLine();
					if (landOwnerNameValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					}
					if (Validation.isStringOnlyAlphabet(landOwnerNameValidation)) {
						landOwnerNameLoop = 'n';
						land.setOwnerName(landOwnerNameValidation);
					} else {
						System.out.println("Enter only Alphabates!!!!");
					}
				}

				char acquireDateLoopForAdd = 'y';
				while (acquireDateLoopForAdd == 'y') {
					System.out.println("Enter The Acquired  Date (DD/MM/YYYY) : ");
					String dateValidation = scanner.nextLine();
					if (Validation.isValidDate(dateValidation)) {
						acquireDateLoopForAdd = 'n';
						land.setDate(dateValidation);
					} else if (dateValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					} else {
						System.err.println("Enter Date Format  it should be in DD/MM/YYYY!!!!");
					}
				}

				try {
					if (landServices.addLand(land)) {
						System.out.println("Added Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				char landIdLoopForDelete = 'y';
				int landIdForDelete = 0;
				while (landIdLoopForDelete == 'y') {
					System.out.println("Enter The Land Id :");
					String landIdValidation = scanner.nextLine();
					if (Validation.isNumber1(landIdValidation)) {
						landIdForDelete = Integer.parseInt(landIdValidation);
						landIdLoopForDelete = 'n';
					} else if (landIdValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				land.setLandId(landIdForDelete);

				try {
					if (landServices.deleteLand(land.getLandId())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				char landIdForSearchLoop = 'y';
				int landIdForSearch = 0;
				while (landIdForSearchLoop == 'y') {
					System.out.println("Enter The Land Id :");
					String landIdValidation = scanner.nextLine();
					if (Validation.isNumber1(landIdValidation)) {
						landIdForSearch = Integer.parseInt(landIdValidation);
						landIdForSearchLoop = 'n';
					} else if (landIdValidation.equalsIgnoreCase("exit")) {
						LandController.landController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				land.setLandId(landIdForSearch);

				try {
					if (landServices.modifyLand(land.getLandId())) {
						System.out.println("Successfully Modified");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 4:
				LandController.searchLand();
				break;

			case 5:
				LandController.getAllLands();
				break;

			case 6:
				return;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}

	public static void searchLand() {
		char landIdForSearchLoop = 'y';
		int landIdForSearch = 0;
		while (landIdForSearchLoop == 'y') {
			System.out.println("Enter The Land Id :");
			String landIdForValidation = scanner.nextLine();
			if (Validation.isNumber1(landIdForValidation)) {
				landIdForSearch = Integer.parseInt(landIdForValidation);
				landIdForSearchLoop = 'n';
			} else if (landIdForValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		land.setLandId(landIdForSearch);

		try {
			LandServices landServices = Factory.getLandService();
			Land landList = landServices.searchLand(land.getLandId());
			if (landList != null) {
				System.out.println("Land Id :" + landList.getLandId());
				System.out.println("Land Location :" + landList.getLocation());
				System.out.println("Land Owner :" + landList.getOwnerName());
				System.out.println("Land Acquired Date :" + landList.getDate());
				System.out.println("Land Value : " + landList.getValue());
				System.out.println("-------------------");
			}
		} catch (LandExceptions e) {
			System.err.println(e.getMessage());
		}

	}

	public static void getAllLands() {
		try {
			LandServices landServices = Factory.getLandService();
			List<Land> allLand = landServices.getAllLand();
			for (Land land : allLand) {
				if (allLand != null) {
					System.out.println("Land Id :" + land.getLandId());
					System.out.println("Land Location :" + land.getLocation());
					System.out.println("Land Owner :" + land.getOwnerName());
					System.out.println("Land Acquired Date :" + land.getDate());
					System.out.println("Land Value : " + land.getValue());
					System.out.println("-------------------");
				}
			}
		} catch (LandExceptions e) {
			System.err.println(e.getMessage());
		}
	}

}
