package com.fgl.microservices.product.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.microservices.product.model.Product;
import com.fgl.microservices.product.service.ProductService;

@RestController
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> getProducts() {
		LOGGER.info("getting all products controller");
		return productService.getAllProducts();
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		LOGGER.info("getting all product by id controller");
		return productService.getProduct(id);
	}

	@RequestMapping("/products/geyByName/{name}")
	public List<Product> getByName(@PathVariable String name) {
		LOGGER.info("getting all product by name controller");
		return productService.getProductByName(name);
	}

	@RequestMapping("/products/getbydescription/{description}")
	public List<Product> getByDescription(@PathVariable String description) {
		LOGGER.info("getting all product by description");
		return productService.getProductByDescription(description);
	}
}
