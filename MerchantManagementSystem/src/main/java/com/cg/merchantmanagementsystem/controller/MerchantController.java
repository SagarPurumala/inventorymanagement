package com.cg.merchantmanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.merchantmanagementsystem.dto.MerchantDTO;
import com.cg.merchantmanagementsystem.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;


/*Rest Controller for mapping user end point requests to corresponding methods
for running business logic and fetching data as per the user request.*/

@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class MerchantController {
	
	//Dependeny Injection of service layer
	@Autowired
	MerchantService merchantService;

	//For logging events happening in the application.
	Logger logger = LoggerFactory.getLogger(MerchantController.class);


	//Post method to add merchant in the database along with the image
	@PostMapping(path = "/addMerchant")
	public ResponseEntity<MerchantDTO> addMerchant(@RequestParam("image") MultipartFile file,String jsonString) throws IOException {
		MerchantDTO merchantDto=new ObjectMapper().readValue(jsonString, MerchantDTO.class);
		merchantDto.setImage(file.getBytes());
		MerchantDTO merchant = merchantService.addMerchant(merchantDto);
		logger.info("Merchant Added Successfully");
		return new ResponseEntity<>(merchant, HttpStatus.OK);
	}

	//put mapping to update merchant in the database.
	@PutMapping(path = "/updateMerchant")
	public ResponseEntity<MerchantDTO> updateMerchant(@RequestParam("image") MultipartFile file,String jsonString) throws IOException {
		MerchantDTO merchantDto=new ObjectMapper().readValue(jsonString, MerchantDTO.class);
		merchantDto.setImage(file.getBytes());
		MerchantDTO merchant = merchantService.updateMerchant(merchantDto);
		logger.info("Merchant Updated Successfully");
		return new ResponseEntity<>(merchant, HttpStatus.OK);
	}
	
	//get mapping for fetching all the merchants in the database
	@GetMapping(path = "/merchantList")
	public ResponseEntity<List<MerchantDTO>> getAllMerchants() {
		List<MerchantDTO> merchantsList = merchantService.viewMerchants();
		logger.info("Merchants fetched Successfully");
		return new ResponseEntity<>(merchantsList, HttpStatus.OK);
	}

	//get request to disable merchants account in the database.
	@GetMapping(path = "/disableMerchant/{merchantId}")
	public ResponseEntity<Boolean> disableMerchant(@PathVariable Integer merchantId) {
		boolean disableStatus=merchantService.disableAccount(merchantId);
		logger.info("Merchant disabled Successfully");
		return new ResponseEntity<>(disableStatus, HttpStatus.OK);
	}

	//get request to get a merchant based on the merchant Id
	@GetMapping(path = "/getMerchant/{merchantId}")
	public ResponseEntity<MerchantDTO> getMerchant(@PathVariable Integer merchantId) {
		MerchantDTO merchant = merchantService.getMerchant(merchantId);
		logger.info("Merchant fetched Successfully with id: "+merchantId);
		return new ResponseEntity<>(merchant, HttpStatus.OK);
	}
	
	//get request to check whether a merchant exists or not by merchant Id.
	@GetMapping(path="/merchantExist/{merchantId}")
	public ResponseEntity<Boolean> merchantExists(@PathVariable Integer merchantId) {
		boolean value=merchantService.checkMerchant(merchantId);
		logger.info("Merchant fetched Successfully with id: "+ merchantId);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}
	
	//get request to block a merchant by merchant Id
	@GetMapping(path = "/blockMerchant/{merchantId}")
	public ResponseEntity<Boolean> blockMerchant(@PathVariable Integer merchantId) {
		boolean blockedStatus=merchantService.blockAccount(merchantId);
		logger.info("Merchant blocked Successfully");
		return new ResponseEntity<>(blockedStatus, HttpStatus.OK);
	}
	
	
	//Get request to unblock a merchant 
	@GetMapping(path = "/unblockMerchant/{merchantId}")
	public ResponseEntity<Boolean> unblockMerchant(@PathVariable Integer merchantId) {
		boolean unblockedStatus=merchantService.unblockAccount(merchantId);
		logger.info("Merchant unblocked Successfully");
		return new ResponseEntity<>(unblockedStatus, HttpStatus.OK);
	}
	
	//Get request to unblock a merchant 
	@GetMapping(path = "/deleteMerchant/{merchantId}")
	public ResponseEntity<Boolean> deleteMerchant(@PathVariable Integer merchantId) {
		boolean deleteStatus=merchantService.deleteAccount(merchantId);
		logger.info("Merchant deleted Successfully");
		return new ResponseEntity<>(deleteStatus, HttpStatus.OK);
	}
	
	//Get request to show image of any merchant
	@GetMapping(path = "/showImage/{merchantId}")
	public ResponseEntity<byte[]> showImage(@PathVariable Integer merchantId) {
		MerchantDTO merchant=merchantService.getMerchant(merchantId);
		byte[] image=merchant.getImage();
		return ResponseEntity.status( HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(image);
	}

}
