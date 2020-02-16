package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.exception.CustomerExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.CustomerService;

public class CustomerController {

	static Customer customer;
	private static Scanner scanner = new Scanner(System.in);
	private static CustomerService customerService = Factory.getCustomerServImpl();

	public static void custControl() {

		customer = Factory.getCustomer();
		char customerControllerLoop = 'y';
		while (customerControllerLoop == 'y') {
			char customerChoiceLoop = 'y';
			int customerChoice = 0;
			while (customerChoiceLoop == 'y') {
				System.out.println("----Customer----");
				System.out.println(
						"Enter 1 : Add Customer\nEnter 2 : Delete Customer\nEnter 3 : Modify Customer\nEnter 4 : Get Customer\nEnter 5 : Get All Customers\nEnter 6 : Back\nEnter 7 : Home");
				String v1 = scanner.nextLine();
				if (Validation.isNumber1(v1)) {
					customerChoice = Integer.parseInt(v1);
					customerChoiceLoop = 'n';
				} else if (v1.equalsIgnoreCase("exit")) {
					CustomerController.custControl();
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (customerChoice) {
			case 1:
				char customerIdLoopForAdd = 'y';
				int customerIdForAdd = 0;
				while (customerIdLoopForAdd == 'y') {
					System.out.println("Enter The customer id:");
					String customerId = scanner.nextLine();
					if (Validation.isNumber1(customerId)) {
						customerIdForAdd = Integer.parseInt(customerId);
						customerIdLoopForAdd = 'n';
					} else if (customerId.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				customer.setCustomerId(customerIdForAdd);

				char customerNameLoopForAdd = 'y';
				while (customerNameLoopForAdd == 'y') {
					System.out.println("Enter the customer name");
					String customerNameValidation = scanner.nextLine();
					if (customerNameValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					}
					if (Validation.isStringOnlyAlphabet(customerNameValidation)) {
						customerNameLoopForAdd = 'n';
						customer.setCustomerName(customerNameValidation);
					}
					if (customerNameValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char streetAddress1LoopForAdd = 'y';
				while (streetAddress1LoopForAdd == 'y') {
					System.out.println("Enter the Street Address 1");
					String customerAddress1Validation = scanner.nextLine();
					if (customerAddress1Validation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					}
					if (Validation.isStringOnlyAlphabet(customerAddress1Validation)) {
						streetAddress1LoopForAdd = 'n';
						customer.setStreetAdd1(customerAddress1Validation);
					} else {
						System.err.println("Enter only Alphabets!!!!!");
					}
				}

				char streetAddress2LoopForAdd = 'y';
				while (streetAddress2LoopForAdd == 'y') {
					System.out.println("Enter the Street Address 2");
					String customerAddress2 = scanner.nextLine();
					if (customerAddress2.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					}
					if (Validation.isStringOnlyAlphabet(customerAddress2)) {
						streetAddress2LoopForAdd = 'n';
						customer.setStreetAdd2(customerAddress2);
					} else {
						System.err.println("Enter only Alphabets!!!!!");
					}
				}

				char customerTownLoopForAdd = 'y';
				while (customerTownLoopForAdd == 'y') {
					System.out.println("enter the Town..");
					String customerTownValidation = scanner.nextLine();
					if (customerTownValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					}
					if (Validation.isStringOnlyAlphabet(customerTownValidation)) {
						customerTownLoopForAdd = 'n';
						customer.setTown(customerTownValidation);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char postalCodeLoopForAdd = 'y';
				int postalCodeForAdd = 0;
				while (postalCodeLoopForAdd == 'y') {
					System.out.println("Enter The Postal Code :");
					String postalCodeValidation = scanner.nextLine();
					if (Validation.isNumber1(postalCodeValidation) && postalCodeValidation.length() == 6) {
						postalCodeForAdd = Integer.parseInt(postalCodeValidation);
						postalCodeLoopForAdd = 'n';
					} else if (postalCodeValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter only 6 digit integers Allowed:");
					}
				}
				customer.setPostalCode(postalCodeForAdd);

				char telephoneLoopForAdd = 'y';
				long telephoneNoForAdd = 0;
				while (telephoneLoopForAdd == 'y') {
					System.out.println("Enter the Telephone: ");
					String telephoneValidation = scanner.nextLine();
					if (Validation.isValidTel(telephoneValidation)) {
						telephoneNoForAdd = Long.parseLong(telephoneValidation);
						telephoneLoopForAdd = 'n';
					} else if (telephoneValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter Valid phone no:");
					}
				}
				customer.setTelephone(telephoneNoForAdd);

				char emailLoopForAdd = 'y';
				while (emailLoopForAdd == 'y') {
					System.out.println("enter the Email: ");
					String emailValidation = scanner.nextLine();
					if (Validation.isValid(emailValidation)) {
						emailLoopForAdd = 'n';
						customer.setEmail(emailValidation);
					} else if (emailValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Email currect Format!!!!");
					}
				}

				try {
					if (customerService.addCustomer(customer)) {
						System.out.println("Add Successfully");
					}
				} catch (CustomerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				char customerIdForDeleteLoop = 'y';
				int customerIdForDelete = 0;
				while (customerIdForDeleteLoop == 'y') {
					System.out.println("Enter Customer id: ");
					String customerIdValidation = scanner.nextLine();
					if (Validation.isNumber1(customerIdValidation)) {
						customerIdForDelete = Integer.parseInt(customerIdValidation);
						customerIdForDeleteLoop = 'n';
					} else if (customerIdValidation.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				customer.setCustomerId(customerIdForDelete);

				try {
					if (customerService.deleteCustomer(customer.getCustomerId())) {
						System.out.println("Successfully deleted");
					}
				} catch (CustomerExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				char customerUpdateLoopForChoice = 'y';
				while (customerUpdateLoopForChoice == 'y') {
					char modificationLoop = 'y';
					int customerModificationChoice = 0;
					while (modificationLoop == 'y') {
						System.out.println("Enter Choice to Modify :");
						System.out.println(
								"Enter 1 : Customer Name\nEnter 2 : Customer Street Address 2\nEnter 3 : Customer Street Address 2\n"
										+ "Enter 4 : Customer Town\nEnter 5 : Customers postalcode\nEnter 6 : Telephone \nEnter 7 : email id\n"
										+ "Enter 8 : Back");
						String choiceValidation = scanner.nextLine();
						if (Validation.isNumber1(choiceValidation)) {
							customerModificationChoice = Integer.parseInt(choiceValidation);
							modificationLoop = 'n';
						} else {
							System.err.println("Enter only integers:");
						}
					}
					switch (customerModificationChoice) {
					case 1:
						char customerIdLoopForName = 'y';
						int customerIdForName = 0;
						while (customerIdLoopForName == 'y') {
							System.out.println("Enter Customer id : ");
							String customerIdForValidation = scanner.nextLine();
							if (Validation.isNumber1(customerIdForValidation)) {
								customerIdForName = Integer.parseInt(customerIdForValidation);
								customerIdLoopForName = 'n';
							} else if (customerIdForValidation.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(customerIdForName);

						char customerNameLoopForUpdate = 'y';
						while (customerNameLoopForUpdate == 'y') {
							System.out.println("Enter the customer name");
							String customerNameValidation = scanner.nextLine();
							if (customerNameValidation.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							}
							if (Validation.isStringOnlyAlphabet(customerNameValidation)) {
								customerNameLoopForUpdate = 'n';
								customer.setCustomerName(customerNameValidation);

							} else {
								System.out.println("Enter only Alphabets!!!!");
							}
						}

						try {
							if (customerService.modifyCustomer(customer.getCustomerId(), customer.getCustomerName())) {
								System.out.println("Customer Name successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 2:
						char customerIdLoop = 'y';
						int customerId = 0;
						while (customerIdLoop == 'y') {
							System.out.println("Enter Customer id : ");
							String customer = scanner.nextLine();
							if (Validation.isNumber1(customer)) {
								customerId = Integer.parseInt(customer);
								customerIdLoop = 'n';
							} else if (customer.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(customerId);

						char streetAdd1Loop = 'y';
						while (streetAdd1Loop == 'y') {
							System.out.println("enter the Street Address 1");
							String cadd1 = scanner.nextLine();
							if (cadd1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							}
							if (Validation.isStringOnlyAlphabet(cadd1)) {
								streetAdd1Loop = 'n';
								customer.setStreetAdd1(cadd1);
							} else {
								System.out.println("Enter only Alphabets!!!!!");
							}
						}
						try {
							if (customerService.modifyCustomerAdd1(customer.getCustomerId(), customer.getStreetAdd1())) {
								System.out.println("Customer Street Address1 successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 3:
						char custIdLoop1 = 'y';
						int custId1 = 0;
						while (custIdLoop1 == 'y') {
							System.out.println("Enter Customer id : ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								custId1 = Integer.parseInt(v1);
								custIdLoop1 = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(custId1);

						char streetAdd1Loop1 = 'y';
						while (streetAdd1Loop1 == 'y') {
							System.out.println("enter the Street Address 1");
							String cadd1 = scanner.nextLine();
							if (cadd1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							}
							if (Validation.isStringOnlyAlphabet(cadd1)) {
								streetAdd1Loop = 'n';
								customer.setStreetAdd1(cadd1);
							} else {
								System.out.println("Enter only Alphabets!!!!!");
							}
						}
						try {
							if (customerService.modifyCustomerAdd2(customer.getCustomerId(), customer.getStreetAdd2())) {
								System.out.println("Customer Street Address2 successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 4:
						char custIdLoop2 = 'y';
						int custId2 = 0;
						while (custIdLoop2 == 'y') {
							System.out.println("Enter Customer id : ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								custId2 = Integer.parseInt(v1);
								custIdLoop2 = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(custId2);

						char custTownLoop = 'y';
						while (custTownLoop == 'y') {
							System.out.println("Enter the Town..");
							String cadd2 = scanner.nextLine();
							if (cadd2.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							}
							if (Validation.isStringOnlyAlphabet(cadd2)) {
								custTownLoop = 'n';
								customer.setTown(cadd2);
							} else {
								System.out.println("Enter only Alphabets!!!!");
							}
						}
						try {
							if (customerService.modifyCustomerTown(customer.getCustomerId(), customer.getTown())) {
								System.out.println("Customer Town successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 5:
						char custIdLoop3 = 'y';
						int custId3 = 0;
						while (custIdLoop3 == 'y') {
							System.out.println("Enter Customer id : ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								custId3 = Integer.parseInt(v1);
								custIdLoop3 = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(custId3);

						int postalCode = 0;
						char postalCodeLoop = 'y';
						while (postalCodeLoop == 'y') {
							System.out.println("Enter The Postal code:");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								postalCode = Integer.parseInt(v1);
								postalCodeLoop = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setPostalCode(postalCode);

						try {
							if (customerService.modifyCustomerPost(customer.getCustomerId(), customer.getPostalCode())) {
								System.out.println("Customer Postal Code successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 6:
						char custIdLoop4 = 'y';
						int custId4 = 0;
						while (custIdLoop4 == 'y') {
							System.out.println("Enter Customer id : ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								custId4 = Integer.parseInt(v1);
								custIdLoop4 = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(custId4);

						long telephone = 0;
						char telephoneLoop = 'y';
						while (telephoneLoop == 'y') {
							System.out.println("Enter The Telephone:");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								telephone = Long.parseLong(v1);
								telephoneLoop = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setTelephone(telephone);
						try {
							if (customerService.modifyCustomerTel(customer.getCustomerId(), customer.getTelephone())) {
								System.out.println("Customer Telephone successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}

						break;

					case 7:
						char custIdLoop5 = 'y';
						int custId5 = 0;
						while (custIdLoop5 == 'y') {
							System.out.println("Enter Customer id : ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								custId5 = Integer.parseInt(v1);
								custIdLoop5 = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						customer.setCustomerId(custId5);

						char emailLoop = 'y';
						while (emailLoop == 'y') {
							System.out.println("enter the Email: ");
							String cadd3 = scanner.nextLine();
							if (Validation.isValid(cadd3)) {
								emailLoop = 'n';
								customer.setEmail(cadd3);
							} else if (cadd3.equalsIgnoreCase("exit")) {
								CustomerController.custControl();
							} else {
								System.err.println("Email currect Format!!!!");
							}
						}
						try {
							if (customerService.modifyCustomerEmail(customer.getCustomerId(), customer.getEmail())) {
								System.out.println("Customer Email successfully Modified");
							}
						} catch (CustomerExceptions e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 8:
						return;
					case 9:
						HomeForestry.mainHomeForestry();
						break;

					default:
						System.err.println("Invalid Choice :(");
						break;
					}
				}

			case 4:
				char customerIdLoopForSearch = 'y';
				int customerIdForSearch = 0;
				while (customerIdLoopForSearch == 'y') {
					System.out.println("Enter Customer id : ");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						customerIdForSearch = Integer.parseInt(v1);
						customerIdLoopForSearch = 'n';
					} else if (v1.equalsIgnoreCase("exit")) {
						CustomerController.custControl();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				customer.setCustomerId(customerIdForSearch);

				try {
					Customer searchedCustomer = customerService.getCustomer(customer.getCustomerId());
						if (searchedCustomer != null) {
							System.out.println("Customer ID: " + searchedCustomer.getCustomerId());
							System.out.println("Customer name: " + searchedCustomer.getCustomerName());
							System.out.println("Street address 1: " + searchedCustomer.getStreetAdd1());
							System.out.println("Street address 2: " + searchedCustomer.getStreetAdd2());
							System.out.println("Town :" + searchedCustomer.getTown());
							System.out.println("Postal Code: " + searchedCustomer.getPostalCode());
							System.out.println("Telephone: " + searchedCustomer.getTelephone());
							System.out.println("Email: " + searchedCustomer.getEmail());
							System.out.println("------------------------");
						}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				try {
					ArrayList<Customer> allCustomerList = customerService.getAllCust();
					for (Customer customer1 : allCustomerList) {
						if (allCustomerList != null) {
							System.out.println("Customer ID: " + customer1.getCustomerId());
							System.out.println("Customer name: " + customer1.getCustomerName());
							System.out.println("Street address 1: " + customer1.getStreetAdd1());
							System.out.println("Street address 2: " + customer1.getStreetAdd2());
							System.out.println("Town :" + customer1.getTown());
							System.out.println("Postal Code: " + customer1.getPostalCode());
							System.out.println("Telephone: " + customer1.getTelephone());
							System.out.println("Email: " + customer1.getEmail());
							System.out.println("------------------------");
						}
					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 6:
				return;

			case 7:
				HomeForestry.mainHomeForestry();
			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}
	
	public static void searchCustomer() {

		char customerIdLoopForSearch = 'y';
		int customerIdForSearch = 0;
		while (customerIdLoopForSearch == 'y') {
			System.out.println("Enter Customer id : ");
			String customerIdValidation = scanner.nextLine();
			if (Validation.isNumber1(customerIdValidation)) {
				customerIdForSearch = Integer.parseInt(customerIdValidation);
				customerIdLoopForSearch = 'n';
			} else if (customerIdValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		try {
			Customer customer = customerService.getCustomer(customerIdForSearch);
			if (customer != null) {
				System.out.println("Customer ID: " + customer.getCustomerId());
				System.out.println("Customer name: " + customer.getCustomerName());
				System.out.println("Street address 1: " + customer.getStreetAdd1());
				System.out.println("Street address 2: " + customer.getStreetAdd2());
				System.out.println("Town :" + customer.getTown());
				System.out.println("Postal Code: " + customer.getPostalCode());
				System.out.println("Telephone: " + customer.getTelephone());
				System.out.println("Email: " + customer.getEmail());
				System.out.println("------------------------");
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
			CustomerController.custControl();
		}
	}

	public static void getAllCustomer() {
		try {
			ArrayList<Customer> allCustomer = customerService.getAllCust();
			for (Customer Customer : allCustomer) {
				if (allCustomer != null) {
					System.out.println("Customer ID: " + Customer.getCustomerId());
					System.out.println("Customer name: " + Customer.getCustomerName());
					System.out.println("Street address 1: " + Customer.getStreetAdd1());
					System.out.println("Street address 2: " + Customer.getStreetAdd2());
					System.out.println("Town :" + Customer.getTown());
					System.out.println("Postal Code: " + Customer.getPostalCode());
					System.out.println("Telephone: " + Customer.getTelephone());
					System.out.println("Email: " + Customer.getEmail());
					System.out.println("------------------------");
				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
			CustomerController.custControl();
		}

	}


}
