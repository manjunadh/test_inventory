package com.fgl.microservices.price.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.microservices.price.model.Price;
import com.fgl.microservices.price.service.PriceService;

@RestController
public class PriceController {
	private static final Log log = LogFactory.getLog(PriceController.class);
	
	@Autowired
	private PriceService priceService;

	@RequestMapping("/price")
	public List<Price> getPrice() {
		log.info("get all prices controller");
		return priceService.getAllPrices();
	}

	@RequestMapping("/price/{id}")
	public Price getPriceById(@PathVariable String id) {
		log.info("get price for id" + id);
		return priceService.getPriceById(id);
	}

	@RequestMapping("/price/geyBysku/{sku}")
	public List<Price> getPriceByName(@PathVariable String skuId) {
		log.info("get price for sku id" + skuId);
		return priceService.getPriceBySku(skuId);
	}

}
