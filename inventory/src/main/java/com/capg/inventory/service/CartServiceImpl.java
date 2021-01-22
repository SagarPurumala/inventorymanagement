package com.capg.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventory.beans.CartDto;
import com.capg.inventory.beans.ProductDto;
import com.capg.inventory.dao.CartDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	public CartDao cartDao;
	
	@Override
	public List<CartDto> viewCartByCustomerId(int customerId) {
		List<CartDto> reviewList = cartDao.viewCartByCustomerId(customerId);
		return reviewList;
	}

	@Override
	public String addProductToCart(int productId, int customerId, String status) {
		ProductDto product = cartDao.getProduct(productId);
		List<CartDto> cartList = cartDao.viewCartByCustomerId(customerId);
		int quantity = 1;
		CartDto cartInfo = new CartDto();

//		if (product == null) {
//			throw new ProductNotFoundException();
//		}

		if (cartList.isEmpty()) {
			float subTotal = product.getDiscountprice();
			cartInfo.setProduct(product);
			cartInfo.setQuantity(quantity);
			cartInfo.setSubTotal(subTotal);
			cartInfo.setCustomerId(customerId);
//		    cartInfo.setStatus(status);
			return cartDao.addProductToCart(cartInfo);
		} else {

			for (CartDto cart1 : cartList) {
				if (cart1.getProduct().getProductId() == productId) {
					int cartId = cart1.getCartId();
					int quan = cart1.getQuantity();
					int updatedQuantity = quan + 1;
					updateCart(cartId, updatedQuantity);
					return cartDao.addProductToCart(cart1);
				}

			}

			float subTotal = product.getDiscountprice();
			cartInfo.setProduct(product);
			cartInfo.setQuantity(quantity);
			cartInfo.setSubTotal(subTotal);
			cartInfo.setCustomerId(customerId);
			cartInfo.setStatus(status);
			return cartDao.addProductToCart(cartInfo);
		}
	}

	@Override
	public boolean removeCartItem(int cartId) {
		CartDto cart = cartDao.viewCartByCartId(cartId);
		return cartDao.removeCartItem(cart);
	}

	@Override
	public boolean clearCartByCustomerId(int customerId) {
		List<CartDto> carts = cartDao.viewCartByCustomerId(customerId);
		int i = 0;
		while (i < carts.size()) {
			cartDao.removeCartItem(carts.get(i));
			i++;
		}
		return true;
	}

	@Override
	public String updateCart(int cartId, int quantity) {
		CartDto cart = cartDao.viewCartByCartId(cartId);
//		if (quantity < 0) {
//			throw new InvalidQuantityException();
//		} else {
			float updatedSubtotal = quantity * cart.getProduct().getDiscountprice();
			cart.setQuantity(quantity);
			cart.setSubTotal(updatedSubtotal);
			cartDao.updateCartQuantity(cart);
//		}
		return "Cart Updated";
	}

}
