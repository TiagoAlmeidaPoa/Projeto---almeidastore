package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
