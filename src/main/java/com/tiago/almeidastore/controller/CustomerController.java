package com.tiago.almeidastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.almeidastore.entity.Customer;
import com.tiago.almeidastore.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id) {
		Customer obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
}
