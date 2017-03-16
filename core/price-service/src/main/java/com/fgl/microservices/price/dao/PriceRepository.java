package com.fgl.microservices.price.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fgl.microservices.price.model.Price;

public interface PriceRepository extends CrudRepository<Price, String> {
	public List<Price> findBySkuId(String skuId);
}