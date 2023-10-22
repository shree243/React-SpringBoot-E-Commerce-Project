package com.project.ecommerceproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceproject.Entity.OrderEntity;
import com.project.ecommerceproject.Exception.OrderException;
import com.project.ecommerceproject.response.ApiResponse;
import com.project.ecommerceproject.service.OrderService;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
	
	private OrderService orderService;
	
	public AdminOrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrderEntity>> getAllOrdersHandler(){
		List<OrderEntity> orders=orderService.getAllOrders();
		
		return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{orderId}/confirmed")
	public ResponseEntity<OrderEntity> ConfirmedOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
		OrderEntity order=orderService.confirmedOrder(orderId);
		return new ResponseEntity<OrderEntity>(order,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{orderId}/ship")
	public ResponseEntity<OrderEntity> shippedOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
		OrderEntity order=orderService.shippedOrder(orderId);
		return new ResponseEntity<OrderEntity>(order,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{orderId}/deliver")
	public ResponseEntity<OrderEntity> deliveredOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
		OrderEntity order=orderService.deliveredOrder(orderId);
		return new ResponseEntity<OrderEntity>(order,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{orderId}/cancel")
	public ResponseEntity<OrderEntity> canceledOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
		OrderEntity order=orderService.canceledOrder(orderId);
		return new ResponseEntity<OrderEntity>(order,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{orderId}/delete")
	public ResponseEntity<ApiResponse> deleteOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
		orderService.deleteOrder(orderId);
		ApiResponse res=new ApiResponse("Order Deleted Successfully",true);
		System.out.println("delete method working....");
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	}

}
