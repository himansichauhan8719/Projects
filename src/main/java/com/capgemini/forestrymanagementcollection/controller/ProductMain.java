package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ProductBean;
import com.capgemini.forestrymanagementcollection.exception.ProductExceptions;
import com.capgemini.forestrymanagementcollection.factory.Factory;
import com.capgemini.forestrymanagementcollection.factory.Validation;
import com.capgemini.forestrymanagementcollection.services.ProductServices;

public class ProductMain {
	public static ProductServices productServices = Factory.getProductService();
	static Scanner scanner = new Scanner(System.in);

	public static void productMain() {
		char productMainLoop = 'y';
		while (productMainLoop == 'y') {

			int productChoice = 0;
			char productChoiceLoop = 'y';
			while (productChoiceLoop == 'y') {
				System.out.println("----------------------------");
				System.out.println("----------PRODUCTS----------");
				System.out.println("-----------------------------");
				System.out.println(
						"Enter 1 : Add Products \nEnter 2 : Delete Product \nEnter 3 : Modify Products \nEnter 4 : Get Products \nEnter 5 : Back");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					productChoice = Integer.parseInt(choiceValidation);
					productChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}
			switch (productChoice) {
			case 1:
				ProductBean productBean = new ProductBean();
	//			System.out.println("----ADD PRODUCTS----");
				char enterProductIdLoop = 'y';
				while (enterProductIdLoop == 'y') {
					System.out.println("Enter the Prod Id");
					String idValidation = scanner.nextLine();
					if (Validation.isNumber1(idValidation)) {
						int productId = Integer.parseInt(idValidation);
						productBean.setProductId(productId);
						enterProductIdLoop = 'n';
					} else if (idValidation.equalsIgnoreCase("exit")) {
						ProductMain.productMain();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				
				char productNameLoop = 'y';
				while (productNameLoop == 'y') {
					System.out.println("Enter the Product Name : ");
					String productNameValidation = scanner.nextLine();
					if (productNameValidation.equalsIgnoreCase("exit")) {
						ProductMain.productMain();
					}
					if (Validation.isStringOnlyAlphabet(productNameValidation)) {
						productNameLoop = 'n';
						productBean.setProductName(productNameValidation);
					} else {
						System.err.println("Enter currect Format!!!!");
					}
				}

				try {
					if (productServices.addProduct(productBean)) {
						System.out.println("Added Successfully..");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				ProductBean productBean02 = new ProductBean();

				char productIdForDeleteLoop = 'y';
				while (productIdForDeleteLoop == 'y') {
					System.out.println("Enter the Product Id");
					System.out.println("======================");
					String productIdValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdValidation)) {
						int v22 = Integer.parseInt(productIdValidation);
						productBean02.setProductId(v22);
						productIdForDeleteLoop = 'n';
					} else if (productIdValidation.equalsIgnoreCase("exit")) {
						ProductMain.productMain();
					} else {
						System.err.println("Enter only integers:");
					}

				}

				try {
					if (productServices.deleteProduct(productBean02.getProductId())) {
						System.out.println("Deleted...");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				ProductBean productBean03 = new ProductBean();

				char productIdForModificationLoop = 'y';
				while (productIdForModificationLoop == 'y') {
					System.out.println("Enter the Prod Id to Modify");
					System.out.println("=============================");
					String productIdForModification = scanner.nextLine();
					if (Validation.isNumber1(productIdForModification)) {
						int productId = Integer.parseInt(productIdForModification);
						productBean03.setProductId(productId);
						productIdForModificationLoop = 'n';
					} else if (productIdForModification.equalsIgnoreCase("exit")) {
						ProductMain.productMain();
					} else {
						System.err.println("Enter only integers :");
					}

				}

				char prodNameLoop = 'y';
				while (prodNameLoop == 'y') {
					System.out.println("Enter the Product Name : ");
					String productName = scanner.nextLine();
					if (productName.equalsIgnoreCase("exit")) {
						ProductMain.productMain();
					}
					if (Validation.isStringOnlyAlphabet(productName)) {
						prodNameLoop = 'n';
						productBean03.setProductName(productName);
					} else {
						System.err.println("Enter Only Alphabates!!!!");
					}
				}

				try {
					if (productServices.modifyProduct(productBean03.getProductId(), productBean03.getProductName())) {
						System.out.println("Modify Successfully.. :)");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				ProductMain.getProducts();
				break;

			case 5:
				productMainLoop = 'n';
				break;

			default:
				System.err.println("Invalid Choice :( ");
				break;
			}
		}
	}

	public static void getProducts() {
		ProductBean productBean = new ProductBean();
		char productIdLoopForSearch = 'y';
		while (productIdLoopForSearch == 'y') {
			System.out.println("Enter the Prod Id");
			System.out.println("=====================");
			String productIdValidation = scanner.nextLine();
			if (Validation.isNumber1(productIdValidation)) {
				int productId = Integer.parseInt(productIdValidation);
				productBean.setProductId(productId);
				productIdLoopForSearch = 'n';
			} else if (productIdValidation.equalsIgnoreCase("exit")) {
				return;
			} else {
				System.err.println("Enter only integers:");
			}

		}

		try {
			ProductBean products = productServices.getProduct(productBean.getProductId());
			if (products != null) {
				System.out.println("---The Details are--");
				System.out.println("Prod id	 : " + products.getProductId());
				System.out.println("Prod Name: " + products.getProductName());

			}

		} catch (ProductExceptions e) {
			System.err.println(e.getMessage());
		}
	}

	public static boolean getProdForContract(int productId) {
		ProductBean product = productServices.getProduct(productId);
		if (product != null) {
			return true;
		}
		throw new ProductExceptions("Product is not present");
	}
}
