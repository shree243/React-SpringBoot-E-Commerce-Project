package com.project.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Address;
import com.project.ecommerceproject.Entity.OrderEntity;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.OrderException;

@Service
public interface OrderService {

	
	public OrderEntity createOrder(User user, Address shippingAdress);
	
	public OrderEntity findOrderById(Long orderId) throws OrderException;
	
	public List<OrderEntity> usersOrderHistory(Long userId);
	
	public OrderEntity placedOrder(Long orderId) throws OrderException;
	
	public OrderEntity confirmedOrder(Long orderId)throws OrderException;
	
	public OrderEntity shippedOrder(Long orderId) throws OrderException;
	
	public OrderEntity deliveredOrder(Long orderId) throws OrderException;
	
	public OrderEntity canceledOrder(Long orderId) throws OrderException;
	
	public List<OrderEntity>getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
	
}
