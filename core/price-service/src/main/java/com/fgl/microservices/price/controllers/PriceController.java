package com.fgl.microservices.price.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.microservices.price.model.Price;
import com.fgl.microservices.price.service.PriceService;

@RestController
public class PriceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
	@Autowired
	private PriceService priceService;

	@RequestMapping("/price")
	public List<Price> getPrice() {
		LOGGER.info("get all prices controller");
		return priceService.getAllPrices();
	}

	@RequestMapping("/price/{id}")
	public Price getPriceById(@PathVariable String id) {
		LOGGER.info("get price for id" + id);
		return priceService.getPriceById(id);
	}

	@RequestMapping("/price/geyBysku/{sku}")
	public List<Price> getPriceByName(@PathVariable String skuId) {
		LOGGER.info("get price for sku id" + skuId);
		return priceService.getPriceBySku(skuId);
	}

}
