package com.tiago.almeidastore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.repositories.CategoryRepository;
import com.tiago.almeidastore.service.exception.DataIntegrityException;
import com.tiago.almeidastore.service.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category findById(Integer id) {
		Optional<Category> cat1 = repository.findById(id);
		return cat1.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + ", Type: " + Category.class.getName()));
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Category update(Category obj) {
		findById(obj.getId());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible to delete category with products !");
		}
	}

}
