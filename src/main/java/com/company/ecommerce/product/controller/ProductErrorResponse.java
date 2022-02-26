package com.company.ecommerce.product.controller;

public class ProductErrorResponse {


    private String message;

    public ProductErrorResponse() {
    }

    public ProductErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
