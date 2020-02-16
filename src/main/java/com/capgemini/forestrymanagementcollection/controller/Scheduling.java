package com.capgemini.forestrymanagementcollection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ContractBean;
import com.capgemini.forestrymanagementcollection.dao.ContractDao;
import com.capgemini.forestrymanagementcollection.exception.ContractsExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;

public class Scheduling {

	public static ContractDao customerDao = Factory.objDao();
	static Scanner scanner = new Scanner(System.in);

	public static void schedulingMain() {

		char scedulingChoiceLoop = 'y';
		while (scedulingChoiceLoop == 'y') {
			int schedulingChoices = 0;
			char shedulingLoop = 'y';
			while (shedulingLoop == 'y') {
				System.out.println(
						"Enter 1 : Schedule Contract \nEnter 2 : Delete Contract \nEnter 3 : Show Contracts \nEnter 4 : Show all 						Contracts \nEnter 5 : Back \nEnter 6 : Home ");
				String choicesValidation = scanner.nextLine();
				if (Validation.isNumber1(choicesValidation)) {
					schedulingChoices = Integer.parseInt(choicesValidation);
					shedulingLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (schedulingChoices) {
			case 1:
				ContractMain.scheduleContracts();
				break;

			case 2:
				ContractBean contr = new ContractBean();
				char productSchedulingLoop = 'y';
				while (productSchedulingLoop == 'y') {
					System.out.println("Enter the Product id to delete: ");
					System.out.println("=================================");
					String productIdValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdValidation)) {
						int v22 = Integer.parseInt(productIdValidation);
						contr.setProductId(v22);
						productSchedulingLoop = 'n';
					} else if (productIdValidation.equalsIgnoreCase("exit")) {
						Scheduling.schedulingMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}

				try {
					if (customerDao.deleteContract(contr.getProductId())) {
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
			case 5:
				scedulingChoiceLoop = 'n';
				break;

			case 6:
				MainHome.mainHome();
			default:
				System.err.println("Invalid Choice :( ");
				break;
			}
		}
	}

	public static void showContract() {
		ContractBean contractBean = new ContractBean();
		int contractNoForShow = 0;
		char searchContractsLoop = 'y';
		while (searchContractsLoop == 'y') {
			System.out.println("Enter the Contract Id: ");
			System.out.println("===========================");
			String contractIdValidation = scanner.nextLine();
			if (Validation.isNumber1(contractIdValidation)) {
				contractNoForShow = Integer.parseInt(contractIdValidation);
				searchContractsLoop = 'n';
			} else if (contractIdValidation.equalsIgnoreCase("exit")) {
				Scheduling.schedulingMain();
			} else {
				System.err.println("Enter only integers:");
			}
		}
		contractBean.setContractNo(contractNoForShow);

		System.out.println("The Details:");
		try {
			List<ContractBean> b = customerDao.showContract(contractBean.getContractNo());
			for (ContractBean contractBean01 : b) {
				if (b != null) {
					System.out.println("Contract No is :" + contractBean01.getContractNo());
					System.out.println("Contract " + contractBean01.getCustomerId());
					System.out.println("Product Id :" + contractBean01.getProductId());
					System.out.println("Delivery Date :" + contractBean01.getDeliveryDate());
					System.out.println("Quantity :" + contractBean01.getQuantity());
					System.out.println("Status :" + contractBean01.getStatus());
					System.out.println("----------------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}
	}

	public static void showAllContract() {
		List<ContractBean> allScheduler = new ArrayList<ContractBean>();
		try {
			allScheduler = customerDao.showAllContract();
			for (ContractBean contractBean : allScheduler) {
				if (allScheduler != null) {
					System.out.println("Contract No :" + contractBean.getContractNo());
					System.out.println("Customer Id :" + contractBean.getCustomerId());
					System.out.println("Product Id :" + contractBean.getProductId());
					System.out.println("Delivery Date :" + contractBean.getDeliveryDate());
					System.out.println("Quantity :" + contractBean.getQuantity());
					System.out.println("Status :" + contractBean.getStatus());
					System.out.println("----------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}
	}

}
