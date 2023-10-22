package com.project.ecommerceproject.service;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Cart;
import com.project.ecommerceproject.Entity.CartItem;
import com.project.ecommerceproject.Entity.Product;
import com.project.ecommerceproject.Exception.CartItemException;
import com.project.ecommerceproject.Exception.UserException;
@Service
public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException,UserException;

	public CartItem isCartItemExist(Cart cart ,Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
