package com.fgl.microservices.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fgl.microservices.product.dao.ProductRepository;
import com.fgl.microservices.product.model.Product;

@Service
@Transactional
public class ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	public static final String productName = "created";

	@Autowired
	private ProductRepository productRepository;

	@Cacheable(value = "products")
	public List<Product> getAllProducts() {
		LOGGER.info("fetching all products");
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Cacheable(value = "products", key = "#id")
	public Product getProduct(String id) {
		LOGGER.info("fetching products for id" + id);
		return productRepository.findOne(id);
	}

	@Cacheable(value = "products", key = "#id")
	public List<Product> getProductByName(String name) {
		LOGGER.info("fetching products for name" + name);
		return productRepository.findByName(name);
	}

	@Cacheable(value = "products", key = "#id")
	public List<Product> getProductByDescription(String description) {
		LOGGER.info("fetching products for description" + description);
		return productRepository.findByDescription(description);
	}

}
