package com.capgemini.forestrymanagementjdbc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.exception.ContractsExceptions;
import com.capgemini.forestrymanagementjdbc.exception.CustomerExceptions;
import com.capgemini.forestrymanagementjdbc.exception.ProductExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;
import com.capgemini.forestrymanagementjdbc.services.ContractorServices;
import com.capgemini.forestrymanagementjdbc.services.CustomerServices;
import com.capgemini.forestrymanagementjdbc.services.ProductServices;

public class ContractorController {

	private static Scanner scanner = new Scanner(System.in);

	public static void contractorContr() {

		ContractorServices contractServices = Factory.getContrServ();
		ContractorBean contractBean = Factory.getContrBean();
		CustomerServices customerServices = Factory.getCustServ();
		ProductServices productServices = Factory.getProdServ();

		char contractControllerLoop = 'y';
		while (contractControllerLoop == 'y') {
			char contractChoiceLoop = 'y';
			int contractChoices = 0;
			while (contractChoiceLoop == 'y') {
				System.out.println("----CONTRACTS----");
				System.out.println("Enter 1 : Add Contracts\nEnter 2 : Delete Contracts\nEnter 3 : Get Contracts\n"
						+ "Enter 4 : Get All Contracts\nEnter 5 : Back");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					contractChoices = Integer.parseInt(choiceValidation);
					contractChoiceLoop = 'n';
				} else if (choiceValidation.equalsIgnoreCase("exit")) {
					ContractorController.contractorContr();
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (contractChoices) {
			case 1:
				char contractNoForAddLoop = 'y';
				int contractNoForAdd = 0;
				while (contractNoForAddLoop == 'y') {
					System.out.println("Enter The Contract no:");
					String contractNoForValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoForValidation)) {
						contractNoForAdd = Integer.parseInt(contractNoForValidation);
						contractNoForAddLoop = 'n';
					} else if (contractNoForValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(contractNoForAdd);

				char customerIdForAddLoop = 'y';
				int customerIdForAdd = 0;
				while (customerIdForAddLoop == 'y') {
					System.out.println("Enter the Customer id:");
					String customerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(customerIdValidation)) {
						customerIdForAdd = Integer.parseInt(customerIdValidation);

						try {
							ArrayList<CustomerBean> searchedCustomer = customerServices.getCustomer(customerIdForAdd);
							for (CustomerBean customerBean : searchedCustomer) {
								if (customerBean.getCustomerId() == customerIdForAdd) {
									customerIdForAddLoop = 'n';
								}
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
					} else if (customerIdValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setCustomerId(customerIdForAdd);

				char productIdForAddLoop = 'y';
				int productIdForAdding = 0;
				while (productIdForAddLoop == 'y') {
					System.out.println("Enter Product Id:");
					String productIdValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdValidation)) {
						productIdForAdding = Integer.parseInt(productIdValidation);

						try {
							ArrayList<ProductBean> searchedProduct = productServices.getProduct(productIdForAdding);
							for (ProductBean productBean : searchedProduct) {
								if (productBean.getProductId() == productIdForAdding) {
									productIdForAddLoop = 'n';
								}
							}
						} catch (ProductExceptions e) {
							System.err.println(e.getMessage());
						}

					} else if (productIdValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setProductId(productIdForAdding);

				char quantityForAddLoop = 'y';
				int quantityForAdding = 0;
				while (quantityForAddLoop == 'y') {
					System.out.println("Enter the Quantity: ");
					String quantityForValidation = scanner.nextLine();
					if (Validation.isNumber1(quantityForValidation)) {
						quantityForAdding = Integer.parseInt(quantityForValidation);
						quantityForAddLoop = 'n';
					} else if (quantityForValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setQuantity(quantityForAdding);

				String status = "pending";
				contractBean.setStatus(status);

				String date = "not_scheduled";
				contractBean.setDeliDate(date);

				try {
					if (contractServices.addContractor(contractBean)) {
						System.out.println("Add Successfully");
					}
				} catch (ContractsExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				char contractIdForDeleteLoop = 'y';
				int contractIdForLoop = 0;
				while (contractIdForDeleteLoop == 'y') {
					System.out.println("Enter Contractor id to delete: ");
					String contractNoForValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoForValidation)) {
						contractIdForLoop = Integer.parseInt(contractNoForValidation);
						contractIdForDeleteLoop = 'n';
					} else if (contractNoForValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(contractIdForLoop);

				try {
					if (contractServices.deleteContractor(contractBean.getContractNo())) {
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
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						contractNoForSearch = Integer.parseInt(contractNoValidation);
						contractNoLoopForSearch = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contractBean.setContractNo(contractNoForSearch);

				try {
					ArrayList<ContractorBean> searchedContractList = contractServices.getContractor(contractBean.getContractNo());
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
					ArrayList<ContractorBean> allContracts = contractServices.getAllContractor();
					for (ContractorBean contractorBean : allContracts) {
						if (allContracts != null) {
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
