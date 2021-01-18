package com.capg.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capg.inventory.beans.ProductDto;
@Repository
public class MerchantDAOImpl implements MerchantDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public ProductDto getProduct(Integer productId) {
		EntityManager manager = emf.createEntityManager();
		ProductDto productInformation = manager.find(ProductDto.class, productId);
		manager.close();
		return productInformation;
	}

	@Override
	public boolean addProduct(ProductDto product) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
		
			manager.persist(product);
			tx.commit();				
			return true;	

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	@Override
	public boolean updateProduct(ProductDto productInformation) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		boolean isUpdated = false;
		try {
			tx.begin();
			ProductDto productInfo = manager.find(ProductDto.class, productInformation.getProductId());

			if (productInfo != null) {
				if (productInformation.getProductId()!= null) {
					System.out.println(productInformation.getProductId());
					productInfo.setProductId(productInformation.getProductId());
					productInfo.setProductName(productInformation.getProductName());
					productInfo.setProductDescription(productInformation.getProductDescription());
					productInfo.setProductTag(productInformation.getProductTag());
					productInfo.setCategory(productInformation.getCategory());
					productInfo.setDiscount(productInformation.getDiscount());
					productInfo.setOriginalPrice(productInformation.getOriginalPrice());
					productInfo.setMerchantId(productInformation.getMerchantId());
					productInfo.setImage(productInformation.getImage());
					productInfo.setQuantity(productInformation.getQuantity());
					productInfo.setSize(productInformation.getSize());
					
					
					manager.persist(productInfo);
					isUpdated = true;
					tx.commit();
					
				}
			} else {

				isUpdated = false;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		manager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		EntityManager entityManager = emf.createEntityManager();
		ProductDto productInformation = entityManager.find(ProductDto.class, productId);
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(productInformation);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> viewProducts() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductDto";
		Query query = manager.createQuery(jpql);

		List<ProductDto> productList = null;
		try {
			productList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

}
