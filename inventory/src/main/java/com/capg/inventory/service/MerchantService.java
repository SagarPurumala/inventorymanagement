package com.capg.inventory.service;

import java.util.List;

import com.capg.inventory.beans.ProductDto;

public interface MerchantService {
	  public ProductDto getProduct(Integer productId);

		public boolean addProduct(ProductDto productInformation);

		public boolean updateProduct(ProductDto productInformation);

		public boolean deleteProduct(Integer productId);
		
		public List<ProductDto> viewProducts();
}
