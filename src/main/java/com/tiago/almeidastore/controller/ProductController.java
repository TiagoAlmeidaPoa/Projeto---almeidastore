package com.tiago.almeidastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
	Product prod = service.findById(id);
		return ResponseEntity.ok(prod);
	}
	
}
