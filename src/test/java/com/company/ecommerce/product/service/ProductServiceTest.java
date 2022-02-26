package com.company.ecommerce.product.service;

import com.company.ecommerce.product.controller.ProductResponse;
import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("เรียก products ได้ข้อมูล product 5 รายการ")
    void success_find_all_product_show_5_products() {

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
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findAllProducts();
        // Assert
        assertEquals(5, result.size());
    }


    @Test
    @DisplayName("เรียก products ได้ข้อมูล product 1 รายการ")
    void success_find_all_product_show_1_products() {

        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        when(productRepository.findAllProducts()).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findAllProducts();
        // Assert
        assertEquals(1, result.size());
    }


    @Test
    @DisplayName("เรียก products ได้ข้อมูล product 0 รายการ")
    void success_find_all_product_show_0_products() {

        // Arrange
        List<Product> responses = new ArrayList<>();
        when(productRepository.findAllProducts()).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findAllProducts();
        // Assert
        assertEquals(0, result.size());
    }


    @Test
    @DisplayName("ส่ง London จะได้ผลลัพธ์ 1 รายการ")
    void success_find_product_by_name_show_1_products() {
        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        when(productRepository.findProductByName("London")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("London");
        // Assert
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("ส่ง Shirt จะได้ผลลัพธ์ 2 รายการ")
    void success_find_product_by_name_show_2_products() {
        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product4 = new Product(4, "H&M T-Shirt", "https://www.shutterstock.com/de/image-photo/new-york-circa-march-2016-close-444910246", 299, 0, 2000, "2022-02-16 08:30:00", "2022-02-16 08:30:00");

        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        responses.add(product4);
        when(productRepository.findProductByName("Shirt")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("Shirt");
        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("ส่ง TEST จะได้ผลลัพธ์ 0 รายการ")
    void success_find_product_by_name_show_0_products() {
        // Arrange
        List<Product> responses = new ArrayList<>();
        when(productRepository.findProductByName("TEST")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("TEST");
        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("ส่ง shirt จะได้ผลลัพธ์ 2 รายการ")
    void success_find_product_by_lowercase_show_1_products() {
        // Arrange
        Product product1 = new Product(1, "Boy London T-Shirt", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product4 = new Product(4, "H&M T-Shirt", "https://www.shutterstock.com/de/image-photo/new-york-circa-march-2016-close-444910246", 299, 0, 2000, "2022-02-16 08:30:00", "2022-02-16 08:30:00");

        List<Product> responses = new ArrayList<>();
        responses.add(product1);
        responses.add(product4);
        when(productRepository.findProductByName("shirt")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("shirt");
        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("ส่ง H&M T-Shirt จะได้ผลลัพธ์ 1 รายการ")
    void success_find_product_by_fullname_show_1_products() {
        // Arrange
        Product product4 = new Product(4, "H&M T-Shirt", "https://www.shutterstock.com/de/image-photo/new-york-circa-march-2016-close-444910246", 299, 0, 2000, "2022-02-16 08:30:00", "2022-02-16 08:30:00");

        List<Product> responses = new ArrayList<>();
        responses.add(product4);
        when(productRepository.findProductByName("H&M T-Shirt")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("H&M T-Shirt");
        // Assert
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("ส่ง เสื้อยืด จะได้ผลลัพธ์ 3 รายการ")
    void success_find_product_by_thai_show_3_products() {
        // Arrange
        Product product6 = new Product(6, "เสื้อยืดตราห่าน", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product7 = new Product(7, "เสื้อยืดตราปุ๋ย", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        Product product8 = new Product(8, "เสื้อยืดสีขาว", "https://www.shutterstock.com/de/image-vector/grunge-london-flag-tshirt-printing-vector-337267853", 3500, 500, 50, "2022-01-13 08:30:00", "2022-01-13 08:30:00");
        List<Product> responses = new ArrayList<>();
        responses.add(product6);
        responses.add(product7);
        responses.add(product8);
        when(productRepository.findProductByName("เสื้อยืด")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("เสื้อยืด");
        // Assert
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("ส่ง เสื้อแขนยาว จะได้ผลลัพธ์ 0 รายการ")
    void success_find_product_by_thai_show_0_products() {
        // Arrange
        List<Product> responses = new ArrayList<>();
        when(productRepository.findProductByName("เสื้อแขนยาว")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("เสื้อแขนยาว");
        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("ส่ง '' จะได้ผลลัพธ์ 5 รายการ")
    void success_find_product_by_null_show_5_products() {
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
        when(productRepository.findProductByName("")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("");
        // Assert
        assertEquals(5, result.size());
    }

    @Test
    @DisplayName("ส่ง '' จะได้ผลลัพธ์ 0 รายการ เมื่อไม่มีข้อมูลใด ๆ")
    void success_find_product_by_null_and_db_null_show_0_products() {
        // Arrange
        List<Product> responses = new ArrayList<>();
        when(productRepository.findProductByName("")).thenReturn(responses);
        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> result = productService.findProductByName("");
        // Assert
        assertEquals(0, result.size());
    }

}