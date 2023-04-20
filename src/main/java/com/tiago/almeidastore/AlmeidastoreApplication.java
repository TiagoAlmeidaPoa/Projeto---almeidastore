package com.tiago.almeidastore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.repositories.CategoryRepository;
import com.tiago.almeidastore.repositories.ProductRepository;

@SpringBootApplication
public class AlmeidastoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(AlmeidastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "computing");
		Category cat2 = new Category(null, "office");
		
		Product p1 = new Product(null, "computer", 5000);
		Product p2 = new Product(null, "printer", 700.90);
		Product p3 = new Product(null, "mouse", 150.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
