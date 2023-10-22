package com.project.ecommerceproject.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private OrderEntity order;

	@ManyToOne
	private Product product;

	private String size;

	private int quantity;

	private Integer price;

	private Integer discountedPrice;

	private Long userId;

	private LocalDateTime deliveryDate;
}
