package com.microservices.composite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.composite.model.Price;
import com.microservices.composite.model.Product;
import com.microservices.composite.model.ProductDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CompositeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeService.class);
	@Autowired
	private Tracer tracer;


	@Bean
	public RestTemplate restTemplate() {
		return restTemplate();
	}

	@Async
	@HystrixCommand(fallbackMethod = "fallbackgetProductById")
	public ProductDetail getProductById(String id) {
		LOGGER.info("getting product and price information for id" + id);
		try{
		this.tracer.addTag("id is ", id);
		ProductDetail productDetail = new ProductDetail();
		Product product = restTemplate().getForObject("localhost:9876/products/"+id, Product.class);
		Price price = restTemplate().getForObject("localhost:9899/price/"+id, Price.class);
		productDetail.setId(id);
		if(product != null){
			productDetail.setName(product.getName());
			productDetail.setDescription(product.getDescription());
		}else{
			LOGGER.info("product is null");
		}
		
		if(price != null){
		productDetail.setOriginalPrice(price.getOriginalPrice());
		productDetail.setOfferPrice(price.getOfferPrice());
		}else{
			LOGGER.info("price is null");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ProductDetail fallbackgetProductById(String id) {
	    return null;
	}

}
