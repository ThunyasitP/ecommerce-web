package com.company.ecommerce.cart.service;

public class CartDuplicateException extends RuntimeException {

    public CartDuplicateException(int productId) {
        super(String.valueOf(productId));
    }
}
