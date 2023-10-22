package com.project.ecommerceproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.Product;
import com.project.ecommerceproject.Exception.ProductException;
import com.project.ecommerceproject.request.CreateProductRequest;

@Service
public interface ProductService {

	public Product createProduct(CreateProductRequest req);

	public String deleteProduct(Long productId) throws ProductException;

	public Product updateProduct(Long productId, Product product) throws ProductException;

	public Product findProductById(Long id) throws ProductException;

	public List<Product> findProductByCategory(String category);

	public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice,
			Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize);

	public List<Product> searchProduct(String query);

	List<Product> getAllProducts();
	

}
