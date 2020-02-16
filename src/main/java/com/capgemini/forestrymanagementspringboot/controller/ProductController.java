package com.capgemini.forestrymanagementspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementspringboot.dto.Product;
import com.capgemini.forestrymanagementspringboot.dto.ProductResponse;
import com.capgemini.forestrymanagementspringboot.service.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@PostMapping(path = "/add-products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody Product product) {
		ProductResponse productResponse = new ProductResponse();
		if (productServices.addProduct(product)) {
			productResponse.setStatusCode(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Products Added");
			
		} 
		return productResponse;
	}
	
	@DeleteMapping(path = "/delete-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse deleteProduct(@PathVariable("id") int productId) {
		ProductResponse productResponse = new ProductResponse();
		if (productServices.deleteProduct(productId)) {
			productResponse.setStatusCode(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Products Deleted");
		}
		return productResponse;
	}
	
	@PutMapping(path = "/modify-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse modifyProduct(@RequestBody Product product) {
		ProductResponse productResponse = new ProductResponse();
		if (productServices.modifyProduct(product.getProductId(), product.getProductName())) {
			productResponse.setStatusCode(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Product Name Is Modified");
		}
		return productResponse;
	}
	
	@GetMapping(path = "/get-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchProduct(@PathVariable("productId") int productId) {
		ProductResponse productResponse = new ProductResponse();
		Product product = productServices.getProduct(productId);
		if (product != null) {
			productResponse.setStatusCode(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Product Found Successfully");
			productResponse.setProductResponse(Arrays.asList(product));
		}
		return productResponse;
	}
	
	@GetMapping(path = "/get-all-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchAllProduct() {
		ProductResponse productResponse = new ProductResponse();
		List<Product> list = productServices.getAllProduct();
		if (list.size()!=0) {
			productResponse.setStatusCode(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Scheduler Details found Successfully");
			productResponse.setProductResponse(list);
		}
		return productResponse;
	}
	

	
}
