package com.capg.inventory.dao;

import java.util.List;

import com.capg.inventory.beans.CartDto;
import com.capg.inventory.beans.ProductDto;

public interface CartDao {
	
	public List<CartDto> viewCartByCustomerId(int customerId);

	public ProductDto getProduct(int productId);

	public String addProductToCart(CartDto cart);

	public boolean removeCartItem(CartDto cart);

	public CartDto viewCartByCartId(int cartId);

	public boolean updateCartQuantity(CartDto cart);

}
