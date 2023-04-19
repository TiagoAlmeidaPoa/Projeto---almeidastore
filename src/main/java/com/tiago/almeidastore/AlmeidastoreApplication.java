package com.tiago.almeidastore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.repositories.CategoryRepository;

@SpringBootApplication
public class AlmeidastoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(AlmeidastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "computing");
		Category cat2 = new Category(null, "office");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
