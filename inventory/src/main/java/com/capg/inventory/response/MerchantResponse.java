package com.capg.inventory.response;

import java.util.List;

import com.capg.inventory.beans.ProductDto;

import lombok.Data;
@Data
public class MerchantResponse {
 
	private int statusCode;
	private String message;
	private String description;
	private String productId;
	private double totalFare;
	private ProductDto producttInformation;
	
	private List<ProductDto> searchProduct;
}
