package com.capgemini.forestrymanagementjdbc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.exception.CustomerExceptions;
import com.capgemini.forestrymanagementjdbc.exception.SchedulerExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;
import com.capgemini.forestrymanagementjdbc.services.CustomerServices;
import com.capgemini.forestrymanagementjdbc.services.ProductServices;

public class Schedular {
	private static Scanner scanner = new Scanner(System.in);
	public static void mainSchedular() {

		ProductServices productService = Factory.getProdServ();
		ProductBean productBean = Factory.getProdBean();
		CustomerServices customerService = Factory.getCustServ();
		CustomerBean customerBean = Factory.getCustBean();

		char mainSchedulerLoop = 'y';
		while (mainSchedulerLoop == 'y') {
			int schedulerForChoice = 0;
			char schedulerLoopForChoice = 'y';
			while (schedulerLoopForChoice == 'y') {
				System.out.println("-------WELCOME SCHEDULER-------");
				System.out.println(
						"Enter 1 : Contracts\nEnter 2 : Products\nEnter 3 : Customers\nEnter 4 : Back\nEnter 5 : Logout");
				String schedulerChoiceValidation = scanner.nextLine();
				if (Validation.isNumber1(schedulerChoiceValidation)) {
					schedulerForChoice = Integer.parseInt(schedulerChoiceValidation);
					schedulerLoopForChoice = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (schedulerForChoice) {
			case 1:
				SchedulingContracts.schedulingContracts();
				break;

			case 2:
				char productLoop = 'y';
				while (productLoop == 'y') {
					int productChoices = 0;
					char productLoopForChoices = 'y';
					while (productLoopForChoices == 'y') {
						System.out.println("------PRODUCTS------");
						System.out.println(
								"Enter 1 : Get All Products\nEnter 2 : Search Products\nEnter 3 : Back\nEnter 4 : Home");
						String productChoicesValidation = scanner.nextLine();
						if (Validation.isNumber1(productChoicesValidation)) {
							productChoices = Integer.parseInt(productChoicesValidation);
							productLoopForChoices = 'n';
						} else {
							System.err.println("Enter only integers:");
						}
					}
					switch (productChoices) {
					case 1:
						ArrayList<ProductBean> allProductList = productService.getAllProduct();
						try {
							for (ProductBean productBean01 : allProductList) {

								if (allProductList != null) {
									System.out.println("Product Name :" + productBean01.getProductName());
									System.out.println("Product Id :" + productBean01.getProductId());
									System.out.println("-------------------------");
								}
							}
						} catch (SchedulerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2:
						char productIdLoopForSearch = 'y';
						while (productIdLoopForSearch == 'y') {
							System.out.println("Enter the Prod id: ");
							String productIdValidation = scanner.nextLine();
							if (Validation.isNumber(productIdValidation)) {
								int productId = Integer.parseInt(productIdValidation);
								productBean.setProductId(productId);
								productIdLoopForSearch = 'n';
							} else if (productIdValidation.equalsIgnoreCase("exit")) {
								Schedular.mainSchedular();
							} else {
								System.err.println("Enter only integers:");
							}
						}

						try {
							ArrayList<ProductBean> searchedProductList = productService
									.getProduct(productBean.getProductId());
							for (ProductBean productBean03 : searchedProductList) {
								if (searchedProductList != null) {
									System.out.println("Product Name :" + productBean03.getProductName());
									System.out.println("Product Id :" + productBean03.getProductId());
								}
							}
						} catch (SchedulerExceptions e) {
							System.err.println(e.getMessage());

						}
						break;

					case 3:
						productLoop = 'n';
						break;
					case 4:
						HomeForestry.mainHomeForestry();

					default:
						System.err.println("Invalid choice :");
						break;
					}
				}
				break;

			case 3:
				char customerLoopForScheduler = 's';
				while (customerLoopForScheduler == 's') {
					int customerChoice = 0;
					char productChoiceForLoop = 'y';
					while (productChoiceForLoop == 'y') {
						System.out.println("------CUSTOMERS-----");
						System.out.println(
								"Enter 1 : Get All Customers\nEnter 2 : Search Customers\nEnter 3 : Back\nEnter 4 : Home");
						String customerChoiceValidation = scanner.nextLine();
						if (Validation.isNumber(customerChoiceValidation)) {
							customerChoice = Integer.parseInt(customerChoiceValidation);
							productChoiceForLoop = 'n';
						} else if (customerChoiceValidation.equalsIgnoreCase("exit")) {
							Schedular.mainSchedular();
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (customerChoice) {
					case 1:
						try {
							ArrayList<CustomerBean> allCustomerList = customerService.getAllCust();
							for (CustomerBean customerBean01 : allCustomerList) {
								if (allCustomerList != null) {
									System.out.println("Customer ID: " + customerBean01.getCustomerId());
									System.out.println("Customer name: " + customerBean01.getCustomerName());
									System.out.println("Street address 1: " + customerBean01.getStreetAdd1());
									System.out.println("Street address 2: " + customerBean01.getStreetAdd2());
									System.out.println("Town :" + customerBean01.getTown());
									System.out.println("Postal Code: " + customerBean01.getPostalCode());
									System.out.println("Telephone: " + customerBean01.getTelephone());
									System.out.println("Email: " + customerBean01.getEmail());
									System.out.println("------------------------");
								}
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2:
						char customerIdLoopForSearchCustomer = 'y';
						while (customerIdLoopForSearchCustomer == 'y') {
							System.out.println("Enter the Customer id: ");
							String customerIdForValidation = scanner.nextLine();
							if (Validation.isNumber(customerIdForValidation)) {
								int customerId = Integer.parseInt(customerIdForValidation);
								customerBean.setCustomerId(customerId);
								productChoiceForLoop = 'n';
							} else if (customerIdForValidation.equalsIgnoreCase("exit")) {
								Schedular.mainSchedular();
							} else {
								System.out.println("Enter only integers:");
							}
						}

						try {
							ArrayList<CustomerBean> searchedCustomerList = customerService
									.getCustomer(customerBean.getCustomerId());
							for (CustomerBean customerBean03 : searchedCustomerList) {
								if (searchedCustomerList != null) {
									System.out.println("Customer ID: " + customerBean03.getCustomerId());
									System.out.println("Customer name: " + customerBean03.getCustomerName());
									System.out.println("Street address 1: " + customerBean03.getStreetAdd1());
									System.out.println("Street address 2: " + customerBean03.getStreetAdd2());
									System.out.println("Town :" + customerBean03.getTown());
									System.out.println("Postal Code: " + customerBean03.getPostalCode());
									System.out.println("Telephone: " + customerBean03.getTelephone());
									System.out.println("Email: " + customerBean03.getEmail());
									System.out.println("------------------------");
								}
							}
						} catch (CustomerExceptions e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						customerLoopForScheduler = 'k';
						break;

					case 4:
						HomeForestry.mainHomeForestry();
					default:

						System.err.println("Invalid Choice :(");
						break;
					}
				}
				break;

			case 4:
				return;

			case 5:
				HomeForestry.mainHomeForestry();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
		scanner.close();
	}
}
