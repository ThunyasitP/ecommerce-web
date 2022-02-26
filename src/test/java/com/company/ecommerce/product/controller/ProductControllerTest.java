package com.company.ecommerce.product.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("ดึงข้อมูล product แล้ว จะแสดงรายการทั้งหมด 5 รายการ")
    void success_get_products_all_show_5_products() {
        //Act
        ResponseEntity<ProductResponse[]> responseEntity = testRestTemplate.getForEntity("/products", ProductResponse[].class);
        List<ProductResponse> result = Arrays.asList(responseEntity.getBody());

        //Assert, verify
        assertEquals(5, result.size());
    }



}