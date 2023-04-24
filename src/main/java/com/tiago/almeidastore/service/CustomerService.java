package com.tiago.almeidastore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.almeidastore.entity.Customer;
import com.tiago.almeidastore.repositories.CustomerRepository;
import com.tiago.almeidastore.service.exception.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer findById(Integer id) {
		Optional<Customer> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + ", Type: " + Customer.class.getName()));
	}
}
