package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.exception.ContractsExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ContractServices;

public class Scheduling {

	private static Contracts contracts = Factory.getContracts();
	private static ContractServices contractService = Factory.getContractServImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void schedulingController() {

		char schedulerControllerLoop = 'y';
		while (schedulerControllerLoop == 'y') {

			char schedulerContractChoiceLoop = 'y';
			int contractChoice = 0;
			while (schedulerContractChoiceLoop == 'y') {
				System.out.println("----CONTRACTS----");
				System.out.println("Enter 1 : Schedule Contracts\nEnter 2 : Delete Contracts\nEnter 3 : Get Contracts\n"
						+ "Enter 4 : Get All Contracts\nEnter 5 : Back");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					contractChoice = Integer.parseInt(choiceValidation);
					schedulerContractChoiceLoop = 'n';
				} else if (choiceValidation.equalsIgnoreCase("exit")) {
					Scheduling.schedulingController();
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (contractChoice) {
			case 1:
//				Contracts contracts1 = new Contracts();
				char contractNoLoopForScheduler = 'y';
				int contractNoForScheduler = 0;
				while (contractNoLoopForScheduler == 'y') {
					System.out.println("Enter Contract no:");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						contractNoForScheduler = Integer.parseInt(contractNoValidation);
						contractNoLoopForScheduler = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setContractNo(contractNoForScheduler);

				char dateLoopForScheduling = 'y';
				while (dateLoopForScheduling == 'y') {
					System.out.println("Enter Delivery date (DD/MM/YYYY) : ");
					String schedulerDateValidation = scanner.nextLine();
					if (!Validation.isValidDate(schedulerDateValidation)) {
						dateLoopForScheduling = 'n';
						contracts.setDeliveryDate(schedulerDateValidation);
					} else if (schedulerDateValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingController();
					} else {
						System.err.println("Enter currect Date Format   DD/MM/YYYY!!!!\n");
					}
				}

				char quantityLoopForSchedule = 'y';
				while (quantityLoopForSchedule == 'y') {
					System.out.println("Enter the Quantity: ");
					String quantityValidation = scanner.nextLine();
					if (quantityValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingController();
					}
					if (Validation.isNumber1(quantityValidation) || Validation.isStringOnlyAlphabet(quantityValidation)) {
						quantityLoopForSchedule = 'n';
						contracts.setQuantity(quantityValidation);
					} else {
						System.err.println("Enter only integers:");
					}
				}

				char statusLoop = 'y';
				while (statusLoop == 'y') {
					System.out.println("Enter The status['Approved'/'reject'] ");
					String statusValidation = scanner.nextLine();
					if (statusValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingController();
					}
					if (Validation.isStringOnlyAlphabet(statusValidation)) {
						statusLoop = 'n';
						contracts.setStatus(statusValidation);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				try {
					if (contractService.scheduleContracts(contracts.getContractNo(), contracts.getDeliveryDate(), contracts.getQuantity(),
							contracts.getStatus())) {
						System.out.println("Scheduled Successfully");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:
				char contractIdLoop = 'y';
				int contractIdDelete = 0;
				while (contractIdLoop == 'y') {
					System.out.println("Enter Contract id to delete: ");
					String contractIdValidation = scanner.nextLine();
					if (Validation.isNumber1(contractIdValidation)) {
						contractIdDelete = Integer.parseInt(contractIdValidation);
						contractIdLoop = 'n';
					} else if (contractIdValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setContractNo(contractIdDelete);

				try {
					if (contractService.deleteContract(contracts.getContractNo())) {
						System.out.println("Successfully deleted");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				ContractorController.searchContract();
				break;

			case 4:
				ContractorController.getAllContract();
				break;

			case 5:
				return;

			default:
				System.err.println("InValid choice :( ");
				break;
			}
		}
	}

	public static void searchContract() {
		char searchContractsLoop = 'y';
		int searchContract = 0;
		while (searchContractsLoop == 'y') {
			System.err.println("Enter Contract no:");
			String contractNoForValidation = scanner.nextLine();
			if (Validation.isNumber1(contractNoForValidation)) {
				searchContract = Integer.parseInt(contractNoForValidation);
				searchContractsLoop = 'n';
			} else if (contractNoForValidation.equalsIgnoreCase("exit")) {
				Scheduling.schedulingController();
			} else {
				System.err.println("Enter only integers:");
			}
		}
		contracts.setContractNo(searchContract);

		try {
			Contracts contract = contractService.getContract(contracts.getContractNo());
			if (contract != null) {
				System.out.println("Contract no :" + contract.getContractNo());
				System.out.println("Customer Id : " + contract.getContractNo());
				System.out.println("Product id  :" + contract.getProdId());
				System.out.println("Delivery Date :" + contract.getDeliveryDate());
				System.out.println("Quantity :" + contract.getQuantity());
				System.out.println("Status :" + contract.getStatus());
				System.out.println("-------------------------");

			}

		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
			ContractorController.contractorContr();
		}

	}

	public static void getAllContract() {

		try {
			ArrayList<Contracts> allContracts = contractService.getAllContract();
			for (Contracts contract : allContracts) {
				if (allContracts != null) {
					System.out.println("Contract no :" + contract.getContractNo());
					System.out.println("Customer Id : " + contract.getCustomerId());
					System.out.println("Product id  :" + contract.getProdId());
					System.out.println("Delivery Date :" + contract.getDeliveryDate());
					System.out.println("Quantity :" + contract.getQuantity());
					System.out.println("Status :" + contract.getStatus());
					System.out.println("-----------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
			ContractorController.contractorContr();
		}
	}
}
