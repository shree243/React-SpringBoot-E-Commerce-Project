package com.project.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Review;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.request.ReviewRequest;

@Service
public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;

	public List<Review> getAllReview(Long productId);

}
