package com.company.ecommerce.cart.controller;

public class CartRequestAddCart {

    private int product_id;
    private int member_id;
    private int total;

    public CartRequestAddCart() {
    }

    public CartRequestAddCart(int product_id, int member_id, int total) {
        this.product_id = product_id;
        this.member_id = member_id;
        this.total = total;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
