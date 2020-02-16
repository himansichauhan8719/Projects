package com.capgemini.forestrymanagementcollection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;
import com.capgemini.forestrymanagementcollection.exception.ClientExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.ClientServices;

public class ClientSection {

	private static ClientServices clientServices = Factory.getClientServices();
	static Scanner scanner = new Scanner(System.in);

	public static void clientSection() {

		char clientSectionLoop = 'a';
		while (clientSectionLoop == 'a') {

			int clientSwitchChoice = 0;
			char clientSwitchLoop = 'y';
			while (clientSwitchLoop == 'y') {
				System.out.println("Enter 1 : Add Client \nEnter 2 : Delete Client \nEnter 3 : Search Client \n"
						+ "Enter 4 : Get All Client\nEnter 5 : Modify Client\nEnter 6 : Back\nEnter 7 : Home");
				String clientSwitch = scanner.nextLine();
				if (Validation.isNumber1(clientSwitch)) {
					clientSwitchChoice = Integer.parseInt(clientSwitch);
					clientSwitchLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (clientSwitchChoice) {
			case 1:
				ClientBean clientBean1 = new ClientBean();

				int clientId = 0;
				char clientIdLoop = 'y';
				while (clientIdLoop == 'y') {
					System.out.println("Enter The Client id");

					String isNumber = scanner.nextLine();
					if (Validation.isNumber1(isNumber)) {
						clientId = Integer.parseInt(isNumber);
						clientIdLoop = 'n';
					} else if (isNumber.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				clientBean1.setClientId(clientId);

				char clientNameLoop = 'y';
				while (clientNameLoop == 'y') {
					System.out.println("Enter The Client Name :");
					String isOnlyString = scanner.nextLine();
					if (isOnlyString.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					}
					if (Validation.isStringOnlyAlphabet(isOnlyString)) {
						clientNameLoop = 'n';
						clientBean1.setClientName(isOnlyString);
					} else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char clientPasswordLoop = 'y';
				while (clientPasswordLoop == 'y') {
					System.out.println("Enter the Password:");
					String passwordStrength = scanner.nextLine();
					int strength = Validation.calculatePasswordStrength(passwordStrength);
					System.out.println("Your Password Strength is :" + strength);
					if (strength == 10) {
						clientPasswordLoop = 'n';
						clientBean1.setClientPassword(passwordStrength);
					} else if (passwordStrength.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println(
								"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
										+ "Atleast 1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				try {
					if (clientServices.addClient(clientBean1)) {
						System.out.println("Added Successfully");
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				ClientBean clientBean01 = new ClientBean();

				int deleteClientId = 0;
				char clientIdLoop01 = 'y';
				while (clientIdLoop01 == 'y') {
					System.out.println("Enter The Client Id :");
					System.out.println("========================");
					String isNumber = scanner.nextLine();
					if (Validation.isNumber1(isNumber)) {
						deleteClientId = Integer.parseInt(isNumber);
						clientIdLoop01 = 'n';
					} else if (isNumber.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				clientBean01.setClientId(deleteClientId);

				try {
					if (clientServices.deleteClient(clientBean01.getClientId())) {
						System.out.println("Deleted Successfully");

					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				ClientBean clientBean02 = new ClientBean();

				int searchClientId = 0;
				char searchClientIdLoop = 'y';
				while (searchClientIdLoop == 'y') {
					System.out.println("Enter The Client Id to Search");
					System.out.println("=================================");
					String isNumber = scanner.nextLine();
					if (Validation.isNumber1(isNumber)) {
						searchClientId = Integer.parseInt(isNumber);
						searchClientIdLoop = 'n';
					} else if (isNumber.equalsIgnoreCase("exit")) {
						ClientSection.clientSection();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				clientBean02.setClientId(searchClientId);

				List<ClientBean> list = new ArrayList<ClientBean>();
				try {
					list = clientServices.searchClient(clientBean02.getClientId());
					for (ClientBean clientBean : list) {

						if (list != null) {
							System.out.println("Client Id	:" + clientBean.getClientId());
							System.out.println("Client Name :" + clientBean.getClientName());
							System.out.println("----------------------");

						}
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 4:
				List<ClientBean> list1 = new ArrayList<ClientBean>();

				try {
					list1 = clientServices.getAllClient();
					for (ClientBean clientBean : list1) {
						if (list1 != null) {
							System.out.println("Client Id :" + clientBean.getClientId());
							System.out.println("Client Name :" + clientBean.getClientName());
							System.out.println("----------------------");

						}

					}
					if (list1.isEmpty()) {

						System.err.println("No Clients Presents");
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Enter clientid for Modification:");
				System.out.println("====================================");
				int clientUpdateLoop = 1;
				while (clientUpdateLoop == 1) {

					int updateClientChoice = 0;
					char updateNameLoop = 'y';
					while (updateNameLoop == 'y') {
						System.out.println("Enter 1 : Client Name\nEnter 2 : Client Password\nEnter 3 : Back");
						String clientId1 = scanner.nextLine();
						if (Validation.isNumber1(clientId1)) {
//							int clientIdChoice = Integer.parseInt(clientId1);
							updateNameLoop = 'n';
						} else {
							System.out.println("Enter only integers:");
						}
					}

					switch (updateClientChoice) {
					case 1:

						ClientBean clientBean00 = new ClientBean();
						char clientNameUpdateLoop = 'y';
						while (clientNameUpdateLoop == 'y') {
							System.out.println("Enter The Name To Modify");
							System.out.println("=========================");
							String clientName = scanner.nextLine();
							if (clientName.equalsIgnoreCase("exit")) {
								ClientSection.clientSection();
							}
							if (Validation.isStringOnlyAlphabet(clientName)) {
								clientNameUpdateLoop = 'n';
								clientBean00.setClientName(clientName);
							} else {
								System.err.println("Enter only Alphabets!!!!");
							}
						}

						int updateClientId = 0;
						char updateClientIdLoop = 'y';
						while (updateClientIdLoop == 'y') {
							System.out.println("Enter The Client Id :");
							String isNumber = scanner.nextLine();
							if (Validation.isNumber1(isNumber)) {
								updateClientId = Integer.parseInt(isNumber);
								clientIdLoop01 = 'n';
							} else if (isNumber.equalsIgnoreCase("exit")) {
								ClientSection.clientSection();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						clientBean00.setClientId(updateClientId);
						try {
							if (clientServices.updateClientName(clientBean00.getClientId(), clientBean00.getClientName())) {
								System.out.println("Clint name Updated Successfully ");
							}
						} catch (ClientExceptions e) {
							System.err.println(e.getMessage());
						}

						break;

					case 2:
						ClientBean clientBean001 = new ClientBean();

						int clientId1 = 0;
						char clientIdLoop1 = 'y';
						while (clientIdLoop1 == 'y') {
							System.out.println("Enter The Client Id :");
							
							String isNumber = scanner.nextLine();
							if (Validation.isNumber1(isNumber)) {
								clientId1 = Integer.parseInt(isNumber);
								clientIdLoop1 = 'n';
							} else if (isNumber.equalsIgnoreCase("exit")) {
								ClientSection.clientSection();
							} else {
								System.err.println("Enter only integers:");
							}
						}
						clientBean001.setClientId(clientId1);

						char updateClientPasswordLoop = 'y';
						while (updateClientPasswordLoop == 'y') {
							System.out.println("Enter the Password:");
							String passwordStrengthOfClient = scanner.nextLine();
							int strength = Validation.calculatePasswordStrength(passwordStrengthOfClient);
							System.out.println("Your Password Strength is :" + strength);
							if (strength == 10) {
								updateClientPasswordLoop = 'n';
								clientBean001.setClientPassword(passwordStrengthOfClient);
							} else {
								System.err.println(
										"The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
												+ "Atleast 1 Upper case,1 lower cases, 1 special charecter and integers :)");
							}
						}

						try {
							if (clientServices.updateClientPass(clientBean001.getClientId(), clientBean001.getClientPassword())) {
								System.out.println("Clint Password Updated Successfully ");
							}
						} catch (ClientExceptions e) {
							System.err.println(e.getMessage());
						}

						break;
					}
				}

				break;

			case 6:
				clientSectionLoop = 'n';
				return;

			case 7:
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}

	
	public static void loginClient() {

		char loginClientLoop = 'y';
		while (loginClientLoop == 'y') {

			Scanner scanner = new Scanner(System.in);
			ClientBean clientBean = new ClientBean();

			int clientIdForLogin = 0;
			char clientLoginIdLoop = 'y';
			while (clientLoginIdLoop == 'y') {
				System.out.println("Enter The Client Id :");
				String isNumber = scanner.nextLine();
				if (Validation.isNumber1(isNumber)) {
					clientIdForLogin = Integer.parseInt(isNumber);
					clientLoginIdLoop = 'n';
				} else if (isNumber.equalsIgnoreCase("exit")) {
					ClientSection.clientSection();
				} else {
					System.err.println("Enter only integers:");
				}
			}
			clientBean.setClientId(clientIdForLogin);

			System.out.println("Enter The Client PassWord");
			clientBean.setClientPassword(scanner.nextLine());
			try {
				if (clientServices.loginClient(clientIdForLogin, clientBean.getClientPassword())) {
					System.out.println("Client Login Successfully :)");

					int clientLoginSwitch = 0;
					char clientLoggedInLoop = 'y';
					while (clientLoggedInLoop == 'y') {
						System.out.println(
								"Enter 1 : Contracts \nEnter 2 :  Customers \nEnter 3 : Products \nEnter 4 : Back \nEnter 5 : Logout ");
						String isNumber = scanner.nextLine();
						if (Validation.isNumber1(isNumber)) {
							clientLoginSwitch = Integer.parseInt(isNumber);
							clientLoggedInLoop = 'n';
						} else {
							System.err.println("Enter only integers:");
						}
					}
					switch (clientLoginSwitch) {
					case 1:
						ContractMain.contractMain();

						break;

					case 2:
						CustomerMain.customerMain();
						break;

					case 3:
						ProductMain.productMain();
						break;

					case 4:
						return;

					case 5:
						MainHome.mainHome();

					default:
						System.err.println("Invalid Choice :(");
						break;
					}
				}
			} catch (ClientExceptions e) {
				System.err.println(e.getMessage());
			}
		}
		scanner.close();
	}
}
