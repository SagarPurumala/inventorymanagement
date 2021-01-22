package com.capg.inventory.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capg.inventory.beans.ProductDto;
import com.capg.inventory.exception.ProductException;
import com.capg.inventory.response.MerchantResponse;
import com.capg.inventory.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
public class MerchantController {
	
	@Autowired
	private MerchantService service;
	
	@GetMapping("/getProduct")
	public MerchantResponse getProduct(Integer productId) {
		ProductDto productInformation = service.getProduct(productId);
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
	
	@DeleteMapping("/deleteProduct")

	public MerchantResponse deleteProduct(Integer productId) {
		boolean isDeleted = service.deleteProduct(productId);

		MerchantResponse response = new MerchantResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Congratulation! Product information deleted successfully.");
			response.setDescription("Congratulation! Product information deleted successfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to delete Product. Check whether you have entered correct Product number ");

		}
		return response;
	}
	@PutMapping(path = "/updateProduct")
	public boolean updateProduct(@RequestBody ProductDto productInformation) {
		return service.updateProduct(productInformation);
	}
//	@PostMapping("/addProduct")
//	public ResponseEntity<String> addProduct(@RequestParam("image") MultipartFile file,ProductDto product)
//			throws ProductException,IOException {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        product.setImage(fileName);
//         
//        User savedUser = repo.save(user);
//		try {
//			service.addProduct(productDto);
//
//			return new ResponseEntity<String>("Product added successfully!!", HttpStatus.OK);
//		} catch (Exception ex) {
//			//ex.printStackTrace();
//			throw new ProductException(ex.getMessage());
//		}
//	}
	
//	@PostMapping("/addProduct")
//	public ResponseEntity<String> addProduct(@RequestParam("image") MultipartFile file,String jsonString)
//			throws ProductException,IOException {
//		ProductDto productDto=new ObjectMapper().readValue(jsonString, ProductDto.class);
//		//productDto.setImage(file.getBytes());
//		productDto.setImage(file.getBytes());
//		
//		try {
//			service.addProduct(productDto);
//
//			return new ResponseEntity<String>("Product added successfully!!", HttpStatus.OK);
//		} catch (Exception ex) {
//			//ex.printStackTrace();
//			throw new ProductException(ex.getMessage());
//		}
//	}
//	@PostMapping("/addProduct")
//	public MerchantResponse addProduct(ProductDto productInformation,@RequestParam("image") MultipartFile file) throws IOException {
//		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	        productInformation.setImage(fileName);
//		boolean isAdded = service.addProduct(productInformation);
//
//		MerchantResponse response = new MerchantResponse();
//		if (isAdded) {
//			response.setStatusCode(201);
//			response.setMessage("success");
//			response.setDescription("Product added sucessfully.");
//		} else {
//			response.setStatusCode(401);
//			response.setMessage("Failed");
//			response.setDescription("Unable to add product. ProductId Already Exists. ");
//
//		}
//		return response;
//
//	}
	@PostMapping("/addProduct")
	public MerchantResponse addProduct(@RequestBody ProductDto productInformation) {
		//productInformation.setImage(file.getBytes());
		boolean isAdded = service.addProduct(productInformation);

		MerchantResponse response = new MerchantResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product added sucessfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add product. ProductId Already Exists. ");

		}
		return response;

	}
	
	@GetMapping("/getAllProducts")
	public MerchantResponse getAllProduct() {

		List<ProductDto> productList = service.viewProducts();

		MerchantResponse response = new MerchantResponse();
		if (productList != null && !productList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All Products Found ");
			response.setSearchProduct(productList);
		
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to find any product.");

		}
		return response;

	}


}

