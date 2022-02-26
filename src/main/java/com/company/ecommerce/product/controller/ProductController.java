package com.company.ecommerce.product.controller;

import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<ProductResponse> getProductsAll(){
        List<Product> result =  productRepository.findAllProducts();
        List<ProductResponse> responses = new ArrayList<>();
        result.forEach(product -> {
            responses.add(new ProductResponse(product.getId(), product.getName(), product.getImage(), product.getPrice(), product.getDiscount(), product.getTotal_stock()));
        });


        return responses;
    }
}
