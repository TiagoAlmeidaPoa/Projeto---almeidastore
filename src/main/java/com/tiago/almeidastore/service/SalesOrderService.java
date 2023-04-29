package com.tiago.almeidastore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.almeidastore.entity.SalesOrder;
import com.tiago.almeidastore.repositories.SalesOrderRepository;
import com.tiago.almeidastore.service.exception.ObjectNotFoundException;

@Service
public class SalesOrderService {

	@Autowired
	private SalesOrderRepository repository;

	public SalesOrder findById(Integer id) {
		Optional<SalesOrder> salesOrder = repository.findById(id);
		return salesOrder.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + " TYPE: " + SalesOrder.class.getName()));
	}

}
