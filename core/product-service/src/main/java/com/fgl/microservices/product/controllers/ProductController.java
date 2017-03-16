package com.fgl.microservices.product.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.microservices.product.model.Product;
import com.fgl.microservices.product.service.ProductService;

@RestController
public class ProductController {
	private static final Log log = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> getProducts() {
		log.info("getting all products controller");
		return productService.getAllProducts();
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		log.info("getting all product by id controller");
		return productService.getProduct(id);
	}

	@RequestMapping("/products/geyByName/{name}")
	public List<Product> getByName(@PathVariable String name) {
		log.info("getting all product by name controller");
		return productService.getProductByName(name);
	}

	@RequestMapping("/products/getbydescription/{description}")
	public List<Product> getByDescription(@PathVariable String description) {
		log.info("getting all product by description");
		return productService.getProductByDescription(description);
	}
}
