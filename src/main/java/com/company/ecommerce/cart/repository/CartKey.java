package com.company.ecommerce.cart.repository;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CartKey implements Serializable {

    private int member_id;
    private int product_id;

    public CartKey() {
    }

    public CartKey(int member_id, int product_id) {
        this.member_id = member_id;
        this.product_id = product_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
