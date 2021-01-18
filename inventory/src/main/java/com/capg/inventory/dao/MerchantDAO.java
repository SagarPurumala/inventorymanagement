package com.capg.inventory.dao;

import java.util.List;

import com.capg.inventory.beans.ProductDto;

public interface MerchantDAO {
    public ProductDto getProduct(Integer productId);

	public boolean addProduct(ProductDto productInformation);

	public boolean updateProduct(ProductDto productInformation);

	public boolean deleteProduct(Integer productId);
	
	public List<ProductDto> viewProducts();

	

}
