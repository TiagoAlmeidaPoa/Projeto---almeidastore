package com.tiago.almeidastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.almeidastore.entity.SalesOrder;
import com.tiago.almeidastore.service.SalesOrderService;

@RestController
@RequestMapping(value = "/salesorders")
public class SalesOrderController {

	@Autowired
	private SalesOrderService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SalesOrder> findById(@PathVariable Integer id) {
		SalesOrder salesOrder = service.findById(id);
		return ResponseEntity.ok(salesOrder);
	}

}
