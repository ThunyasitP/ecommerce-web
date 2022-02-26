package com.company.ecommerce.product.service;

import com.company.ecommerce.product.controller.ProductResponse;
import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> findAllProducts(){
        List<Product> result =  productRepository.findAllProducts();
        List<ProductResponse> responses = new ArrayList<>();
        result.forEach(product -> {
            responses.add(new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getImage(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getTotal_stock())
            );
        });
        return responses;
    }

}
