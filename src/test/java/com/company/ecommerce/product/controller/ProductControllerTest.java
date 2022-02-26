package com.company.ecommerce.product.controller;

import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("ดึงข้อมูล product แล้ว จะแสดงรายการทั้งหมด 5 รายการ")
    void success_get_products_all_show_5_products() {

        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product2 = new Product(2, "CPS Jeans", "https://www.shutterstock.com/de/image-photo/bangkok-thailand-asia-august-10-2019-1475328572", 1700, 170, 60, "2022-02-14 08:30:00", "2022-02-14 08:30:00");
        Product product3 = new Product(3, "AMP Hat", "https://www.shutterstock.com/de/image-vector/be-kind-tee-t-shirt-adult-1974478163", 750, 0, 80, "2022-02-15 08:30:00", "2022-02-15 08:30:00");
        Product product4 = new Product(4, "H&M T-Shirt", "https://www.shutterstock.com/de/image-photo/new-york-circa-march-2016-close-444910246", 299, 0, 2000, "2022-02-16 08:30:00", "2022-02-16 08:30:00");
        Product product5 = new Product(5, "Anello Bag", "https://www.shutterstock.com/de/image-photo/bangkokthailand-february-252019anello-handbag-brand-japangray-1322241710", 599, 200, 100, "2022-02-17 08:30:00", "2022-02-17 08:30:00");
        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        responses.add(product2);
        responses.add(product3);
        responses.add(product4);
        responses.add(product5);
        when(productRepository.findAllProducts()).thenReturn(responses);

        // Act
        ResponseEntity<ProductResponse[]> responseEntity = testRestTemplate.getForEntity("/products", ProductResponse[].class);
        List<ProductResponse> result = Arrays.asList(responseEntity.getBody());

        // Assert
        assertEquals(5, result.size());
    }


    @Test
    @DisplayName("ดึงข้อมูล product แล้ว จะแสดงรายการทั้งหมด 1 รายการ")
    void success_get_products_all_show_1_products() {

        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        when(productRepository.findAllProducts()).thenReturn(responses);

        // Act
        ResponseEntity<ProductResponse[]> responseEntity = testRestTemplate.getForEntity("/products", ProductResponse[].class);
        List<ProductResponse> result = Arrays.asList(responseEntity.getBody());

        // Assert
        assertEquals(1, result.size());
    }


    @Test
    @DisplayName("ดึงข้อมูล product แล้ว จะแสดงรายการทั้งหมด 0 รายการ")
    void success_get_products_all_show_0_products() {

        // Arrange
        List<Product> responses = new ArrayList<>();
        when(productRepository.findAllProducts()).thenReturn(responses);

        // Act
        ResponseEntity<ProductResponse[]> responseEntity = testRestTemplate.getForEntity("/products", ProductResponse[].class);
        List<ProductResponse> result = Arrays.asList(responseEntity.getBody());

        // Assert
        assertEquals(0, result.size());
    }

}