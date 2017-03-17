package com.fgl.microservices.composite.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fgl.microservices.commons.model.Product;


public class CompositeService {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompositeService.class);
	public ResponseEntity<Product> getProduct(){
		LOG.info("getting product service class");
		String url = "http://35.184.125.140:9876/products/pro001" ;
        LOG.debug("GetProduct from URL: {}", url);
        ResponseEntity<Product> product= restTemplate.getForEntity(url, Product.class);       
        return product;
	}
	
}
