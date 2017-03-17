package com.fgl.microservices.composite.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fgl.microservices.commons.model.Price;
import com.fgl.microservices.commons.model.Product;
import com.fgl.microservices.composite.model.ProductDetails;


public class CompositeService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductDetails productDetails;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompositeService.class);
	public ProductDetails getProduct(String id){
		LOG.info("getting product service class");
		String productUrl = "http://35.184.125.140:9876/products/"+id;
		String priceUrl = "http://35.184.125.140:9899/price/"+id;
        LOG.debug("GetProduct from product URL: {}", productUrl);
        LOG.debug("GetProduct from price URL: {}", priceUrl);
        ResponseEntity<Product> product= restTemplate.getForEntity(productUrl,Product.class);   
        ResponseEntity<Price> price= restTemplate.getForEntity(priceUrl,Price.class);
        
        productDetails.setId(id);
        productDetails.setName(product.getBody().getName());
        productDetails.setDescription(product.getBody().getDescription());
        productDetails.setOfferPrice(price.getBody().getOfferPrice());
        productDetails.setOriginalPrice(price.getBody().getOriginalPrice());
        return productDetails;
	}
	
}
