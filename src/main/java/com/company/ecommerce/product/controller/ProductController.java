package com.company.ecommerce.product.controller;

import com.company.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductResponse> getProductsAll(){
        List<ProductResponse> responses = productService.findAllProducts();
        return responses;
    }
}
