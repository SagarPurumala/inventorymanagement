package com.cg.ims.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.cg.ims.dto.ProductDto;
import com.cg.ims.entity.Product;

@Repository
class MerchantDaoImpl implements MerchantDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Product getProduct(int productId) {
		//EntityManager manager = emf.createEntityManager();
		Product productInformation = manager.find(Product.class, productId);
		manager.close();
		return productInformation;
//		return null;
		
		
//		Optional<Product> product = productDao.findById(productId);
//		if (product.isPresent()) {
//			return new ProductDto(product.get());
//		} else {
//			throw new ProductException("product does not exist by given id");
//		}
	}

}
