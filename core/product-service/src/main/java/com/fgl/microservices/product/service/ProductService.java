package com.fgl.microservices.product.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fgl.microservices.product.controllers.ProductController;
import com.fgl.microservices.product.dao.ProductRepository;
import com.fgl.microservices.product.model.Product;

@Service
@Transactional
public class ProductService {
	private static final Log log = LogFactory.getLog(ProductController.class);
	public static final String productName = "created";

	@Autowired
	private ProductRepository productRepository;

	@Cacheable(value = "products")
	public List<Product> getAllProducts() {
		log.info("fetching all products");
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Cacheable(value = "products", key = "#id")
	public Product getProduct(String id) {
		log.info("fetching products for id" + id);
		return productRepository.findOne(id);
	}


	public List<Product> getProductByName(String name) {
		log.info("fetching products for name" + name);
		return productRepository.findByName(name);
	}


	public List<Product> getProductByDescription(String description) {
		log.info("fetching products for description" + description);
		return productRepository.findByDescription(description);
	}

}
