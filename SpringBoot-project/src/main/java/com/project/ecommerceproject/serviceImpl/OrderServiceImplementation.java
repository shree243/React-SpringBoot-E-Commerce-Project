package com.project.ecommerceproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Address;
import com.project.ecommerceproject.Entity.OrderEntity;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.OrderException;
import com.project.ecommerceproject.repository.CartRepository;
import com.project.ecommerceproject.repository.OrderRepository;
import com.project.ecommerceproject.service.CartService;
import com.project.ecommerceproject.service.OrderService;

@Service
public class OrderServiceImplementation implements OrderService {


	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public OrderEntity createOrder(User user, Address shippingAdress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity findOrderById(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> usersOrderHistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity placedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity confirmedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity shippedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity deliveredOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity canceledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		
	}

	
	
}
