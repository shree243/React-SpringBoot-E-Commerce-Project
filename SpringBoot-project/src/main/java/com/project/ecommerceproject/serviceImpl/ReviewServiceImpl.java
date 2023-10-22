package com.project.ecommerceproject.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Product;
import com.project.ecommerceproject.Entity.Review;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.repository.ProductRepository;
import com.project.ecommerceproject.repository.ReviewRepository;
import com.project.ecommerceproject.request.ReviewRequest;
import com.project.ecommerceproject.service.ProductService;
import com.project.ecommerceproject.service.ReviewService;

@Service
public class ReviewServiceImpl  implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Review createReview(ReviewRequest req,User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product=productService.findProductById(req.getProductId());
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		productRepository.save(product);
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		return reviewRepository.getAllProductsReview(productId);
	}

	
}
