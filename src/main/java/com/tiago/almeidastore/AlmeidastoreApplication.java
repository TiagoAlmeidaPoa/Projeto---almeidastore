package com.tiago.almeidastore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.entity.City;
import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.entity.State;
import com.tiago.almeidastore.repositories.CategoryRepository;
import com.tiago.almeidastore.repositories.CityRepository;
import com.tiago.almeidastore.repositories.ProductRepository;
import com.tiago.almeidastore.repositories.StateRepository;

@SpringBootApplication
public class AlmeidastoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;

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

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		State state1 = new State(null, "Montana");
		State state2 = new State(null, "Florida");

		City city1 = new City(null, "Helena", state1);
		City city2 = new City(null, "Tallahassee", state2);
		City city3 = new City(null, "Miami", state2);
		City city4 = new City(null, "Key West", state2);

		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2,city3,city4));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3, city4));
		
		

	}

}
