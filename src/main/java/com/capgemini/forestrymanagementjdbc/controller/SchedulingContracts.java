package com.capgemini.forestrymanagementjdbc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.exception.ContractsExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;
import com.capgemini.forestrymanagementjdbc.services.ContractorServices;

public class SchedulingContracts {

	private static Scanner scanner = new Scanner(System.in);
	public static void schedulingContracts() {

		ContractorServices contractorServices = Factory.getContrServ();
		ContractorBean contractBean = Factory.getContrBean();

		char schedulingContractLoop = 'y';
		while (schedulingContractLoop == 'y') {
			char schedulingContractLoopChoices = 'y';
			int schedulingChoice = 0;
			while (schedulingContractLoopChoices == 'y') {
				System.out.println("----CONTRACTS----");
				System.out.println("Enter 1 : Schedule Contracts\nEnter 2 : Delete Contracts\nEnter 3 : Get Contracts\n"
						+ "Enter 4 : Get All Contracts\nEnter 5 : Back");
				String scheulerChoicesValidation = scanner.nextLine();
				if (Validation.isNumber1(scheulerChoicesValidation)) {
					schedulingChoice = Integer.parseInt(scheulerChoicesValidation);
					schedulingContractLoopChoices = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (schedulingChoice) {
			case 1:
				char schedulingContract = 'y';
				int schedulingContractNo = 0;
				while (schedulingContract == 'y') {
					System.out.println("Enter The Contract no:");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						schedulingContractNo = Integer.parseInt(contractNoValidation);
						schedulingContract = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						SchedulingContracts.schedulingContracts();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(schedulingContractNo);

				char deliveryDateLoopForSchedule = 'y';
				while (deliveryDateLoopForSchedule == 'y') {
					System.out.println("enter the Delivery Date (dd/mm/yyyy) : ");
					String schedulingDateValidation = scanner.nextLine();
					if (schedulingDateValidation.equalsIgnoreCase("exit")) {
						return;
					}
					if (!Validation.isValidDate(schedulingDateValidation)) {
						deliveryDateLoopForSchedule = 'n';
						contractBean.setDeliDate(schedulingDateValidation);
					}  else {
						System.err.println("Enter currect date Format!!!!");
					}
				}

				char scheduleStatusLoop = 'y';
				while (scheduleStatusLoop == 'y') {
					System.out.println("Enter The Status [Approved/Reject] ");
					String statusValidation = scanner.nextLine();
					if (statusValidation.equalsIgnoreCase("exit")) {
						return;
					}
					if (Validation.isStringOnlyAlphabet(statusValidation)) {
						scheduleStatusLoop = 'n';
						contractBean.setStatus(statusValidation);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				try {
					if (contractorServices.sheduleContract(contractBean.getContractNo(), contractBean.getDeliDate(), contractBean.getStatus())) {
						System.out.println("Scheduled Successfully");
					}
				} catch (ContractsExceptions e1) {
					System.err.println(e1.getMessage());
				}

				break;

			case 2:
				char contractNoDeleteLoop = 'y';
				int contractNoForDelete = 0;
				while (contractNoDeleteLoop == 'y') {
					System.out.println("Enter Contractor no to delete: ");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						contractNoForDelete = Integer.parseInt(contractNoValidation);
						contractNoDeleteLoop = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						SchedulingContracts.schedulingContracts();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(contractNoForDelete);

				try {
					if (contractorServices.deleteContractor(contractBean.getContractNo())) {
						System.out.println("Successfully deleted");
					}
				} catch (ContractsExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				char contractNoLoopForSearch = 'y';
				int contractNoForSearch = 0;
				while (contractNoLoopForSearch == 'y') {
					System.err.println("Enter Contractor no:");
					String contractNoForValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoForValidation)) {
						contractNoForSearch = Integer.parseInt(contractNoForValidation);
						contractNoLoopForSearch = 'n';
					} else if (contractNoForValidation.equalsIgnoreCase("exit")) {
						SchedulingContracts.schedulingContracts();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(contractNoForSearch);

				try {
					ArrayList<ContractorBean> searchedContractList = contractorServices.getContractor(contractBean.getContractNo());
					for (ContractorBean contractorBean : searchedContractList) {
						if (searchedContractList != null && !searchedContractList.isEmpty()) {
							System.out.println("Contract no :" + contractorBean.getContractNo());
							System.out.println("Customer Id : " + contractorBean.getCustomerId());
							System.out.println("Product id  :" + contractorBean.getProductId());
							System.out.println("Quantity :" + contractorBean.getQuantity());
							System.out.println("Delivery Date :" + contractorBean.getDeliDate());
							System.out.println("Status :" + contractorBean.getStatus());
							System.out.println("-----------------------");
						}
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				try {
					ArrayList<ContractorBean> allContractList = contractorServices.getAllContractor();
					for (ContractorBean contractorBean : allContractList) {
						if (allContractList != null) {
							System.out.println("Contract no :" + contractorBean.getContractNo());
							System.out.println("Customer Id : " + contractorBean.getCustomerId());
							System.out.println("Product id  :" + contractorBean.getProductId());
							System.out.println("Quantity :" + contractorBean.getQuantity());
							System.out.println("Delivery Date :" + contractorBean.getDeliDate());
							System.out.println("Status :" + contractorBean.getStatus());
							System.out.println("-----------------------");
						}
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				return;

			default:
				System.err.println("InValid choice :( ");
				break;
			}
		}
	}
}
