package com.microservices.composite.controllers;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.composite.model.ProductDetail;
import com.microservices.composite.services.CompositeService;

@RestController
public class CompositeController {
	private static final Log log = LogFactory.getLog(CompositeController.class);
	
	private CompositeService compositeService;
	@Autowired
	private Random random;


	@RequestMapping("/")
	public String hi() throws InterruptedException {
		Thread.sleep(this.random.nextInt(1000));
		log.info("Home page");
		return "Home Page for Composite";
	}

	@RequestMapping("/products/{id}")
	public ProductDetail getProductById(@PathVariable String id) {
		log.info("Controller getting product details for id" + id);
		return compositeService.getProductById(id);
	}

}
