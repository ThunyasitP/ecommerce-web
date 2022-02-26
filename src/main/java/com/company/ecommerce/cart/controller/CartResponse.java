package com.company.ecommerce.cart.controller;

public class CartResponse {

    private int product_id;
    private int total;

    public CartResponse() {
    }

    public CartResponse(int product_id, int total) {
        this.product_id = product_id;
        this.total = total;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getTotal() {
        return total;
    }
}
