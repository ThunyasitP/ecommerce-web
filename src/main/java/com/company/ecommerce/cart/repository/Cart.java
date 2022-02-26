package com.company.ecommerce.cart.repository;


import javax.persistence.*;

@Entity
@IdClass(CartKey.class)
public class Cart {

    @Id
    private int member_id;
    @Id
    private int product_id;
    private int total;

    public Cart() {
    }

    public Cart(int member_id, int product_id, int total) {
        this.member_id = member_id;
        this.product_id = product_id;
        this.total = total;
    }

    public int getMember_id() {
        return member_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getTotal() {
        return total;
    }
}