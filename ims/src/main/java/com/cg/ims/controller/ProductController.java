package com.cg.ims.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.ims.dto.ProductDto;
import com.cg.ims.entity.Product;
import com.cg.ims.exception.ProductException;
import com.cg.ims.service.MerchantService;
import com.cg.ims.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MerchantService merchantService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> saveProduct(@RequestParam("image") MultipartFile file,String jsonString)
			throws ProductException, IOException {
		ProductDto productDto=new ObjectMapper().readValue(jsonString, ProductDto.class);
		productDto.setImage(file.getBytes());
		
		try {
			productService.saveProduct(productDto);

			return new ResponseEntity<String>("Product added successfully!!", HttpStatus.OK);
		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteproduct(@PathVariable int productId) throws ProductException {
		try {
			productService.deleteproduct(productId);
			return new ResponseEntity<String>("Product Deleted", HttpStatus.OK);
		} catch (Exception ex) {
			throw new ProductException("Id is not exists");
		}
	}
	
	@GetMapping("/viewProducts")
	public ResponseEntity<List<Product>> getAllProduct() {
		return ResponseEntity.ok().body(productService.showallproduct());
	}
	
//	@PutMapping("/updateproduct")
//	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto) {
//		productService.updateProduct(productDto);
//		return new ResponseEntity<String>("Product Updated", HttpStatus.OK);
//	}
	
	@GetMapping("/getProduct/{productId}")
	public Product getProduct(@PathVariable int productId){
		return merchantService.getProduct(productId);
	}

}
