package com.tiago.almeidastore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tiago.almeidastore.dto.CustomerDTO;
import com.tiago.almeidastore.entity.Customer;
import com.tiago.almeidastore.repositories.CustomerRepository;
import com.tiago.almeidastore.service.exception.DataIntegrityException;
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

	public Customer insert(Customer obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Customer update(Customer newObj) {
		Customer obj = findById(newObj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible to delete Customer with products !");
		}
	}

	public List<CustomerDTO> findAll() {
		return repository.findAll().stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
	}

	public Page<CustomerDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest).map(obj -> new CustomerDTO(obj));
	}

	public Customer fromDTO(CustomerDTO objDTO) {
		return new Customer(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null);
	}

	private void updateData(Customer newObj, Customer obj) {
		obj.setName(newObj.getName());
		obj.setEmail(newObj.getEmail());
	}
}
