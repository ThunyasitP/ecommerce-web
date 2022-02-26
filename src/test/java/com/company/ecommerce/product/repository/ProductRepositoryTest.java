package com.company.ecommerce.product.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("findProductsAll()")
    void findProductsAll(){
        // Arrange
        Product product1 = new Product(6, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        productRepository.save(product1);
        // Act
        List<Product> result = productRepository.findAllProducts();

        // Assert
        assertEquals(6, result.size());
    }


    @Test
    @DisplayName("findProductsByName()")
    void findProductsByName(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("AMP");

        // Assert
        assertEquals(1, result.size());
    }

}