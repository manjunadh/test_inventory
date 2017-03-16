package com.fgl.microservices.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fgl.microservices.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	public List<Product> findByName(String name);

	public List<Product> findByDescription(String description);
}