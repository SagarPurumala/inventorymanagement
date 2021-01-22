package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.ProductDto;
import com.cg.ims.entity.Product;
import com.cg.ims.exception.ProductException;

public interface ProductService {

	List<Product> showallproduct();

	Product saveProduct(ProductDto productDto) throws ProductException;

	void deleteproduct(int id);
	
	float getPriceOfProduct(int productId);

	Product updateProduct(ProductDto productDto);
	
	ProductDto getProduct(int productId);

}
