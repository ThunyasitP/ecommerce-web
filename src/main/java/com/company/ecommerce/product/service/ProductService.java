package com.company.ecommerce.product.service;

import com.company.ecommerce.product.controller.ProductResponse;
import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductResponse convertProductRepositoryToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getImage(),
                product.getPrice(),
                product.getDiscount(),
                product.getTotal_stock());

    }

    public List<ProductResponse> findAllProducts() {
        List<Product> result = productRepository.findAllProducts();
        List<ProductResponse> responses = new ArrayList<>();
        result.forEach(product -> {
            responses.add(convertProductRepositoryToResponse(product));
        });
        return responses;
    }

    public List<ProductResponse> findProductByName(String name) {
        List<Product> result = productRepository.findProductByName(name);
        List<ProductResponse> responses = new ArrayList<>();
        result.forEach(product -> {
            responses.add(convertProductRepositoryToResponse(product));
        });
        return responses;
    }


    public ProductResponse findProductById(int productId) {
        Optional<Product> product = productRepository.findProductById(productId);
        ProductResponse response = convertProductRepositoryToResponse(product.get());
        return response;
    }


}
