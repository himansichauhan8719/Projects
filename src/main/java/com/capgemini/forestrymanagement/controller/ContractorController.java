package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.exception.ContractsExceptions;
import com.capgemini.forestrymanagement.exception.CustomerExceptions;
import com.capgemini.forestrymanagement.exception.ProductExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ContractServices;
import com.capgemini.forestrymanagement.services.CustomerService;
import com.capgemini.forestrymanagement.services.ProductServices;

public class ContractorController {

	private static Contracts contracts = Factory.getContracts();
	private static ContractServices contractServices = Factory.getContractServImpl();
	private static CustomerService customerServices = Factory.getCustomerServImpl();
	private static ProductServices productServices = Factory.getProductServImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void contractorContr() {

		char contractLoop = 'y';
		while (contractLoop == 'y') {

			char contractChoiceLoop = 'y';
			int contractChoice = 0;
			while (contractChoiceLoop == 'y') {
				System.out.println("----CONTRACTS----");
				System.out.println("Enter 1 : Add Contracts\nEnter 2 : Delete Contracts\nEnter 3 : Get Contracts\n"
						+ "Enter 4 : Get All Contracts\nEnter 6 : Back");
				String contractChoiceValidation = scanner.nextLine();
				if (Validation.isNumber1(contractChoiceValidation)) {
					contractChoice = Integer.parseInt(contractChoiceValidation);
					contractChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (contractChoice) {
			case 1:
				char contractNoLoopForAdd = 'y';
				int contractNoForAdd = 0;
				while (contractNoLoopForAdd == 'y') {
					System.out.println("Enter The Contract no:");
					String contractNoValidation = scanner.nextLine();
					if (Validation.isNumber1(contractNoValidation)) {
						contractNoForAdd = Integer.parseInt(contractNoValidation);
						contractNoLoopForAdd = 'n';
					} else if (contractNoValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setContractNo(contractNoForAdd);

				char customerIdForAddLoop = 'y';
				int customerIdForAdd = 0;
				while (customerIdForAddLoop == 'y') {
					System.out.println("Enter the Customer id:");
					String customerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(customerIdValidation)) {
						customerIdForAdd = Integer.parseInt(customerIdValidation);

						try {
							Customer customer = customerServices.getCustomer(customerIdForAdd);
							if (customerIdForAdd == customer.getCustomerId()) {
								customerIdForAddLoop = 'n';
							}

						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
							System.out.println("To Cancel Enter exit ");

						}

					} else if (customerIdValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();

					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setCustomerId(customerIdForAdd);

				char productIdLoopForAdd = 'y';
				int productIdForAdd = 0;
				while (productIdLoopForAdd == 'y') {
					System.out.println("Enter Product Id:");
					String productIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdForValidation)) {
						productIdForAdd = Integer.parseInt(productIdForValidation);
						try {
							Product product = productServices.getProduct(productIdForAdd);
							if (productIdForAdd == product.getProductId()) {
								productIdLoopForAdd = 'n';
							}

						} catch (ProductExceptions e) {
							System.err.println(e.getMessage());
							System.out.println("To Cancel Enter exit ");
						}

					} else if (productIdForValidation.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();

					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setProdId(productIdForAdd);

				contracts.setDeliveryDate("Not Scheduled");
				contracts.setStatus("Pending");

				try {
					if (contractServices.addContract(contracts)) {
						System.out.println("Add Successfully");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:
				char contractNoForDeleteLoop = 'y';
				int contractNoForDelete = 0;
				while (contractNoForDeleteLoop == 'y') {
					System.out.println("Enter Contract No to delete: ");
					String contratNoForDelete = scanner.nextLine();
					if (Validation.isNumber1(contratNoForDelete)) {
						contractNoForDelete = Integer.parseInt(contratNoForDelete);
						contractNoForDeleteLoop = 'n';
					} else if (contratNoForDelete.equalsIgnoreCase("exit")) {
						ContractorController.contractorContr();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				contracts.setContractNo(contractNoForDelete);

				try {
					if (contractServices.deleteContract(contracts.getContractNo())) {
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
				return ;

			default:
				System.err.println("InValid choice :( ");
				break;
			}
		}
	}

	public static void searchContract() {
		char searchContractLoop = 'y';
		int contractNoForSearch = 0;
		while (searchContractLoop == 'y') {
			System.err.println("Enter Contract no:");
			String contractNoValidation = scanner.nextLine();
			if (Validation.isNumber1(contractNoValidation)) {
				contractNoForSearch = Integer.parseInt(contractNoValidation);
				searchContractLoop = 'n';
			} else if (contractNoValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		contracts.setContractNo(contractNoForSearch);

		try {
			Contracts searchedContracts = contractServices.getContract(contracts.getContractNo());
			if (searchedContracts != null) {
				System.out.println("Contract no :" + searchedContracts.getContractNo());
				System.out.println("Customer Id : " + searchedContracts.getContractNo());
				System.out.println("Product id  :" + searchedContracts.getProdId());
				System.out.println("Delivery Date :" + searchedContracts.getDeliveryDate());
				System.out.println("Quantity :" + searchedContracts.getQuantity());
				System.out.println("Status :" + searchedContracts.getStatus());
				System.out.println("------------------------");

			}

		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
			ContractorController.contractorContr();
		}

	}

	public static void getAllContract() {

		try {
			ArrayList<Contracts> allContracts = contractServices.getAllContract();
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
