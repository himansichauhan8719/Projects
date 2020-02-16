package com.capgemini.forestrymanagementcollection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;
import com.capgemini.forestrymanagementcollection.exception.ContractsExceptions;
import com.capgemini.forestrymanagementcollection.exception.CustomerExceptions;
import com.capgemini.forestrymanagementcollection.exception.ProductExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.ContractServices;

public class ContractMain {

	private static ContractServices contractServices = Factory.getContractServices();
	static Scanner scanner = new Scanner(System.in);

	public static void contractMain() {

		char contractMainLoop = 'y';
		while (contractMainLoop == 'y') {
			int contractChoice = 0;
			char contractMainLoopChoice = 'y';
			while (contractMainLoopChoice == 'y') {
				System.out.println(
						"Enter 1 : Add Contract \nEnter 2 : Delete Contract \nEnter 3 : Show Contracts \nEnter 4 : Show all Contracts \nEnter 5 : Back ");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					contractChoice = Integer.parseInt(choiceValidation);
					contractMainLoopChoice = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (contractChoice) {
			case 1:
				ContractBean contractBean = new ContractBean();
				char contractNoBeanLoopForAdd = 'y';
				while (contractNoBeanLoopForAdd == 'y') {
					System.out.println("Enter the Contract No: ");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						int contractNo = Integer.parseInt(contractNoValidation);
						contractBean.setContractNo(contractNo);
						contractNoBeanLoopForAdd = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						ContractMain.contractMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				int customerIdForAdd = 0;
				char customerIdLoopForAdd = 'y';
				while (customerIdLoopForAdd == 'y') {
					System.out.println("Enter the Customer id: ");
					String customerIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(customerIdForValidation)) {
						customerIdForAdd = Integer.parseInt(customerIdForValidation);

						try {
							if (CustomerMain.getCustForContract(customerIdForAdd)) {
								customerIdLoopForAdd = 'n';
							}
						} catch (CustomerExceptions e) {
							System.out.println("To exit Enter exit");
							System.err.println(e.getMessage());
						}
					} else if (customerIdForValidation.equalsIgnoreCase("exit")) {
						return;
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setCustomerId(customerIdForAdd);

				int productIdForAdd = 0;
				char productIdLoopForAdd = 'y';
				while (productIdLoopForAdd == 'y') {
					System.out.println("Enter the Product id: ");
					String productIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdForValidation)) {
						productIdForAdd = Integer.parseInt(productIdForValidation);
						try {
							if (ProductMain.getProdForContract(productIdForAdd)) {
								productIdLoopForAdd = 'n';
							}
						} catch (ProductExceptions e) {
							System.out.println("To exit Enter exit");
							System.err.println(e.getMessage());
						}
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setProductId(productIdForAdd);

				char quantityLoopForAdd = 'y';
				while (quantityLoopForAdd == 'y') {
					System.out.println("Enter the Quantity: ");
					String quantityForValidation = scanner.nextLine();
					if (Validation.isNumber1(quantityForValidation)) {
						int quantity = Integer.parseInt(quantityForValidation);
						contractBean.setQuantity(quantity);
						quantityLoopForAdd = 'n';
					} else if (quantityForValidation.equalsIgnoreCase("exit")) {
						ContractMain.contractMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				contractBean.setDeliveryDate("Not Scheduled");
				contractBean.setStatus("Pending");

				try {
					if (contractServices.addContract(contractBean)) {
						System.out.println("Added Successfully");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				ContractBean contractBean01 = new ContractBean();
				char contractNoLoopForDelete = 'y';
				while (contractNoLoopForDelete == 'y') {
					System.out.println("Enter the Contract No to delete: ");
					System.out.println("==================================");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						int contractNo = Integer.parseInt(contractNoValidation);
						contractBean01.setProductId(contractNo);
						contractNoLoopForDelete = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						ContractMain.contractMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				try {
					if (contractServices.deleteContract(contractBean01.getContractNo())) {
						System.out.println("Contract deleted...");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				ContractMain.showContract();
				break;

			case 4:
				ContractMain.showAllContract();
				break;

			case 5:
				return;

			default:
				System.err.println("Invalid Choice :( ");
				break;
			}
		}
	}

	public static void showContract() {
		ContractBean contractBean = new ContractBean();
		int contractNoForSearch = 0;
		char contractNoLoopForSearch = 'y';
		while (contractNoLoopForSearch == 'y') {
			System.out.println("Enter the Contract No: ");
			String contractNoValidation = scanner.nextLine();
			if (Validation.isNumber1(contractNoValidation)) {
				contractNoForSearch = Integer.parseInt(contractNoValidation);
				contractNoLoopForSearch = 'n';
			} else if (contractNoValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		contractBean.setContractNo(contractNoForSearch);

		System.out.println("The Details:");
		try {
			List<ContractBean> searchedContractList = contractServices.showContract(contractBean.getContractNo());
			for (ContractBean contractBean01 : searchedContractList) {
				if (searchedContractList != null) {
					System.out.println("Contract No is :" + contractBean01.getContractNo());
					System.out.println("Contract " + contractBean01.getCustomerId());
					System.out.println("Delivery Date :" + contractBean01.getDeliveryDate());
					System.out.println("Product Id :" + contractBean01.getProductId());
					System.out.println("Quantity :" + contractBean01.getQuantity());
					System.out.println("status :" + contractBean01.getStatus());
					System.out.println("----------------------------");
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void showAllContract() {
		List<ContractBean> allContractList = new ArrayList<ContractBean>();
		try {
			allContractList = contractServices.showAllContract();
			for (ContractBean contractBean : allContractList) {
				if (allContractList != null && !allContractList.isEmpty()) {
					System.out.println("Contract No :" + contractBean.getContractNo());
					System.out.println("Customer Id :" + contractBean.getCustomerId());
					System.out.println("Product Id :" + contractBean.getProductId());
					System.out.println("Delivery Date :" + contractBean.getDeliveryDate());
					System.out.println("Quantity :" + contractBean.getQuantity());
					System.out.println("status :" + contractBean.getStatus());
					System.out.println("----------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}
	}

	public static void scheduleContracts() {
		ContractBean contractBean = new ContractBean();
		char contractNoLoopForSchedule = 'y';
		while (contractNoLoopForSchedule == 'y') {
			System.out.println("Enter the Contract No: ");
			String contractNoForValidation = scanner.nextLine();
			if (Validation.isNumber1(contractNoForValidation)) {
				int v22 = Integer.parseInt(contractNoForValidation);
				contractBean.setContractNo(v22);
				contractNoLoopForSchedule = 'n';
			} else if (contractNoForValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}

		char deliveryDateLoopForSchedule = 'y';
		while (deliveryDateLoopForSchedule == 'y') {
			System.out.println("enter the Delivery Date (dd/mm/yyyy) : ");
			String delivaryDateValidation = scanner.nextLine();
			if (delivaryDateValidation.equalsIgnoreCase("exit")) {
				return;
			}
			if (!Validation.isValidDate(delivaryDateValidation)) {
				deliveryDateLoopForSchedule = 'n';
				contractBean.setDeliveryDate(delivaryDateValidation);
			} else {
				System.err.println("Enter currect date Format!!!!");
			}
		}

		char statusLoopForSchedule = 'y';
		while (statusLoopForSchedule == 'y') {
			System.out.println("Enter The Status ");
			String statusForValidation = scanner.nextLine();
			if (statusForValidation.equalsIgnoreCase("exit")) {
				return;
			}
			if (Validation.isStringOnlyAlphabet(statusForValidation)) {
				statusLoopForSchedule = 'n';
				contractBean.setStatus(statusForValidation);
			} else {
				System.err.println("Enter only Alphabets!!!!");
			}
		}

		try {
			if (contractServices.sheduleContract(contractBean.getContractNo(), contractBean.getDeliveryDate(),
					contractBean.getStatus())) {
				System.out.println("Scheduled Successfully");
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}
	}

}
