package com.project.ecommerceproject.service;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Cart;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.request.AddItemRequest;

@Service
public interface CartService {

	public Cart createCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
	
}
