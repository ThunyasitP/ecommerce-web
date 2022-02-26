package com.company.ecommerce.product.service;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int productId) {
        super(String.valueOf(productId));
    }
}
