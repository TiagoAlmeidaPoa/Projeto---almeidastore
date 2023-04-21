package com.tiago.almeidastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category cat = service.findById(id);
		return ResponseEntity.ok(cat);
	}

}
