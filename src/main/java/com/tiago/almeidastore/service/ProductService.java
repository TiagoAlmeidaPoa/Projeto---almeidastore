package com.tiago.almeidastore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.repositories.ProductRepository;
import com.tiago.almeidastore.service.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product findById(Integer id) {
		Optional<Product> prod1 = repository.findById(id);
		return prod1.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + ", Type: " + Product.class.getName()));
	}

}
