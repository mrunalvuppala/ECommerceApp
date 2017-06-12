package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.models.Products;

public interface ProductRepository extends CrudRepository<Products, Integer> {
	
	

}
