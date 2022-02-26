package com.company.ecommerce;

import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void start(){
		Product product = new Product(1, "name", "img", 100, 2, 4, "2022-02-22 08:30:00", "2022-02-22 08:30:00");
		productRepository.save(product);
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
