package com.project.ecommerceproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceproject.Entity.Address;
import com.project.ecommerceproject.Entity.OrderEntity;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.OrderException;
import com.project.ecommerceproject.Exception.UserException;
import com.project.ecommerceproject.service.OrderService;
import com.project.ecommerceproject.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<OrderEntity> createOrderHandler(@RequestBody Address spippingAddress,
			@RequestHeader("Authorization") String jwt) throws UserException {

		User user = userService.findUserProfileByJwt(jwt);
		OrderEntity order = orderService.createOrder(user, spippingAddress);

		return new ResponseEntity<OrderEntity>(order, HttpStatus.OK);

	}

	@GetMapping("/user")
	public ResponseEntity<List<OrderEntity>> usersOrderHistoryHandler(@RequestHeader("Authorization") String jwt)
			throws OrderException, UserException {

		User user = userService.findUserProfileByJwt(jwt);
		List<OrderEntity> orders = orderService.usersOrderHistory(user.getId());
		return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderEntity> findOrderHandler(@PathVariable Long orderId,
			@RequestHeader("Authorization") String jwt) throws OrderException, UserException {

		User user = userService.findUserProfileByJwt(jwt);
		OrderEntity orders = orderService.findOrderById(orderId);
		return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
	}

}
