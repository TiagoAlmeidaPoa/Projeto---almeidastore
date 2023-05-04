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

import com.tiago.almeidastore.dto.CategoryDTO;
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

	public List<CategoryDTO> findAll() {
		return repository.findAll().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	public Page<CategoryDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest).map(obj -> new CategoryDTO(obj));
	}

	public Category fromDTO(CategoryDTO objDTO) {
		return new Category(objDTO.getId(), objDTO.getName());
	}

}
