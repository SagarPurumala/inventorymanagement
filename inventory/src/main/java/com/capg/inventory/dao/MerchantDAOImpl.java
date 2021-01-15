package com.capg.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capg.inventory.beans.Product;
@Repository
public class MerchantDAOImpl implements MerchantDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public Product getProduct(String productId) {
		EntityManager manager = emf.createEntityManager();
		Product productInformation = manager.find(Product.class, productId);
		manager.close();
		return productInformation;
	}

	@Override
	public boolean addProduct(Product product) {
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
	public boolean updateProduct(Product productInformation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(String productId) {
		EntityManager entityManager = emf.createEntityManager();
		Product productInformation = entityManager.find(Product.class, productId);
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
	public List<Product> viewProducts() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from Product";
		Query query = manager.createQuery(jpql);

		List<Product> productList = null;
		try {
			productList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

}
