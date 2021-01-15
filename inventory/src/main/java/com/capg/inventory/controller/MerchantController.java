package com.capg.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.inventory.beans.Product;
import com.capg.inventory.response.MerchantResponse;
import com.capg.inventory.service.MerchantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class MerchantController {
	@Autowired
	private MerchantService service;
	
	@GetMapping("/getProduct")
	public MerchantResponse getProduct(String productId) {
		Product productInformation = service.getProduct(productId);
		MerchantResponse response = new MerchantResponse();
		if (productInformation != null) {
			response.setStatusCode(210);
			response.setMessage("Success! Product information retrived successfully.");
			response.setDescription("Product information found successfully for the ProductID. : " + productId);
			response.setProducttInformation(productInformation);
		} else {

			response.setStatusCode(401);
			response.setMessage("Oops! Unable to retrived product information.");
			response.setDescription(" Product information not found for the ProductId : " +productId);

		}
		return response;
	}

}

