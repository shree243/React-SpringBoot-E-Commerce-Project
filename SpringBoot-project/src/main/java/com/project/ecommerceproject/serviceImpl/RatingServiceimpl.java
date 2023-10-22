package com.project.ecommerceproject.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Product;
import com.project.ecommerceproject.Entity.Rating;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.repository.RatingRepository;
import com.project.ecommerceproject.request.RatingRequest;
import com.project.ecommerceproject.service.ProductService;
import com.project.ecommerceproject.service.RatingService;

@Service
public class RatingServiceimpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private ProductService productService;

	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {

		Product product = productService.findProductById(req.getProductId());

		Rating rating = new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());

		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}

}
