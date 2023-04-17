package com.tiago.almeidastore.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.almeidastore.entity.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
		
	@GetMapping
	public List<Category> testando() {
		Category cat1 = new Category(1, "computing");
		Category cat2 = new Category(2, "office");
		
		List<Category> categories = new ArrayList<Category>();
		categories.addAll(Arrays.asList(cat1, cat2));
		return categories;
	}
	
}
