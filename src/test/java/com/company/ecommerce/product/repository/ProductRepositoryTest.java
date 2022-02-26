package com.company.ecommerce.product.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

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
    @DisplayName("ส่ง London จะได้ผลลัพธ์ 1 รายการ")
    void success_find_products_by_name_show_1_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("London");

        // Assert
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("ส่ง Shirt จะได้ผลลัพธ์ 2 รายการ")
    void success_find_products_by_name_show_2_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("Shirt");

        // Assert
        assertEquals(2, result.size());
    }


    @Test
    @DisplayName("ส่ง TEST จะได้ผลลัพธ์ 0 รายการ")
    void success_find_products_by_name_show_0_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("TEST");

        // Assert
        assertEquals(0, result.size());
    }


    @Test
    @DisplayName("ส่ง shirt จะได้ผลลัพธ์ 2 รายการ")
    void success_find_products_by_name_lowercase_show_2_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("shirt");

        // Assert
        assertEquals(2, result.size());
    }


    @Test
    @DisplayName("ส่ง H&M T-Shirt จะได้ผลลัพธ์ 1 รายการ")
    void success_find_products_by_name_fullname_show_1_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("H&M T-Shirt");

        // Assert
        assertEquals(1, result.size());
    }


    @Test
    @DisplayName("ส่ง เสื้อยืด จะได้ผลลัพธ์ 3 รายการ")
    void success_find_products_by_name_thainame_show_3_product(){
        // Arrange
        Product product1 = new Product(6, "เสื้อยืดตราห่าน", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product2 = new Product(7, "เสื้อยืดตราปุ๋ย", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product3 = new Product(8, "เสื้อยืดสีขาว", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        // Act
        List<Product> result = productRepository.findProductByName("เสื้อยืด");

        // Assert
        assertEquals(3, result.size());
    }


    @Test
    @DisplayName("ส่ง เสื้อแขนยาว จะได้ผลลัพธ์ 0 รายการ")
    void success_find_products_by_name_thainame_show_0_product(){
        // Arrange
        Product product1 = new Product(6, "เสื้อยืดตราห่าน", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product2 = new Product(7, "เสื้อยืดตราปุ๋ย", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product3 = new Product(8, "เสื้อยืดสีขาว", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        // Act
        List<Product> result = productRepository.findProductByName("เสื้อแขนยาว");

        // Assert
        assertEquals(0, result.size());
    }


    @Test
    @DisplayName("ส่ง '' จะได้ผลลัพธ์ 5 รายการ")
    void success_find_products_by_name_null_show_all_product(){
        // Arrange
        // Act
        List<Product> result = productRepository.findProductByName("");

        // Assert
        assertEquals(5, result.size());
    }



    @Test
    @DisplayName("ส่ง id=2 จะได้ผลลัพธ์ True")
    void success_find_product_by_id(){
        // Arrange
        // Act
        Optional<Product>  result = productRepository.findById(2);

        // Assert
        assertTrue(result.isPresent());
    }


    @Test
    @DisplayName("ส่ง id=100 จะได้ผลลัพธ์ False")
    void success_find_product_by_no_id(){
        // Arrange
        // Act
        Optional<Product> result = productRepository.findById(100);

        // Assert
        assertFalse(result.isPresent());
    }

}