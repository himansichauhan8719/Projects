package com.capgemini.forestrymanagementjdbc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.bean.ProductBean;
import com.capgemini.forestrymanagementjdbc.exception.ClientExceptions;
import com.capgemini.forestrymanagementjdbc.exception.ProductExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;
import com.capgemini.forestrymanagementjdbc.services.ClientSevices;
import com.capgemini.forestrymanagementjdbc.services.ProductServices;

public class ClientController {
	private static Scanner scanner = new Scanner(System.in);
	public static void mainClientController() {
		ClientBean clientBean = Factory1.getClBean();
		ClientSevices clientServices = Factory1.getClServ();
		ProductBean productBean = Factory.getProdBean();
		ProductServices productServices = Factory.getProdServ();

		System.out.println("-----Login client -----");
		char clientIdForLoginLoop = 'y';
		while (clientIdForLoginLoop == 'y') {
			System.out.println("Enter the Client id: ");
			String clientIdValidation = scanner.nextLine();
			if (Validation.isNumber(clientIdValidation)) {
				int clientId = Integer.parseInt(clientIdValidation);
				clientBean.setClientId(clientId);
				clientIdForLoginLoop = 'n';
			} else if (clientIdValidation.equalsIgnoreCase("exit")) {
				ClientController.mainClientController();
			} else {
				System.out.println("Enter only integers:");
			}
		}

		System.out.println("Enter The Password");
		clientBean.setPassword(scanner.nextLine());
		if (clientBean.getPassword().equalsIgnoreCase("exit")) {
			ClientController.mainClientController();
		}

		try {

			if (clientServices.loginClient(clientBean.getClientId(), clientBean.getPassword())) {
				System.out.println("Login Successfully\n");

				char loggedInClientChoiceLoop = 'x';
				while (loggedInClientChoiceLoop == 'x') {
					System.out.println("----Welcome you Client----");
					System.out.println("Enter 1 : Contractor\nEnter 2 : Products\nEnter 3 : Customer\nEnter 4 : Logout");
					int clientControllerChoice = scanner.nextInt();
					switch (clientControllerChoice) {

					case 1:
						ContractorController.contractorContr();
						break;

					case 2:
						char clientProductsChoiceLoop = 'y';
						while (clientProductsChoiceLoop == 'y') {
							System.out.println("------Products-----");
							System.out.println(
									"Enter 1 : Get All Products\nEnter 2 : Search Products\nEnter 3 : Back\nEnter 4 : Home");
							int productChoices = scanner.nextInt();
							switch (productChoices) {
							case 1:
								try {
									ArrayList<ProductBean> allProductList = productServices.getAllProduct();
									for (ProductBean productBean01 : allProductList) {
										if (allProductList != null) {
											System.out.println("User Name :" + productBean01.getProductName());
											System.out.println("User Id :" + productBean01.getProductId());
											System.out.println("-------------------------");
										}
									}
								} catch (ProductExceptions e) {
									System.err.println(e.getMessage());
								}
								break;

							case 2:
								char productIdForSearch = 'y';
								while (productIdForSearch == 'y') {
									System.out.println("Enter the Product id: ");
									String productIdValidation = scanner.nextLine();
									if (Validation.isNumber(productIdValidation)) {
										int productId = Integer.parseInt(productIdValidation);
										productBean.setProductId(productId);
										productIdForSearch = 'n';
									} else if (productIdValidation.equalsIgnoreCase("exit")) {
										ClientController.mainClientController();
									} else {
										System.out.println("Enter only integers:");
									}
								}

								try {
									ArrayList<ProductBean> productList = productServices.getProduct(productBean.getProductId());
									for (ProductBean productBean02 : productList) {
										if (productList != null) {
											System.out.println("User Name :" + productBean02.getProductName());
											System.out.println("User Id :" + productBean02.getProductId());
										}
									}
								} catch (ProductExceptions e) {
									System.err.println(e.getMessage());
								}
								break;

							case 3:
								CustomerController.custControl();
								break;

							case 4:
								clientProductsChoiceLoop = 'n';
								break;

							case 5:
								HomeForestry.mainHomeForestry();
							default:
								System.err.println("Invalid choice :");
								break;
							}
						}
						break;

					case 3:
						CustomerController.custControl();
						break;

					case 4:
						HomeForestry.mainHomeForestry();
						break;

					default:
						System.err.println("Invalid Choice");
						break;
					}
				}
			}

		} catch (ClientExceptions e) {
			System.err.println(e.getMessage());
			ClientController.mainClientController();
		}
	}

}
