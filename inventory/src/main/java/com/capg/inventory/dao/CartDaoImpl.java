package com.capg.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.inventory.beans.CartDto;
import com.capg.inventory.beans.ProductDto;

@Repository
public class CartDaoImpl implements CartDao{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
//	@PersistenceContext
//	private EntityManager entityManager;

	@Override
	public List<CartDto> viewCartByCustomerId(int customerId) {
		
		EntityManager manager = emf.createEntityManager();

		String jpql = "from CartDto where customerId=:custId and status='cart'";
		TypedQuery<CartDto> query = manager.createQuery(jpql, CartDto.class);
		query.setParameter("custId", customerId);
		return query.getResultList();
	}

	@Override
	public ProductDto getProduct(int productId) {
		EntityManager manager = emf.createEntityManager();
		ProductDto productInformation = manager.find(ProductDto.class, productId);
		manager.close();
		return productInformation;
	}

	@Override
	public String addProductToCart(CartDto cart) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
		
			manager.persist(cart);
			tx.commit();				
			return "Product added to cart successfully";	

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return "Product not added";
	}

	@Override
	public boolean removeCartItem(CartDto cart) {
		EntityManager entityManager = emf.createEntityManager();
		CartDto cartInformation = entityManager.find(CartDto.class, cart.getCartId());
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(cartInformation);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public CartDto viewCartByCartId(int cartId) {
		EntityManager manager = emf.createEntityManager();
		CartDto cartInformation = manager.find(CartDto.class, cartId);
		manager.close();
		return cartInformation;
	}

	@Override
	public boolean updateCartQuantity(CartDto cart) {
		EntityManager manager = emf.createEntityManager();
		manager.merge(cart);
		return true;
	}
	

}
