package com.capgemini.forestrymanagementcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.LandBean;
import com.capgemini.forestrymanagementcollection.exception.LandExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.LandServices;

public class LandMain {
	public static LandServices landServices = Factory.getLandServices();
    static Scanner scanner = new Scanner(System.in);

	public static void mainLand() {
		int choice = 0;

		while (true) {
			char landChoiceLoop = 'y';
			while (landChoiceLoop == 'y') {
				System.out.println("----------------------");
				System.out.println("-------- LAND --------");
				System.out.println("----------------------");
				System.out.println(
						"Enter 1 : Add Land Details \nEnter 2 : Delete Land details \nEnter 3 : Modify Land Details \nEnter 4 : 								Search Land Details \nEnter 5 : Get All Land Details \nEnter 6 : Back \nEnter 7 : Home ");
				String validationForIntValue = scanner.nextLine();
				if (Validation.isNumber1(validationForIntValue)) {
					choice = Integer.parseInt(validationForIntValue);
					landChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (choice) {
			case 1:
				LandBean landBean = new LandBean();

				char landIdValidaionLoopForAdding = 'y';
				int landIdForAdd = 0;
				while (landIdValidaionLoopForAdding == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						landIdForAdd = Integer.parseInt(v1);
						landIdValidaionLoopForAdding = 'n';
					} else {
						System.err.println("Enter only integers:");
					}
				}
				landBean.setLandId(landIdForAdd);

				char landLocationLoopForAdding = 'y';
				while (landLocationLoopForAdding == 'y') {
					System.out.println("Enter the Land Location :");
					String cadd3 = scanner.nextLine();
					if (cadd3.equalsIgnoreCase("exit")) {
						LandMain.mainLand();
					}
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						landLocationLoopForAdding = 'n';
						landBean.setLocation(cadd3);
					} else {
						System.err.println("Enter Only Alphabates !!!!");
					}
				}

				char landValueValidationLoop = 'y';
				int landValue = 0;
				while (landValueValidationLoop == 'y') {
					System.out.println("Enter the Land Value In Rs/- :");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						landValue = Integer.parseInt(v1);
						landValueValidationLoop = 'n';
					} else if (v1.equalsIgnoreCase("exit")) {
						LandMain.mainLand();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				landBean.setValue(landValue);

				char landOwnerNameLValidationLoop = 'y';
				while (landOwnerNameLValidationLoop == 'y') {
					System.out.println("Enter The Land Owner Name :");
					String landOwnerName = scanner.nextLine();
					if (landOwnerName.equalsIgnoreCase("exit")) {
						LandMain.mainLand();
					}
					if (Validation.isStringOnlyAlphabet(landOwnerName)) {
						landOwnerNameLValidationLoop = 'n';
						landBean.setOwnerName(landOwnerName);
					} else {
						System.err.println("Enter only Alphabates!!!!");
					}
				}

				try {
					if (landServices.addLand(landBean)) {
						System.out.println("Added Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				LandBean landOwnerName01 = new LandBean();

				char landIdValidationLoopForDelete = 'y';
				int landIdForDelete = 0;
				while (landIdValidationLoopForDelete == 'y') {
					System.out.println("Enter The Land Id :");
					System.out.println("=======================");
					String landIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(landIdForValidation)) {
						landIdForDelete = Integer.parseInt(landIdForValidation);
						landIdValidationLoopForDelete = 'n';
					} else if (landIdForValidation.equalsIgnoreCase("exit")) {
						LandMain.mainLand();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				landOwnerName01.setLandId(landIdForDelete);

				try {
					if (landServices.deleteLand(landOwnerName01.getLandId())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:

				System.out.println("Enter The Choices for Modification:");
				System.out.println("====================================");
				int choicesForModificationLoop = 1;
				while (choicesForModificationLoop == 1) {
					int choiceForLandModification = 0;
					char landModificationChoicesLoop = 'y';
					while (landModificationChoicesLoop == 'y') {
						System.out.println(
								"Enter 1 : Land Location\nEnter 2 : Land Value\nEnter 3 : Owner Name\nEnter 4 : Back");
						String landId = scanner.nextLine();
						if (Validation.isNumber1(landId)) {
							choiceForLandModification = Integer.parseInt(landId);
							landModificationChoicesLoop = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (choiceForLandModification) {
					case 1:
						LandBean lbean2 = new LandBean();
						char landIdLoopForLandLocation = 'y';
						int landIdForLocationModification = 0;
						while (landIdLoopForLandLocation == 'y') {
							System.out.println("Enter The Land Id :");
						
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								landIdForLocationModification = Integer.parseInt(v1);
								landIdLoopForLandLocation = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						lbean2.setLandId(landIdForLocationModification);

						char landLocationLoop = 'y';
						while (landLocationLoop == 'y') {
							System.out.println("Enter the Land Location :");
							
							String landLocationName = scanner.nextLine();
							if (landLocationName.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							}
							if (Validation.isStringOnlyAlphabet(landLocationName)) {
								landLocationLoop = 'n';
								lbean2.setLocation(landLocationName);
							} else {
								System.err.println("Enter Only Alphabates !!!!");
							}
						}

						try {
							if (landServices.modifyLandLoc(lbean2.getLandId(), lbean2.getLocation())) {
								System.out.println("Update Successfully");

							}
						} catch (LandExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2:
						LandBean landBean03 = new LandBean();
						int landIdForOwnerName = 0;
						char landIdValidationLoopForModification = 'y';
						while (landIdValidationLoopForModification == 'y') {
							System.out.println("Enter The Land Id :");
							System.out.println("======================");
							String landIdValidation = scanner.nextLine();
							if (Validation.isNumber1(landIdValidation)) {
								landIdForOwnerName = Integer.parseInt(landIdValidation);
								landIdValidationLoopForModification = 'n';
							} else if (landIdValidation.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						landBean03.setLandId(landIdForOwnerName);

						char landOwnerNameLoop = 'y';
						while (landOwnerNameLoop == 'y') {
							System.out.println("Enter the Owner Name :");
							String landOwnerName = scanner.nextLine();
							if (landOwnerName.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							}
							if (Validation.isStringOnlyAlphabet(landOwnerName)) {
								landOwnerNameLoop = 'n';
								landBean03.setOwnerName(landOwnerName);
							} else {
								System.err.println("Enter Only Alphabates !!!!");
							}
						}
						try {
							if (landServices.modifyLandOwner(landBean03.getLandId(), landBean03.getLocation())) {
								System.out.println("Update Successfully");
							}
						} catch (LandExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 3:
						LandBean landBean04 = new LandBean();
						int landIdForOwnerNameModification = 0;
						char landOwnerNameModificationLoop = 'y';
						while (landOwnerNameModificationLoop == 'y') {
							System.out.println("Enter The Land Id :");
							System.out.println("=====================");
							String landIdValidation = scanner.nextLine();
							if (Validation.isNumber1(landIdValidation)) {
								landIdForOwnerNameModification = Integer.parseInt(landIdValidation);
								landOwnerNameModificationLoop = 'n';
							} else if (landIdValidation.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						landBean04.setLandId(landIdForOwnerNameModification);

						char landOwnerNameLoopForModification = 'y';
						while (landOwnerNameLoopForModification == 'y') {
							System.out.println("Enter the Owner Name :");
							String ownerName = scanner.nextLine();
							if (ownerName.equalsIgnoreCase("exit")) {
								LandMain.mainLand();
							}
							if (Validation.isStringOnlyAlphabet(ownerName)) {
								landOwnerNameLoopForModification = 'n';
								landBean04.setValue(landOwnerNameLoopForModification);
							} else {
								System.err.println("Enter Only Alphabates !!!!");
							}
						}
						try {
							if (landServices.modifyLandPrice(landBean04.getLandId(), landBean04.getValue())) {
								System.out.println("Update Successfully");
							}
						} catch (LandExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 4:
						return;

					default:
						System.err.println("Invalid Choice ");
						break;
					}
				}

			case 4:
				searchLand();
				break;

			case 5:
				getAllLand();
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

	public static void searchLand() {
		LandBean landBean04 = new LandBean();

		char landIdLoopForValidation = 'y';
		int landIdForSearch = 0;
		while (landIdLoopForValidation == 'y') {
			System.out.println("Enter The Land Id :");
			System.out.println("=======================");
			String landIdForValidation = scanner.nextLine();
			if (Validation.isNumber1(landIdForValidation)) {
				landIdForSearch = Integer.parseInt(landIdForValidation);
				landIdLoopForValidation = 'n';
			} else if (landIdForValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		landBean04.setLandId(landIdForSearch);

		try {
			List<LandBean> l1 = landServices.searchLand(landBean04.getLandId());
			for (LandBean landBean : l1) {
				if (l1 != null) {
					System.out.println("Land Id	:" + landBean.getLandId());
					System.out.println("Land Location :" + landBean.getLocation());
					System.out.println("Land Owner :" + landBean.getOwnerName());
					System.out.println("Land Value :" + landBean.getValue());
					System.out.println("----------------------------");
				}

			}
		} catch (LandExceptions e) {
			System.err.println(e.getMessage());

		}
	}

	public static void getAllLand() {
		try {
			List<LandBean> landList = landServices.getAllLand();
			for (LandBean landBean : landList) {
				if (landList != null) {
					System.out.println("Land Id	:" + landBean.getLandId());
					System.out.println("Land Location :" + landBean.getLocation());
					System.out.println("Land Owner :" + landBean.getOwnerName());
					System.out.println("Land Value :" + landBean.getValue());
					System.out.println("----------------------------");
				}
			}
		} catch (LandExceptions e) {
			System.err.println(e.getMessage());
		}

	}
}
