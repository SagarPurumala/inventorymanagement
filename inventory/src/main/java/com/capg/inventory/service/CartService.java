package com.capg.inventory.service;

import java.util.List;

import com.capg.inventory.beans.CartDto;

public interface CartService {

	public List<CartDto> viewCartByCustomerId(int customerId);

	public String addProductToCart(int bookId, int customerId, String status);

	public boolean removeCartItem(int cartId);

	public boolean clearCartByCustomerId(int customerId);

	public String updateCart(int cartId, int quantity);

}
