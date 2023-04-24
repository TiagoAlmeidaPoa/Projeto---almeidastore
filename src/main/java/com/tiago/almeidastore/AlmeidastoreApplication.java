package com.tiago.almeidastore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.almeidastore.entity.Address;
import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.entity.City;
import com.tiago.almeidastore.entity.Customer;
import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.entity.State;
import com.tiago.almeidastore.entity.enums.TypeCustomer;
import com.tiago.almeidastore.repositories.AddressRepository;
import com.tiago.almeidastore.repositories.CategoryRepository;
import com.tiago.almeidastore.repositories.CityRepository;
import com.tiago.almeidastore.repositories.CustomerRepository;
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
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;

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
		
		Customer customer1 = new Customer(null, "Ashley", "ashley@gmail.com", "46396501082", TypeCustomer.LEGALPERSON);
		customer1.getPhones().addAll(Arrays.asList("48956231412","51986524145"));
		
		Address address1 = new Address(null, "E Broadway St", "470", "Ap 301", "Stranger", "91420590", customer1, city1);
		Address address2 = new Address(null, "Bad boys St", "11", "casa", "Danger", "505123", customer1, city2);
		
		customer1.getAddresses().addAll(Arrays.asList(address1, address2));
		
		customerRepository.saveAll(Arrays.asList(customer1));
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
	}

}
