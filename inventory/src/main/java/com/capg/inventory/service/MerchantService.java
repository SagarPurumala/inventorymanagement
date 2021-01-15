package com.capg.inventory.service;

import java.util.List;

import com.capg.inventory.beans.Product;

public interface MerchantService {
	  public Product getProduct(String productId);

		public boolean addProduct(Product productInformation);

		public boolean updateProduct(Product productInformation);

		public boolean deleteProduct(String productId);
		
		public List<Product> viewProducts();
}
