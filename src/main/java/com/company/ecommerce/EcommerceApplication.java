package com.company.ecommerce;

import com.company.ecommerce.cart.repository.CartRepository;
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

	@Autowired
	private CartRepository cartRepository;

	@PostConstruct
	public void start(){
		Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 1, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
		Product product2 = new Product(2, "CPS Jeans", "https://www.shutterstock.com/de/image-photo/bangkok-thailand-asia-august-10-2019-1475328572", 1700, 170, 60, "2022-02-14 08:30:00", "2022-02-14 08:30:00");
		Product product3 = new Product(3, "AMP Hat", "https://www.shutterstock.com/de/image-vector/be-kind-tee-t-shirt-adult-1974478163", 750, 0, 80, "2022-02-15 08:30:00", "2022-02-15 08:30:00");
		Product product4 = new Product(4, "H&M T-Shirt", "https://www.shutterstock.com/de/image-photo/new-york-circa-march-2016-close-444910246", 299, 0, 2000, "2022-02-16 08:30:00", "2022-02-16 08:30:00");
		Product product5 = new Product(5, "Anello Bag", "https://www.shutterstock.com/de/image-photo/bangkokthailand-february-252019anello-handbag-brand-japangray-1322241710", 599, 200, 100, "2022-02-17 08:30:00", "2022-02-17 08:30:00");
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		productRepository.save(product5);




	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
