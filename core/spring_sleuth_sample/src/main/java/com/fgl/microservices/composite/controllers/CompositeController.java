package com.fgl.microservices.composite.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CompositeController {
	private static final Log log = LogFactory.getLog(CompositeController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/products")
	public List<?> getAllProducts() {

		String productUrl = "http://35.184.125.140:9876/products";
		log.info("url is" + productUrl);
		return this.restTemplate.getForObject(productUrl, List.class);
	}

	@RequestMapping("/prices")
	public List<?> getAllPrices() {
		String priceUrl = "http://35.184.125.140:9899/price";
		log.info("url is" + priceUrl);
		return this.restTemplate.getForObject(priceUrl, List.class);
	}

	@RequestMapping("/")
	public String hi() throws InterruptedException {
		log.info("Home page");
		return "HomePage";
	}

}
