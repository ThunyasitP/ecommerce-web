package com.company.ecommerce.cart.controller;

public class CartErrorResponse {

    private String message;

    public CartErrorResponse() {
    }

    public CartErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
