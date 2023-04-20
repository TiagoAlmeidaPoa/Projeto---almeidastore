package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
