package com.project.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Rating;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.request.RatingRequest;

@Service
public interface RatingService {

	public Rating createRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);
	
}
