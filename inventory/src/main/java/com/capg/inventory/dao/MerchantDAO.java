package com.capg.inventory.dao;

import java.util.List;

import com.capg.inventory.beans.Product;

public interface MerchantDAO {
    public Product getProduct(String productId);

	public boolean addProduct(Product productInformation);

	public boolean updateProduct(Product productInformation);

	public boolean deleteProduct(String productId);
	
	public List<Product> viewProducts();

	

}
