package com.capgemini.forestrymanagementcollection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.CustomerBean;
import com.capgemini.forestrymanagementcollection.exception.CustomerExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.CustomerServices;

public class CustomerMain {

	public static CustomerServices customerServices = Factory.getCustomerServices();
	static Scanner scanner = new Scanner(System.in);

	public static void customerMain() {

		int choice = 0;
		char custLoop = 'y';
		while (custLoop == 'y') {
			char customerChoiceLoop = 'y';
			while (customerChoiceLoop == 'y') {
				System.out.println(
						"Enter 1 : Add Customer Details \nEnter 2 : Delete Customer details \nEnter 3 : Modify Customer Details \n"
								+ "Enter 4 : Show All Customer Details \nEnter 5 : Search Customer Details\nEnter 6 : Back ");
				String isNumber = scanner.nextLine();

				if (Validation.isNumber1(isNumber)) {
					choice = Integer.parseInt(isNumber);
					customerChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (choice) {
			case 1:
				CustomerBean customerBean = new CustomerBean();
				char addCustomerIdLoop = 'y';
				int customerId = 0;
				while (addCustomerIdLoop == 'y') {
					System.out.println("Enter The customer id:");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						customerId = Integer.parseInt(v1);
						addCustomerIdLoop = 'n';
					} else if (v1.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				customerBean.setCustomerId(customerId);

				char customerNameLoop = 'y';
				while (customerNameLoop == 'y') {
					System.out.println("Enter the customer name");
					String customerName = scanner.nextLine();
					if (customerName.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					}
					if (Validation.isStringOnlyAlphabet(customerName)) {
						customerNameLoop = 'n';
						customerBean.setCustomerName(customerName);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				System.out.println("Enter the Street Address 1");
				customerBean.setStreetAdd1(scanner.nextLine());
				if (customerBean.getStreetAdd1().equalsIgnoreCase("exit")) {
					CustomerMain.customerMain();
				}

				System.out.println("Enter the Street Address 2");
				customerBean.setStreetAdd2(scanner.nextLine());
				if (customerBean.getStreetAdd2().equalsIgnoreCase("exit")) {
					CustomerMain.customerMain();
				}

				char customerTownLoop = 'y';
				while (customerTownLoop == 'y') {
					System.out.println("Enter the Town ");
					String town = scanner.nextLine();
					if (town.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					}
					if (Validation.isStringOnlyAlphabet(town)) {
						customerTownLoop = 'n';
						customerBean.setTown(town);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char customerPostalCode = 'y';
				while (customerPostalCode == 'y') {
					System.out.println("Enter the Postal Code: ");
					String customerTown = scanner.nextLine();
					if (Validation.isNumber1(customerTown) && customerTown.length() == 6) {
						int v22 = Integer.parseInt(customerTown);
						customerBean.setPostalCode(v22);
						customerPostalCode = 'n';
					} else if (customerTown.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					} else {
						System.err.println("Enter valid postal code \n(6 digits):");
					}
				}

				char customerEmailLoop = 'y';
				while (customerEmailLoop == 'y') {
					System.out.println("Enter the Email : ");
					String email = scanner.nextLine();
					if (Validation.isValid(email)) {
						customerEmailLoop = 'n';
						customerBean.setEmail(email);
					} else if (email.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					} else {
						System.err.println("Enter Valid Email id Format!!!!");
					}
				}

				char customerTelephoneLoop = 'y';
				while (customerTelephoneLoop == 'y') {
					System.out.println("Enter the Telephone : ");
					String customerTelephone = scanner.nextLine();
					if (Validation.isValidTel(customerTelephone)) {
						long tel = Long.parseLong(customerTelephone);
						customerBean.setTelephone(tel);
						customerTelephoneLoop = 'n';
					} else if (customerTelephone.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					} else {
						System.err.println("Enter Valid phone no:");
					}
				}

				try {
					if (customerServices.addCustomer(customerBean)) {
						System.out.println("Add Successfully");
					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				CustomerBean customerBean02 = new CustomerBean();
				char deleteCuustomerIdLoop = 'y';
				int customer = 0;
				while (deleteCuustomerIdLoop == 'y') {
					System.out.println("Enter The customer id:");
					System.out.println("=========================");
					String v1 = scanner.nextLine();
					if (Validation.isNumber1(v1)) {
						customer = Integer.parseInt(v1);
						deleteCuustomerIdLoop = 'n';
					} else if (v1.equalsIgnoreCase("exit")) {
						CustomerMain.customerMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				customerBean02.setCustomerId(customer);

				try {
					if (customerServices.deleteCustomer(customerBean02.getCustomerId())) {
						System.out.println("Successfully deleted...");
					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:

				System.out.println("Enter Modify the Data");
				int modifyCustomerChoiceLoop = 1;
				while (modifyCustomerChoiceLoop == 1) {
					int choiceForModification = 0;
					char modificationChoiceLoop = 'y';
					while (modificationChoiceLoop == 'y') {
						System.out.println(
								"Choose field  to be modify\nEnter 1 : Customer Name\nEnter 2 : Street1\nEnter 3 : Town\nEnter 4 : PostalCode\nEnter 5 : email\n"
										+ "Enter 6 : Back");
						String v1 = scanner.nextLine();
						if (Validation.isNumber1(v1)) {
							choiceForModification = Integer.parseInt(v1);
							modificationChoiceLoop = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (choiceForModification) {
					case 1:
						CustomerBean custBean1 = new CustomerBean();
						int customerIdForModification = 0;
						char customerIdLoop = 'y';
						while (customerIdLoop == 'y') {
							System.out.println("Enter the Cust Id: ");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								customerIdForModification = Integer.parseInt(v1);
								customerIdLoop = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						custBean1.setCustomerId(customerIdForModification);

						char customerNameModificationLoop = 'y';
						while (customerNameModificationLoop == 'y') {
							System.out.println("Enter the customer name");
							String customerName = scanner.nextLine();
							if (customerName.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							}
							if (Validation.isStringOnlyAlphabet(customerName)) {
								customerNameModificationLoop = 'n';
								custBean1.setCustomerName(customerName);
							} else {
								System.err.println("Enter only Alphabets!!!!");
							}
						}

						try {
							if (customerServices.modifyCustomerName(custBean1.getCustomerId(),
									custBean1.getCustomerName())) {
								System.out.println("Modified Successfully..");
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2:
						CustomerBean custBean2 = new CustomerBean();
						int customerIdForAddress1 = 0;
						char customerIdforStreetAddressLoop = 'y';
						while (customerIdforStreetAddressLoop == 'y') {
							System.out.println("Enter the Cust Id: ");
							System.out.println("=======================");
							String streetAddress1 = scanner.nextLine();
							if (Validation.isNumber1(streetAddress1)) {
								customerIdForAddress1 = Integer.parseInt(streetAddress1);
								customerIdforStreetAddressLoop = 'n';
							} else if (streetAddress1.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						custBean2.setCustomerId(customerIdForAddress1);

						System.out.println("Enter the Street Address 1");
						custBean2.setStreetAdd1(scanner.nextLine());
						if (custBean2.getStreetAdd1().equalsIgnoreCase("exit")) {
							CustomerMain.customerMain();
						}

						try {
							if (customerServices.modifyCustomerAdd(custBean2.getCustomerId(), custBean2.getStreetAdd1())) {
								System.out.println("Modified Successfully..");
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 3:
						CustomerBean custBean3 = new CustomerBean();
						int customerIdForAddress2 = 0;
						char customerAddressModificationLoop = 'y';
						while (customerAddressModificationLoop == 'y') {
							System.out.println("Enter the Customer Id: ");
							System.out.println("=========================");
							String address2 = scanner.nextLine();
							if (Validation.isNumber1(address2)) {
								customerIdForAddress2 = Integer.parseInt(address2);
								customerAddressModificationLoop = 'n';
							} else if (address2.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						custBean3.setCustomerId(customerIdForAddress2);

						char customeTownModificationLoop = 'y';
						while (customeTownModificationLoop == 'y') {
							System.out.println("Enter the Town ");
							String cadd2 = scanner.nextLine();
							if (cadd2.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							}
							if (Validation.isStringOnlyAlphabet(cadd2)) {
								customeTownModificationLoop = 'n';
								custBean3.setTown(cadd2);
							} else {
								System.err.println("Enter only Alphabets!!!!");
							}
						}

						try {
							if (customerServices.modifyCustomerTown(custBean3.getCustomerId(), custBean3.getTown())) {
								System.out.println("Modified Successfully..");
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 4:
						CustomerBean custBean4 = new CustomerBean();
						int customerIdForPostalCode = 0;
						char customerTownModifiactionLoop = 'y';
						while (customerTownModifiactionLoop == 'y') {
							System.out.println("Enter the Cust Id: ");
							System.out.println("======================");
							String customerIdForValidation = scanner.nextLine();
							if (Validation.isNumber1(customerIdForValidation)) {
								customerIdForPostalCode = Integer.parseInt(customerIdForValidation);
								customerTownModifiactionLoop = 'n';
							} else if (customerIdForValidation.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						custBean4.setCustomerId(customerIdForPostalCode);

						char postalCodeModificationLoop = 'y';
						while (postalCodeModificationLoop == 'y') {
							System.out.println("Enter the Postal Code: ");
							String postalCodeValidity = scanner.nextLine();
							if (Validation.isNumber1(postalCodeValidity) && postalCodeValidity.length() == 6) {
								int postalCode = Integer.parseInt(postalCodeValidity);
								custBean4.setPostalCode(postalCode);
								postalCodeModificationLoop = 'n';
							} else if (postalCodeValidity.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter valid postal code \n(6 digits):");
							}
						}

						try {
							if (customerServices.modifyCustomerPost(custBean4.getCustomerId(), custBean4.getPostalCode())) {
								System.out.println("Modified Successfully..");
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 5:
						CustomerBean custBean5 = new CustomerBean();
						int customerIdForEmailModification = 0;
						char emailModificationLoop = 'y';
						while (emailModificationLoop == 'y') {
							System.out.println("Enter the Cust Id: ");
							System.out.println("=====================");
							String v1 = scanner.nextLine();
							if (Validation.isNumber1(v1)) {
								customerIdForEmailModification = Integer.parseInt(v1);
								emailModificationLoop = 'n';
							} else if (v1.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						custBean5.setCustomerId(customerIdForEmailModification);

						char emailModificationLoop1 = 'y';
						while (emailModificationLoop1 == 'y') {
							System.out.println("Enter the Email : ");
							String emailValidation = scanner.nextLine();
							if (Validation.isValid(emailValidation)) {
								emailModificationLoop1 = 'n';
								custBean5.setEmail(emailValidation);
							} else if (emailValidation.equalsIgnoreCase("exit")) {
								CustomerMain.customerMain();
							} else {
								System.err.println("Enter Valid Email id Format!!!!");
							}
						}

						try {
							if (customerServices.modifyCustomerEmail(custBean5.getCustomerId(), custBean5.getEmail())) {
								System.out.println("Modified Successfully..");
							}
						} catch (CustomerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 6:
						return;

					default:
						System.err.println("Invalid Choice ");
						break;
					}
				}

				break;

			case 4:
				CustomerMain.showAllCustomer();
				break;

			case 5:
				CustomerMain.searchCustomer();
				break;
			case 6:
				custLoop = 'n';
				break;

			default:
				System.err.println("Invalid Choice:");
				break;
			}
		}

	}

	public static void showAllCustomer() {
		CustomerBean cust3 = new CustomerBean();
		System.out.println("The Details:");

		try {
			List<CustomerBean> customerList = customerServices.showAllCustomer(cust3);
			if (customerList != null) {

				for (CustomerBean customerBean : customerList) {
					System.out.println("Customer Id :" + customerBean.getCustomerId());
					System.out.println("Customer's Name	:" + customerBean.getCustomerName());
					System.out.println("Customer's Postal Code :" + customerBean.getPostalCode());
					System.out.println("Customer's Street Address 1:" + customerBean.getStreetAdd1());
					System.out.println("Customer's Street Address 2:" + customerBean.getStreetAdd2());
					System.out.println("Customer's Telephone :" + customerBean.getTelephone());
					System.out.println("Customer's Town :" + customerBean.getTown());
					System.out.println("Customer's Email :" + customerBean.getEmail());
					System.out.println("---------------------------------------------");

				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
		}

	}

	public static void searchCustomer() {
		CustomerBean cust4 = new CustomerBean();

		int customerIdForSearch = 0;
		char customerIdLoopForSearch = 'y';
		while (customerIdLoopForSearch == 'y') {
			System.out.println("Enter the Customer Id: ");
			String customerIdForValidation = scanner.nextLine();
			if (Validation.isNumber1(customerIdForValidation)) {
				customerIdForSearch = Integer.parseInt(customerIdForValidation);
				customerIdLoopForSearch = 'n';
			} else if (customerIdForValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}
		}
		cust4.setCustomerId(customerIdForSearch);

		try {
			List<CustomerBean> searchedCustomerList = new ArrayList<CustomerBean>();
			searchedCustomerList = customerServices.searchCustomer(cust4.getCustomerId());
			for (CustomerBean customerBean : searchedCustomerList) {

				if (searchedCustomerList != null) {
					System.out.println("Customer Id :" + customerBean.getCustomerId());
					System.out.println("Customer's Name	:" + customerBean.getCustomerName());
					System.out.println("Customer's Postal Code	:" + customerBean.getPostalCode());
					System.out.println("Customer's Street Address 1	:" + customerBean.getStreetAdd1());
					System.out.println("Customer's Street Address 2	:" + customerBean.getStreetAdd2());
					System.out.println("Customer's Telephone:" + customerBean.getTelephone());
					System.out.println("Customer's Town :" + customerBean.getTown());
					System.out.println("Customer's Email :" + customerBean.getEmail());
					System.out.println("---------------------------------------------");

				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
		}

	}

	public static boolean getCustForContract(int customerId) {
		List<CustomerBean> searchedCustomer = new ArrayList<CustomerBean>();
		searchedCustomer = customerServices.searchCustomer(customerId);
		if (searchedCustomer != null) {
			return true;
		}
		return false;
	}
	

}
