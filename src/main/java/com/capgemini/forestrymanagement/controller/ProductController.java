package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.exception.ProductExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ProductServices;

public class ProductController {

	private static Scanner scanner = new Scanner(System.in);
	private static Product product = Factory.getProduct();
	private static ProductServices productService = Factory.getProductServImpl();

	public static void productController() {
		char productConreollerLoop = 'y';
		while (productConreollerLoop == 'y') {
			char controllerChoiceLoop = 'y';
			int controllerChoice = 0;
			while (controllerChoiceLoop == 'y') {
				System.out.println(
						"Enter 1 : Add Product\nEnter 2 : Delete Product\nEnter 3 : Modify Product\nEnter 4 : Get Product\nEnter 5 : Get All Products\nEnter 6 : Back");
				String choiceValidation = scanner.nextLine();
				if (Validation.isNumber1(choiceValidation)) {
					controllerChoice = Integer.parseInt(choiceValidation);
					controllerChoiceLoop = 'n';
				} else {
					System.err.println("Enter only integers:");
				}
			}

			switch (controllerChoice) {
			case 1:
				char productNameLoopForAdding = 'y';
				while (productNameLoopForAdding == 'y') {
					System.out.println("Enter the product name");
					String productName = scanner.nextLine();
					if (Validation.isStringOnlyAlphabet(productName)) {
						productNameLoopForAdding = 'n';
						product.setProductName(productName);
					} else if (productName.equalsIgnoreCase("exit")) {
						ProductController.productController();
					} else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				char productIdLoopForAdd = 'y';
				int productIdForAdd = 0;
				while (productIdLoopForAdd == 'y') {
					System.out.println("Enter The Prod Id: ");
					String productIdValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdValidation)) {
						productIdForAdd = Integer.parseInt(productIdValidation);
						productIdLoopForAdd = 'n';
					} else if (productIdValidation.equalsIgnoreCase("exit")) {
						ProductController.productController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				product.setProductId(productIdForAdd);

				try {
					if (productService.addProduct(product)) {
						System.out.println("Product Added :)");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 2:
				char productIdLoopForDelete = 'y';
				int productIdForDelete = 0;
				while (productIdLoopForDelete == 'y') {
					System.out.println("Enter Product id to delete: ");
					String productIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdForValidation)) {
						productIdForDelete = Integer.parseInt(productIdForValidation);
						productIdLoopForDelete = 'n';
					} else if (productIdForValidation.equalsIgnoreCase("exit")) {
						ProductController.productController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				product.setProductId(productIdForDelete);

				try {
					if (productService.deleteProduct(product.getProductId())) {
						System.out.println("Product Successfully deleted");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 3:
				char ProductIdLoopForUpdate = 'y';
				int productIdForUpdate = 0;
				while (ProductIdLoopForUpdate == 'y') {
					System.out.println("Enter Product id to Update Products: ");
					String productIdForValidation = scanner.nextLine();
					if (Validation.isNumber1(productIdForValidation)) {
						productIdForUpdate = Integer.parseInt(productIdForValidation);
						ProductIdLoopForUpdate = 'n';
					} else if (productIdForValidation.equalsIgnoreCase("exit")) {
						ProductController.productController();
					} else {
						System.err.println("Enter only integers:");
					}
				}
				product.setProductId(productIdForUpdate);

				char productNameLoopForUpdate = 'y';
				while (productNameLoopForUpdate == 'y') {
					System.out.println("Enter The Product Name to be Update: ");
					String productNameForValidation = scanner.nextLine();
					if (productNameForValidation.equalsIgnoreCase("exit")) {
						ProductController.productController();
					}
					if (Validation.isStringOnlyAlphabet(productNameForValidation)) {
						productNameLoopForUpdate = 'n';
						product.setProductName(productNameForValidation);
					} else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				try {
					if (productService.modifyProduct(product.getProductId(), product.getProductName())) {
						System.out.println("Successfully updated");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}
			case 4:
				
				break;

			case 5:
				ProductController.getAllProduct();
				break;

			case 6:
				return;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}
	
	public static void getAllProduct() {
		ArrayList<Product> allProductList = productService.getAllProduct();
		try {
			for (Product product02 : allProductList) {
				if (allProductList != null) {
					System.out.println("User Name :" + product02.getProductName());
					System.out.println("User Id :" + product02.getProductId());
					System.out.println("-------------------------");
				}
			}
		} catch (ProductExceptions e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void searchProduct() {
		char productIdLoopForSearch = 'y';
		int productIdForSearch = 0;
		while (productIdLoopForSearch == 'y') {
			System.out.println("Enter The Prod Id to Get details:");
			String productIdForValidation = scanner.nextLine();
			if (Validation.isNumber1(productIdForValidation)) {
				productIdForSearch = Integer.parseInt(productIdForValidation);
				productIdLoopForSearch = 'n';
			} else if (productIdForValidation.equalsIgnoreCase("exit")) {
				ProductController.productController();
			} else {
				System.err.println("Enter only integers:");
			}
		}
		product.setProductId(productIdForSearch);

		try {
			Product searchedProductList = productService.getProduct(product.getProductId());
				if (searchedProductList != null) {
					System.out.println("User Name :" + searchedProductList.getProductName());
					System.out.println("User Id :" + searchedProductList.getProductId());
			}
		} catch (ProductExceptions e1) {
			System.err.println(e1.getMessage());
		}
	}

}