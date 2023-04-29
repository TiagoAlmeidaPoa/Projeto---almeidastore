package com.tiago.almeidastore;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.almeidastore.entity.Address;
import com.tiago.almeidastore.entity.BilletPayment;
import com.tiago.almeidastore.entity.CardPayment;
import com.tiago.almeidastore.entity.Category;
import com.tiago.almeidastore.entity.City;
import com.tiago.almeidastore.entity.Customer;
import com.tiago.almeidastore.entity.OrderItem;
import com.tiago.almeidastore.entity.Payment;
import com.tiago.almeidastore.entity.Product;
import com.tiago.almeidastore.entity.SalesOrder;
import com.tiago.almeidastore.entity.State;
import com.tiago.almeidastore.entity.enums.PaymentStatus;
import com.tiago.almeidastore.entity.enums.TypeCustomer;
import com.tiago.almeidastore.repositories.AddressRepository;
import com.tiago.almeidastore.repositories.CategoryRepository;
import com.tiago.almeidastore.repositories.CityRepository;
import com.tiago.almeidastore.repositories.CustomerRepository;
import com.tiago.almeidastore.repositories.OrderItemRepository;
import com.tiago.almeidastore.repositories.PaymentRepository;
import com.tiago.almeidastore.repositories.ProductRepository;
import com.tiago.almeidastore.repositories.SalesOrderRepository;
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
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

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
		Address address2 = new Address(null, "Bad boys St", "11", "house", "Danger", "505123", customer1, city2);
		
		customer1.getAddresses().addAll(Arrays.asList(address1, address2));
		
		customerRepository.saveAll(Arrays.asList(customer1));
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		SalesOrder sOrder1 = new SalesOrder(null, sdf.parse("30/09/2017 10:32"), customer1, address1);
		SalesOrder sOrder2 = new SalesOrder(null, sdf.parse("10/10/2017 19:35"), customer1, address2);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.FINISHED, sOrder1, 6);
		sOrder1.setPayment(pay1);
		
		Payment pay2 = new BilletPayment(null, PaymentStatus.PENDING, sOrder2, sdf.parse("20/10/2017 00:00"), null);
		sOrder2.setPayment(pay2);
		
		customer1.getSalesOrders().addAll(Arrays.asList(sOrder1, sOrder2));
		
		salesOrderRepository.saveAll(Arrays.asList(sOrder1, sOrder2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem oi1 = new OrderItem(sOrder1, p1, 0.00, 1, 5000.00);
		OrderItem oi2 = new OrderItem(sOrder1, p3, 0.00, 2, 300.00);
		OrderItem oi3 = new OrderItem(sOrder2, p2, 100.00, 1, 600.00);
		
		sOrder1.getItems().addAll(Arrays.asList(oi1, oi2));
		sOrder2.getItems().addAll(Arrays.asList(oi3));
		
		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi3));
		p3.getItems().addAll(Arrays.asList(oi2));
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}
