package com.capg.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.inventory.beans.CartDto;
import com.capg.inventory.beans.ProductDto;
import com.capg.inventory.response.CartResponse;
import com.capg.inventory.response.MerchantResponse;
import com.capg.inventory.service.CartService;
@RestController
@CrossOrigin("*")
public class CartController {

	@Autowired
	public CartService cartService;
	
	@GetMapping("/viewcartbycustomerid/{customerid}")
	public List<CartDto> viewCartByCustomerId(@PathVariable("customerid") int customerId,
			HttpServletRequest request) {
		return cartService.viewCartByCustomerId(customerId);
	}
	
	
	
	@PostMapping("/addproducttocart/{bookid}/{customerid}/{status}")
	public String addBookToCart(@PathVariable("bookid") int bookId, @PathVariable("customerid") int customerId,
			@PathVariable("status") String status) {
		return cartService.addProductToCart(bookId, customerId, status);
	}
	

	@DeleteMapping("/removecartitem/{cartid}")
	public boolean removeCartItem(@PathVariable("cartid") int cartId, HttpServletRequest request) {
		return cartService.removeCartItem(cartId);
	}


	@DeleteMapping("/clearcartbycustomerid/{customerid}")
	public boolean clearCartByCustomerId(@PathVariable("customerid") int customerId, HttpServletRequest request) {
		return cartService.clearCartByCustomerId(customerId);
	}

	
	@PostMapping("/updatecart/{cartId}/{newQuantity}")
	public String updateCart(@PathVariable("cartId") int cartId, @PathVariable("newQuantity") int newQuantity) {
		return cartService.updateCart(cartId, newQuantity);
	}
	
}
