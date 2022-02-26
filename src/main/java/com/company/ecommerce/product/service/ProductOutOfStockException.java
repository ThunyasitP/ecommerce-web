package com.company.ecommerce.product.service;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(int productId) {
        super(String.valueOf(productId));
    }
}
