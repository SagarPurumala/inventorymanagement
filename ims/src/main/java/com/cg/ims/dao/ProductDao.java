package com.cg.ims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ims.dto.ProductDto;
import com.cg.ims.entity.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
	List<Product> findAll();

	List<ProductDto> findAllByMerchantId(int merchantId);
}
