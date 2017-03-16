package com.fgl.microservices.price.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fgl.microservices.price.dao.PriceRepository;
import com.fgl.microservices.price.model.Price;

@Service
@Transactional
public class PriceService {
	private static final Log log = LogFactory.getLog(PriceService.class);
	public static final String priceName = "created";
	@Autowired
	private PriceRepository priceRepository;
	@Cacheable(value = "prices")
	public List<Price> getAllPrices() {
		log.info("fetching all prices");
		List<Price> products = new ArrayList<>();
		priceRepository.findAll().forEach(products::add);
		return products;
	}
	@Cacheable(value = "prices", key = "#id")
	public Price getPriceById(String id) {
		log.info("fetching price for id" + id);
		return priceRepository.findOne(id);
	}

	public List<Price> getPriceBySku(String skuId) {
		return priceRepository.findBySkuId(skuId);
	}

	

}
