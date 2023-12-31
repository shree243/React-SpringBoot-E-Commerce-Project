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

import com.project.ecommerceproject.Entity.Rating;
import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.Exception.UserException;
import com.project.ecommerceproject.request.RatingRequest;
import com.project.ecommerceproject.service.RatingService;
import com.project.ecommerceproject.service.UserService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

	@Autowired
	private UserService userService;
	@Autowired
	private RatingService ratingServices;

	@PostMapping("/create")
	public ResponseEntity<Rating> createRatingHandler(@RequestBody RatingRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException {
		User user = userService.findUserProfileByJwt(jwt);
		Rating rating = ratingServices.createRating(req, user);
		return new ResponseEntity<>(rating, HttpStatus.ACCEPTED);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<List<Rating>> getProductsReviewHandler(@PathVariable Long productId) {

		List<Rating> ratings = ratingServices.getProductsRating(productId);
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
}
